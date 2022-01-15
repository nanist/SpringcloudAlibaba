package com.naixin.sentinel.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liangguannan on 2021/11/4.
 * 若 blockHandler 和 fallback 都进行了配置，则被限流降级而抛出 BlockException 时只会进入 blockHandler 处理逻辑。
 * 若未配置 blockHandler、fallback 和 defaultFallback，
 * 则被限流降级时会将 BlockException 直接抛出。
 */
@RestController
@RequestMapping("/sen")
public class SentinalController {

    /**
     * 需要通过Sentinel来控制流量的地方使用@SentinelResource注解
     * 按url限流，有默认的限流处理逻辑
     *
     * @return
     */
    @SentinelResource(value = "getSentinalTop",blockHandler="testBlockHandler")
    @GetMapping("/getSentinalTop")
    public String getSentinalTop(){
        return "Hello -- TheShy";
    }

    /**
     * 保证调用这些被限制服务的调用者，让他们拿到一个合理的结果，而不是返回去一个异常。
     * blockHandler：sentinel定义的失败调用或限制调用，若本次访问被限流或服务降级，则调用blockHandler指定的接口。
     * @param b
     * @return
     */
    public String testBlockHandler (BlockException b) {
        return "TheShy:被限流降级";
    }

    /**
     * @SentinelResource注解除了可以用来做限流控制之外，还能实现与Hystrix类似的熔断降级策略。
     *
     * @return
     */
    @SentinelResource(value = "getSentinalMid", fallback = "helloFallback")
    @GetMapping("/getSentinalMid")
    public String getSentinalMid(){

        try {
            Thread.sleep(1000);//休息1000毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello -- Rookie";
    }

    /**
     * fallback：失败调用，若本接口出现未知异常，则调用fallback指定的接口。
     * @return
     */
    public String helloFallback() {
        return "Rookie:被限流降级";
    }
}
