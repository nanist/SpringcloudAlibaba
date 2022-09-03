package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 站内信对象 lgs_mail
 * 
 * @author lgn
 * @date 2022-09-01
 */
public class LgsMail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 站点id */
    @Excel(name = "站点id")
    private Long siteId;

    /** 发送人 */
    @Excel(name = "发送人")
    private String sender;

    /** 接收人 */
    @Excel(name = "接收人")
    private String receiver;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 是否已读;0：未读，1：已读 */
    @Excel(name = "是否已读;0：未读，1：已读")
    private Integer isRead;

    /** 是否紧急;0：否，1：是 */
    @Excel(name = "是否紧急;0：否，1：是")
    private Integer isUrgent;

    /** 信件类别;0:需求，1:需求变更，2：设备退役申请，3：日常保修，4：运维任务 */
    @Excel(name = "信件类别;0:需求，1:需求变更，2：设备退役申请，3：日常保修，4：运维任务")
    private Integer mailType;

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
    public void setSiteId(Long siteId) 
    {
        this.siteId = siteId;
    }

    public Long getSiteId() 
    {
        return siteId;
    }
    public void setSender(String sender) 
    {
        this.sender = sender;
    }

    public String getSender() 
    {
        return sender;
    }
    public void setReceiver(String receiver) 
    {
        this.receiver = receiver;
    }

    public String getReceiver() 
    {
        return receiver;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsRead(Integer isRead) 
    {
        this.isRead = isRead;
    }

    public Integer getIsRead() 
    {
        return isRead;
    }
    public void setIsUrgent(Integer isUrgent) 
    {
        this.isUrgent = isUrgent;
    }

    public Integer getIsUrgent() 
    {
        return isUrgent;
    }
    public void setMailType(Integer mailType) 
    {
        this.mailType = mailType;
    }

    public Integer getMailType() 
    {
        return mailType;
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
            .append("sender", getSender())
            .append("receiver", getReceiver())
            .append("title", getTitle())
            .append("content", getContent())
            .append("isRead", getIsRead())
            .append("isUrgent", getIsUrgent())
            .append("mailType", getMailType())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
