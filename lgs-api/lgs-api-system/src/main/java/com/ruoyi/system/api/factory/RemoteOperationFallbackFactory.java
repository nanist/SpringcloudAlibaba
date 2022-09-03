package com.ruoyi.system.api.factory;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.RemoteOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName RemoteOperationFallbackFactory * @Description TODO
 * @Author lgn
 * @Date 15:56 2022/8/18
 * @Version 1.0
 **/
@Component
public class RemoteOperationFallbackFactory implements FallbackFactory<RemoteOperationService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteOperationFallbackFactory.class);

    @Override
    public RemoteOperationService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());

        return new RemoteOperationService(){

            @Override
            public R<JSONObject> pollingOperationTask() {
                return R.fail("轮询运维任务失败:" + throwable.getMessage());
            }
        };
    }
}
