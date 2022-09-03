package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 运维任务规则对象 lgs_operation_task_rules
 * 
 * @author lgn
 * @date 2022-08-22
 */
public class LgsOperationTaskRules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 站点id */
    @Excel(name = "站点id")
    private String siteId;

    /** 是否是初始化数据;是否是初始化数据0：否1：是 */
    @Excel(name = "是否是初始化数据;是否是初始化数据0：否1：是")
    private Integer isInitialization;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 运维周期;0：每隔x天1：每月2：每隔x月3：每半年4：每年 */
    @Excel(name = "运维周期;0：每隔x天1：每月2：每隔x月3：每半年4：每年")
    private Integer taskRules;

    /** 日期间隔;日期间隔：允许输入0和正整数 */
    @Excel(name = "日期间隔;日期间隔：允许输入0和正整数")
    private Integer dateInterval;

    /** 提前提醒天数;仅支持输入0与正整数。 */
    @Excel(name = "提前提醒天数;仅支持输入0与正整数。")
    private Integer reminderDate;

    /** 人员类别;0：硬件支持人员，1：软件支持人员，2：供应商支持人员，3：全部 */
    @Excel(name = "人员类别;0：硬件支持人员，1：软件支持人员，2：供应商支持人员，3：全部")
    private String executiveRole;

    /** 描述 */
    @Excel(name = "描述")
    private String taskDescribe;

    /** 子任务 */
    @Excel(name = "子任务")
    private String subtask;

    /** 0：否，1：是 */
    @Excel(name = "0：否，1：是")
    private Integer isDisable;

    /** 删除状态;0：有效，1：无效 */
    @Excel(name = "删除状态;0：有效，1：无效")
    private Integer delFlag;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSiteId(String siteId) 
    {
        this.siteId = siteId;
    }

    public String getSiteId() 
    {
        return siteId;
    }
    public void setIsInitialization(Integer isInitialization) 
    {
        this.isInitialization = isInitialization;
    }

    public Integer getIsInitialization() 
    {
        return isInitialization;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskRules(Integer taskRules) 
    {
        this.taskRules = taskRules;
    }

    public Integer getTaskRules() 
    {
        return taskRules;
    }
    public void setDateInterval(Integer dateInterval) 
    {
        this.dateInterval = dateInterval;
    }

    public Integer getDateInterval() 
    {
        return dateInterval;
    }
    public void setReminderDate(Integer reminderDate) 
    {
        this.reminderDate = reminderDate;
    }

    public Integer getReminderDate() 
    {
        return reminderDate;
    }
    public void setExecutiveRole(String executiveRole) 
    {
        this.executiveRole = executiveRole;
    }

    public String getExecutiveRole() 
    {
        return executiveRole;
    }
    public void setTaskDescribe(String taskDescribe) 
    {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskDescribe() 
    {
        return taskDescribe;
    }
    public void setSubtask(String subtask) 
    {
        this.subtask = subtask;
    }

    public String getSubtask() 
    {
        return subtask;
    }
    public void setIsDisable(Integer isDisable) 
    {
        this.isDisable = isDisable;
    }

    public Integer getIsDisable() 
    {
        return isDisable;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("siteId", getSiteId())
            .append("isInitialization", getIsInitialization())
            .append("taskName", getTaskName())
            .append("taskRules", getTaskRules())
            .append("dateInterval", getDateInterval())
            .append("reminderDate", getReminderDate())
            .append("executiveRole", getExecutiveRole())
            .append("taskDescribe", getTaskDescribe())
            .append("subtask", getSubtask())
            .append("isDisable", getIsDisable())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
