package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 入组管理正式环境搭建实验室计算机信息对象 lgs_assets_hardware
 * 
 * @author lgn
 * @date 2022-08-30
 */
public class LgsAssetsHardware extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求单id;文件表id */
    @Excel(name = "需求单id;文件表id")
    private Long demandId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 操作系统版本 */
    @Excel(name = "操作系统版本")
    private String systemVersion;

    /** 固定资产编号 */
    @Excel(name = "固定资产编号")
    private String fixedAssetsCode;

    /** 账号类型;0：公共域账号、1:个人域账号、2:本地账号。 */
    @Excel(name = "账号类型;0：公共域账号、1:个人域账号、2:本地账号。")
    private Integer accountType;

    /** ip地址 */
    @Excel(name = "ip地址")
    private String ipAddress;

    /** mac地址 */
    @Excel(name = "mac地址")
    private String macAddress;

    /** 网络端口 */
    @Excel(name = "网络端口")
    private String networkPort;

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
    public void setDemandId(Long demandId) 
    {
        this.demandId = demandId;
    }

    public Long getDemandId() 
    {
        return demandId;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setSystemVersion(String systemVersion) 
    {
        this.systemVersion = systemVersion;
    }

    public String getSystemVersion() 
    {
        return systemVersion;
    }
    public void setFixedAssetsCode(String fixedAssetsCode) 
    {
        this.fixedAssetsCode = fixedAssetsCode;
    }

    public String getFixedAssetsCode() 
    {
        return fixedAssetsCode;
    }
    public void setAccountType(Integer accountType) 
    {
        this.accountType = accountType;
    }

    public Integer getAccountType() 
    {
        return accountType;
    }
    public void setIpAddress(String ipAddress) 
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() 
    {
        return ipAddress;
    }
    public void setMacAddress(String macAddress) 
    {
        this.macAddress = macAddress;
    }

    public String getMacAddress() 
    {
        return macAddress;
    }
    public void setNetworkPort(String networkPort) 
    {
        this.networkPort = networkPort;
    }

    public String getNetworkPort() 
    {
        return networkPort;
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
            .append("deviceName", getDeviceName())
            .append("deviceType", getDeviceType())
            .append("systemVersion", getSystemVersion())
            .append("fixedAssetsCode", getFixedAssetsCode())
            .append("accountType", getAccountType())
            .append("ipAddress", getIpAddress())
            .append("macAddress", getMacAddress())
            .append("networkPort", getNetworkPort())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
