package com.ruoyi.lab.service;

import java.util.Map;

/**
 * @author lgn
 * @title: IlgsEmailService
 * @projectName git_lgs
 * @description: TODO
 * @date 2022/8/813:52
 */
public interface IlgsEmailService {
    /**
     * 失败邮件获取接口
     * @param map
     * @return
     */
    String GetFailedEmailList(Map<String, String> map);

    /**
     * 邮件发送接口
     * @param map
     * @return
     */
    String SendEmail(Map<String, String> map);
}
