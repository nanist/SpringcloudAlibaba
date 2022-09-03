package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 退役管理对象 lgs_retirement_management
 * 
 * @author lgn
 * @date 2022-08-02
 */
public class LgsRetirementManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文件id */
    @Excel(name = "文件id")
    private String fileId;

    /** 设备id */
    @Excel(name = "设备id")
    private String equipmentId;

    /** 活动/任务 */
    @Excel(name = "活动/任务")
    private String activity;

    /** 单据类型 */
    @Excel(name = "单据类型")
    private String billType;

    /** 单据状态 */
    @Excel(name = "单据状态")
    private String billStatus;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewedBy;

    /** 是否紧急 */
    @Excel(name = "是否紧急")
    private String isUrgent;

    /** 转移人 */
    @Excel(name = "转移人")
    private String transferor;

    /** 转移时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转移时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transferTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

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
    public void setEquipmentId(String equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentId() 
    {
        return equipmentId;
    }
    public void setActivity(String activity) 
    {
        this.activity = activity;
    }

    public String getActivity() 
    {
        return activity;
    }
    public void setBillType(String billType) 
    {
        this.billType = billType;
    }

    public String getBillType() 
    {
        return billType;
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
    public void setIsUrgent(String isUrgent) 
    {
        this.isUrgent = isUrgent;
    }

    public String getIsUrgent() 
    {
        return isUrgent;
    }
    public void setTransferor(String transferor) 
    {
        this.transferor = transferor;
    }

    public String getTransferor() 
    {
        return transferor;
    }
    public void setTransferTime(Date transferTime) 
    {
        this.transferTime = transferTime;
    }

    public Date getTransferTime() 
    {
        return transferTime;
    }
    public void setCompletionTime(Date completionTime) 
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime() 
    {
        return completionTime;
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
            .append("equipmentId", getEquipmentId())
            .append("activity", getActivity())
            .append("billType", getBillType())
            .append("billStatus", getBillStatus())
            .append("reviewedBy", getReviewedBy())
            .append("isUrgent", getIsUrgent())
            .append("transferor", getTransferor())
            .append("transferTime", getTransferTime())
            .append("completionTime", getCompletionTime())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
