package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 入组管理正式环境搭建服务器信息对象 lgs_assets_client
 * 
 * @author lgn
 * @date 2022-08-30
 */
public class LgsAssetsClient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求单id */
    @Excel(name = "需求单id")
    private Long demandId;

    /** 计算机名称 */
    @Excel(name = "计算机名称")
    private String computerName;

    /** 服务器ip */
    @Excel(name = "服务器ip")
    private String serverIp;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String operatingSystem;

    /** VN;0：是1：否 */
    @Excel(name = "VN;0：是1：否")
    private Integer vn;

    /** 备份数据路径 */
    @Excel(name = "备份数据路径")
    private String backupDataPath;

    /** 应用架构 */
    @Excel(name = "应用架构")
    private String applicationArchitecture;

    /** 角色;0：Application Server1：Index Server2：DB Server */
    @Excel(name = "角色;0：Application Server1：Index Server2：DB Server")
    private Integer role;

    /** 数据库类型 */
    @Excel(name = "数据库类型")
    private String databaseType;

    /** 高可用模式 */
    @Excel(name = "高可用模式")
    private String haMode;

    /** 计算机类型;0：服务器信息1：单机版计算机信息 */
    @Excel(name = "计算机类型;0：服务器信息1：单机版计算机信息")
    private Integer computerType;

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
    public void setComputerName(String computerName) 
    {
        this.computerName = computerName;
    }

    public String getComputerName() 
    {
        return computerName;
    }
    public void setServerIp(String serverIp) 
    {
        this.serverIp = serverIp;
    }

    public String getServerIp() 
    {
        return serverIp;
    }
    public void setOperatingSystem(String operatingSystem) 
    {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() 
    {
        return operatingSystem;
    }
    public void setVn(Integer vn) 
    {
        this.vn = vn;
    }

    public Integer getVn() 
    {
        return vn;
    }
    public void setBackupDataPath(String backupDataPath) 
    {
        this.backupDataPath = backupDataPath;
    }

    public String getBackupDataPath() 
    {
        return backupDataPath;
    }
    public void setApplicationArchitecture(String applicationArchitecture) 
    {
        this.applicationArchitecture = applicationArchitecture;
    }

    public String getApplicationArchitecture() 
    {
        return applicationArchitecture;
    }
    public void setRole(Integer role) 
    {
        this.role = role;
    }

    public Integer getRole() 
    {
        return role;
    }
    public void setDatabaseType(String databaseType) 
    {
        this.databaseType = databaseType;
    }

    public String getDatabaseType() 
    {
        return databaseType;
    }
    public void setHaMode(String haMode) 
    {
        this.haMode = haMode;
    }

    public String getHaMode() 
    {
        return haMode;
    }
    public void setComputerType(Integer computerType) 
    {
        this.computerType = computerType;
    }

    public Integer getComputerType() 
    {
        return computerType;
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
            .append("computerName", getComputerName())
            .append("serverIp", getServerIp())
            .append("operatingSystem", getOperatingSystem())
            .append("vn", getVn())
            .append("backupDataPath", getBackupDataPath())
            .append("applicationArchitecture", getApplicationArchitecture())
            .append("role", getRole())
            .append("databaseType", getDatabaseType())
            .append("haMode", getHaMode())
            .append("computerType", getComputerType())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
