package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 运维人员信息对象 lgs_operation_personnel
 * 
 * @author lgn
 * @date 2022-08-11
 */
public class LgsOperationPersonnel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求单id */
    @Excel(name = "需求单id")
    private Long demandId;

    /** 人员id */
    @Excel(name = "人员id")
    private String userId;

    /** 人员名称 */
    @Excel(name = "人员名称")
    private String userName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 状态;0：正常，1：休假，2：离职 */
    @Excel(name = "状态;0：正常，1：休假，2：离职")
    private Integer state;

    /** 委托人id */
    @Excel(name = "委托人id")
    private String assignorId;

    /** 人员类别;0：硬件支持人员，1：软件支持人员，2：供应商支持人员 */
    @Excel(name = "人员类别;0：硬件支持人员，1：软件支持人员，2：供应商支持人员")
    private Integer category;

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
    public void setDemandId(Long demandId) 
    {
        this.demandId = demandId;
    }

    public Long getDemandId() 
    {
        return demandId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setAssignorId(String assignorId) 
    {
        this.assignorId = assignorId;
    }

    public String getAssignorId() 
    {
        return assignorId;
    }
    public void setCategory(Integer category) 
    {
        this.category = category;
    }

    public Integer getCategory() 
    {
        return category;
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
            .append("demandId", getDemandId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("phoneNumber", getPhoneNumber())
            .append("state", getState())
            .append("assignorId", getAssignorId())
            .append("category", getCategory())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
