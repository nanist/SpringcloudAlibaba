package com.ruoyi.system.api;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.factory.RemoteOperationFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName RemoteOperationService * @Description TODO
 * @Author lgn
 * @Date 15:53 2022/8/18
 * @Version 1.0
 **/
@FeignClient(contextId = "remoteOperationService", value = ServiceNameConstants.LAB_SERVICE, fallbackFactory = RemoteOperationFallbackFactory.class)
public interface RemoteOperationService {

    @PostMapping("/support/pollingOperationTask")
    public R<JSONObject> pollingOperationTask();


}
