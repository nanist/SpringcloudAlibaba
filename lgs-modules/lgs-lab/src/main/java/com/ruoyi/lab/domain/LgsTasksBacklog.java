package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 定时任务待办对象 lgs_tasks_backlog
 * 
 * @author lgn
 * @date 2022-09-01
 */
public class LgsTasksBacklog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 站点id */
    @Excel(name = "站点id")
    private Long siteId;

    /** 运维支持定时任务id */
    @Excel(name = "运维支持定时任务id")
    private Long operationSupportId;

    /** 待办人id */
    @Excel(name = "待办人id")
    private String userId;

    /** 待办描述 */
    @Excel(name = "待办描述")
    private String backlogDescribe;

    /** 文件id集合 */
    @Excel(name = "文件id集合")
    private String fileIds;

    /** 0：需求，1：需求变更，2：设备退役申请，3：日常报修，4：运维任务 */
    @Excel(name = "0：需求，1：需求变更，2：设备退役申请，3：日常报修，4：运维任务")
    private Integer backlogType;

    /** 完成人 */
    @Excel(name = "完成人")
    private String completedBy;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 子任务 */
    @Excel(name = "子任务")
    private String subtask;

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
    public void setSiteId(Long siteId) 
    {
        this.siteId = siteId;
    }

    public Long getSiteId() 
    {
        return siteId;
    }
    public void setOperationSupportId(Long operationSupportId) 
    {
        this.operationSupportId = operationSupportId;
    }

    public Long getOperationSupportId() 
    {
        return operationSupportId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setBacklogDescribe(String backlogDescribe) 
    {
        this.backlogDescribe = backlogDescribe;
    }

    public String getBacklogDescribe() 
    {
        return backlogDescribe;
    }
    public void setFileIds(String fileIds) 
    {
        this.fileIds = fileIds;
    }

    public String getFileIds() 
    {
        return fileIds;
    }
    public void setBacklogType(Integer backlogType) 
    {
        this.backlogType = backlogType;
    }

    public Integer getBacklogType() 
    {
        return backlogType;
    }
    public void setCompletedBy(String completedBy) 
    {
        this.completedBy = completedBy;
    }

    public String getCompletedBy() 
    {
        return completedBy;
    }
    public void setCompletionTime(Date completionTime) 
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime() 
    {
        return completionTime;
    }
    public void setSubtask(String subtask) 
    {
        this.subtask = subtask;
    }

    public String getSubtask() 
    {
        return subtask;
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
            .append("operationSupportId", getOperationSupportId())
            .append("userId", getUserId())
            .append("backlogDescribe", getBacklogDescribe())
            .append("fileIds", getFileIds())
            .append("backlogType", getBacklogType())
            .append("completedBy", getCompletedBy())
            .append("completionTime", getCompletionTime())
            .append("subtask", getSubtask())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
