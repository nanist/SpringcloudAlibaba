package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 资产管理对象 lgs_assets_management
 * 
 * @author lgn
 * @date 2022-07-28
 */
public class LgsAssetsManagement
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long demand_id;

    private LgsAssetsClient lgsAssetsClient;
    private LgsAssetsHardware lgsAssetsHardware;
    private LgsAssetsSystem lgsAssetsSystem;

    public Long getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(Long demand_id) {
        this.demand_id = demand_id;
    }

    public LgsAssetsClient getLgsAssetsClient() {
        return lgsAssetsClient;
    }

    public void setLgsAssetsClient(LgsAssetsClient lgsAssetsClient) {
        this.lgsAssetsClient = lgsAssetsClient;
    }

    public LgsAssetsHardware getLgsAssetsHardware() {
        return lgsAssetsHardware;
    }

    public void setLgsAssetsHardware(LgsAssetsHardware lgsAssetsHardware) {
        this.lgsAssetsHardware = lgsAssetsHardware;
    }

    public LgsAssetsSystem getLgsAssetsSystem() {
        return lgsAssetsSystem;
    }

    public void setLgsAssetsSystem(LgsAssetsSystem lgsAssetsSystem) {
        this.lgsAssetsSystem = lgsAssetsSystem;
    }
}
