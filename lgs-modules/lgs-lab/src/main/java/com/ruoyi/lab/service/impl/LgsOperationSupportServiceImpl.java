package com.ruoyi.lab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.LgsMail;
import com.ruoyi.lab.domain.LgsTasksBacklog;
import com.ruoyi.lab.mapper.LgsMailMapper;
import com.ruoyi.lab.mapper.LgsOperationPersonnelMapper;
import com.ruoyi.lab.mapper.LgsTasksBacklogMapper;
import com.ruoyi.lab.utils.LGSDateUtils;
import com.ruoyi.lab.utils.LgsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsOperationSupportMapper;
import com.ruoyi.lab.domain.LgsOperationSupport;
import com.ruoyi.lab.service.ILgsOperationSupportService;

import javax.annotation.Resource;

/**
 * 运维支持Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Service
public class LgsOperationSupportServiceImpl implements ILgsOperationSupportService 
{
    @Resource
    private LgsOperationSupportMapper lgsOperationSupportMapper;
    @Resource
    private LgsMailMapper lgsMailMapper;
    @Resource
    private LgsTasksBacklogMapper lgsTasksBacklogMapper;
    @Resource
    private LgsOperationPersonnelMapper lgsOperationPersonnelMapper;

    Logger logger = LoggerFactory.getLogger(LgsOperationSupportServiceImpl.class);


    /**
     * 查询运维支持
     * 
     * @param id 运维支持主键
     * @return 运维支持
     */
    @Override
    public LgsOperationSupport selectLgsOperationSupportById(Long id)
    {
        return lgsOperationSupportMapper.selectLgsOperationSupportById(id);
    }

    /**
     * 查询运维支持列表
     * 
     * @param lgsOperationSupport 运维支持
     * @return 运维支持
     */
    @Override
    public List<LgsOperationSupport> selectLgsOperationSupportList(LgsOperationSupport lgsOperationSupport)
    {
        return lgsOperationSupportMapper.selectLgsOperationSupportList(lgsOperationSupport);
    }

    /**
     * 新增运维支持
     * 
     * @param lgsOperationSupport 运维支持
     * @return 结果
     */
    @Override
    public int insertLgsOperationSupport(LgsOperationSupport lgsOperationSupport)
    {
        lgsOperationSupport.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationSupportMapper.insertLgsOperationSupport(lgsOperationSupport);
    }

    /**
     * 修改运维支持
     * 
     * @param lgsOperationSupport 运维支持
     * @return 结果
     */
    @Override
    public int updateLgsOperationSupport(LgsOperationSupport lgsOperationSupport)
    {
        lgsOperationSupport.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationSupportMapper.updateLgsOperationSupport(lgsOperationSupport);
    }

    /**
     * 批量删除运维支持
     * 
     * @param ids 需要删除的运维支持主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationSupportByIds(Long[] ids)
    {
        return lgsOperationSupportMapper.deleteLgsOperationSupportByIds(ids);
    }

    /**
     * 删除运维支持信息
     * 
     * @param id 运维支持主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationSupportById(Long id)
    {
        return lgsOperationSupportMapper.deleteLgsOperationSupportById(id);
    }

    /**
     　　* @description: 查询运维任务列表
     　　* @param
     　　* @return
     　　* @throws
     　　* @author lgn
     　　* @date 2022/9/1 17:37
     　　*/
    @Override
    public List<LgsOperationSupport> getOperationlistByDemandId(Long demandId) {
        return lgsOperationSupportMapper.getOperationlistByDemandId(demandId);
    }

    /**
     * 轮询运维任务
     * @return
     */
    @Override
    public String pollingOperationTask() {
        logger.info("-----取出还在有效期的任务！");
        LgsOperationSupport lgsOperationSupport=new LgsOperationSupport();
        List<LgsOperationSupport> list=lgsOperationSupportMapper.selectLgsOperationTaskList(lgsOperationSupport);//有效的任务

        logger.info("-----取出当前日期跟运维规则中的日期比较！");
        threadProcessingTask(list);
        return null;
    }

    /**
     * 并发处理
     * @param list
     */
    public void threadProcessingTask(List<LgsOperationSupport> list) {
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
        //Runtime.getRuntime().availableProcessors() 获取系统可被利用的进程数
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < list.size(); i++) {
            final int index = i;
            LgsOperationSupport support=list.get(i);
            int TaskRules=support.getTaskRules();//运维周期;0：每隔x天1：每月2：每隔x月3：每半年4：每年

            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (null != support){
                cachedThreadPool.execute(new Runnable() {//execute方法,可以看异常输出在控制台，而submit在控制台没有直接输出，必须调用Future.get()方法时，可以捕获到异常。
                    @Override
                    public void run() {
                        if (null!=support.getCompletionTime()){//设备下发时间（任务起始日期）

                            if (0==TaskRules){//每隔x天
                                if (0==support.getDateInterval()){//如果输入每隔0天，就是每天都需要执行此任务。
                                    Generate_to_do(support);//发送站内信
                                }else {//提前通知

                                    LGSDateUtils dateUtils=new LGSDateUtils();
                                    if (dateUtils.x_date(support)){
                                        Generate_to_do(support);//发送站内信
                                    };
                                }
                            }
                            if (1==TaskRules){//每月
                                LGSDateUtils dateUtils=new LGSDateUtils();
                                if (dateUtils.each_month(support)){
                                    Generate_to_do(support);//发送站内信
                                }
                            }
                            if (2==TaskRules){//每隔x月
                                if (0==support.getDateInterval()){//如果输入每隔0月，就是每月都需要执行此任务。
                                    LGSDateUtils dateUtils=new LGSDateUtils();
                                    if (dateUtils.each_month(support)){
                                        Generate_to_do(support);//发送站内信
                                    }
                                }else {//提前通知
                                    LGSDateUtils dateUtils=new LGSDateUtils();
                                    if (dateUtils.x_month(support)){
                                        Generate_to_do(support);//发送站内信
                                    }
                                }

                            }
                            if (3==TaskRules){//每半年
                                support.setDateInterval(6);//周期6个月

                                LGSDateUtils dateUtils=new LGSDateUtils();
                                if (dateUtils.x_month(support)){
                                    Generate_to_do(support);//发送站内信
                                }
                            }
                            if (4==TaskRules){//每年

                                LGSDateUtils dateUtils=new LGSDateUtils();
                                if (dateUtils.a_year(support)){
                                    Generate_to_do(support);//发送站内信
                                };
                            }


                        }

                    }
                });
            }


        }
        cachedThreadPool.shutdown();
    }

    /**
     * 生成站内信，待办
     */
    public void Generate_to_do(LgsOperationSupport lgsOperationSupport){
        logger.info("任务id："+lgsOperationSupport.getId()+"-----符合条件的任务，发送站内信！");
        List<String> codes=new ArrayList<>();

        if ("0".equals(lgsOperationSupport.getExecutiveRole())){//人员类别;0：硬件支持人员，1：软件支持人员，2：全部
            codes.add(LgsConstants.SYS_POST_HSSP);
        }
        if ("1".equals(lgsOperationSupport.getExecutiveRole())){//人员类别;0：硬件支持人员，1：软件支持人员，2：全部
            codes.add(LgsConstants.SYS_POST_SSSP);
        }
        if ("2".equals(lgsOperationSupport.getExecutiveRole())){//人员类别;0：硬件支持人员，1：软件支持人员，2：全部
            codes.add(LgsConstants.SYS_POST_HSSP);
            codes.add(LgsConstants.SYS_POST_SSSP);
        }

        List<Long> perList=lgsOperationPersonnelMapper.selectOperationUserIdList(codes);//取出运维人员名单

        perList.stream().forEach(userid ->{
                    LgsMail lgsMail=new LgsMail();
                    lgsMail.setSiteId(lgsOperationSupport.getSiteId());
                    lgsMail.setSender("0");
                    lgsMail.setReceiver(userid.toString());//运维人id
                    lgsMail.setTitle(LgsConstants.TASK_TIMING_MAIL_TITLE);
                    lgsMail.setContent(lgsOperationSupport.getTaskDescribe());
                    lgsMail.setMailType(4);//信件类别;0:需求，1:需求变更，2：设备退役申请，3：日常保修，4：运维任务
                    lgsMail.setCreatedBy("1");//管理员
                    lgsMailMapper.insertLgsMail(lgsMail);//发送站内信！

                    LgsTasksBacklog lgsTasksBacklog=new LgsTasksBacklog();
                    lgsTasksBacklog.setSiteId(lgsOperationSupport.getSiteId());
                    lgsTasksBacklog.setOperationSupportId(lgsOperationSupport.getId());
                    lgsTasksBacklog.setUserId(userid.toString());
                    lgsTasksBacklog.setSubtask(lgsOperationSupport.getSubtask());//子任务
                    lgsTasksBacklog.setCreatedBy("1");//管理员
                    lgsTasksBacklogMapper.insertLgsTasksBacklog(lgsTasksBacklog);//发送待办信息
                }
                );


    }

}
