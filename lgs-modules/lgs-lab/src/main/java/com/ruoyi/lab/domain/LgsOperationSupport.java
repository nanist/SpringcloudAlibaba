package com.ruoyi.lab.domain;

import java.time.LocalDateTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 运维任务对象 lgs_operation_support
 * 
 * @author lgn
 * @date 2022-08-19
 */
public class LgsOperationSupport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文件id */
    @Excel(name = "文件id")
    private String fileId;

    /** 需求单id */
    @Excel(name = "需求单id")
    private Long demandId;

    /** 设备id */
    @Excel(name = "设备id")
    private String equipmentId;

    /** 运维规则id */
    @Excel(name = "运维规则id")
    private String taskRulesId;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String taskDescribe;

    /** 任务类型;0:定时任务1:年度DRP2:备份检查3:服务器巡检 */
    @Excel(name = "任务类型;0:定时任务1:年度DRP2:备份检查3:服务器巡检")
    private Integer billType;

    /** 下次任务执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次任务执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextTaskExecutionTime;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String billStatus;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewedBy;

    /** 删除状态 */
    @Excel(name = "删除状态")
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

    //任务开始时间
    private LocalDateTime completionTime;
    /** 运维周期;0：天1：周2：月3：半年4：一年 */
    private Integer taskRules;
    /** 日期间隔;日期间隔：允许输入0和正整数 */
    private Integer dateInterval;
    /** 提前提醒天数;仅支持输入0与正整数。 */
    private Integer reminderDate;
    /** 执行角色 */
    private String executiveRole;//人员类别;0：硬件支持人员，1：软件支持人员，2：供应商支持人员
    /** 子任务 */
    private String subtask;
    /** 站点id */
    private Long siteId;
    /** 任务名称 */
    private String taskName;
    /** 周期 */
    private String cycle;
    /** 提前n天 */
    private String reminderDateStr;
    /** 角色 */
    private String roleStr;
    /** 是否可用 */
    private String isDisableStr;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getReminderDateStr() {
        return reminderDateStr;
    }

    public void setReminderDateStr(String reminderDateStr) {
        this.reminderDateStr = reminderDateStr;
    }

    public String getRoleStr() {
        return roleStr;
    }

    public void setRoleStr(String roleStr) {
        this.roleStr = roleStr;
    }

    public String getIsDisableStr() {
        return isDisableStr;
    }

    public void setIsDisableStr(String isDisableStr) {
        this.isDisableStr = isDisableStr;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public Integer getTaskRules() {
        return taskRules;
    }

    public void setTaskRules(Integer taskRules) {
        this.taskRules = taskRules;
    }

    public Integer getDateInterval() {
        return dateInterval;
    }

    public void setDateInterval(Integer dateInterval) {
        this.dateInterval = dateInterval;
    }

    public Integer getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Integer reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getExecutiveRole() {
        return executiveRole;
    }

    public void setExecutiveRole(String executiveRole) {
        this.executiveRole = executiveRole;
    }

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setDemandId(Long demandId) 
    {
        this.demandId = demandId;
    }

    public Long getDemandId() 
    {
        return demandId;
    }
    public void setEquipmentId(String equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentId() 
    {
        return equipmentId;
    }
    public void setTaskRulesId(String taskRulesId) 
    {
        this.taskRulesId = taskRulesId;
    }

    public String getTaskRulesId() 
    {
        return taskRulesId;
    }
    public void setTaskDescribe(String taskDescribe) 
    {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskDescribe() 
    {
        return taskDescribe;
    }
    public void setBillType(Integer billType) 
    {
        this.billType = billType;
    }

    public Integer getBillType() 
    {
        return billType;
    }
    public void setNextTaskExecutionTime(Date nextTaskExecutionTime) 
    {
        this.nextTaskExecutionTime = nextTaskExecutionTime;
    }

    public Date getNextTaskExecutionTime() 
    {
        return nextTaskExecutionTime;
    }
    public void setBillStatus(String billStatus) 
    {
        this.billStatus = billStatus;
    }

    public String getBillStatus() 
    {
        return billStatus;
    }
    public void setReviewedBy(String reviewedBy) 
    {
        this.reviewedBy = reviewedBy;
    }

    public String getReviewedBy() 
    {
        return reviewedBy;
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
            .append("fileId", getFileId())
            .append("demandId", getDemandId())
            .append("equipmentId", getEquipmentId())
            .append("taskRulesId", getTaskRulesId())
            .append("taskDescribe", getTaskDescribe())
            .append("billType", getBillType())
            .append("nextTaskExecutionTime", getNextTaskExecutionTime())
            .append("billStatus", getBillStatus())
            .append("reviewedBy", getReviewedBy())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
