package com.ruoyi.lab.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.service.IlgsEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * @ClassName IlgsEmailServiceImpl * @Description TODO
 * @Author lgn
 * @Date 13:52 2022/8/8
 * @Version 1.0
 **/
@Service
@RefreshScope //热刷新
public class IlgsEmailServiceImpl implements IlgsEmailService {
    /**
     * AppId
     */
    @Value("${lgsemail.appid}")
    public String appid;

    /**
     * AppSecret
     */
    @Value("${lgsemail.appsecret}")
    public String appsecret;

    /**
     * sendEmailUrl
     */
    @Value("${lgsemail.sendemailurl}")
    public String sendemailurl;
    /**
     * GetFailedEmailListUrl
     */
    @Value("${lgsemail.failedemaillisturl}")
    public String failedemaillisturl;

    @Override
    public String GetFailedEmailList(Map<String, String> map) {
        RestTemplate restTemplate = new RestTemplate();

        System.out.println("------appid:"+appid);
        System.out.println("------appsecret:"+appsecret);
        System.out.println("------failedemaillisturl:"+failedemaillisturl);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

/*        String url = "http://localhost:8080/lab/mail/list";
        params.add("isRead", "10");
        params.add("isUrgent", "10");*/

        String url =failedemaillisturl;
        params.add("AppId", appid);
        params.add("AppSecret", appsecret);
        params.add("StartDate", map.get("StartDate"));
        params.add("EndDate", map.get("EndDate"));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.queryParams(params).build().encode().toUri();

        ResponseEntity<Map> response = restTemplate.getForEntity(uri, Map.class);

        // 获取响应体
        System.out.println("HTTP 响应body：" + response.getBody().toString());

        // 以下是getForEntity比getForObject多出来的内容
        HttpStatus statusCode = response.getStatusCode();
        int statusCodeValue = response.getStatusCodeValue();
        HttpHeaders headers = response.getHeaders();

        System.out.println("HTTP 响应状态：" + statusCode);
        System.out.println("HTTP 响应状态码：" + statusCodeValue);
        System.out.println("HTTP Headers信息：" + headers);

        return response.getBody().toString();
    }

    @Override
    public String SendEmail(Map<String, String> map) {
        RestTemplate template = new RestTemplate();

        //String uriTemplate = "http://localhost:8080/lab/mail";

        String uriTemplate = sendemailurl;
        URI uri = UriComponentsBuilder.fromUriString(uriTemplate).build().toUri();
        // 自定义body实体类
        JSONObject jsonObject=new JSONObject();
/*        jsonObject.put("sender", map.get("sender"));
        jsonObject.put("receiver", map.get("receiver"));
        jsonObject.put("content", map.get("content"));*/

        jsonObject.put("AppId", appid);
        jsonObject.put("AppSecret", appsecret);
        jsonObject.put("Email", map.get("EmailArray"));

        String s = JSON.toJSONString(jsonObject);
        RequestEntity<String> requestEntity = RequestEntity.post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .body(s);
        ResponseEntity<String> exchange = template.exchange(requestEntity, String.class);
        String body = exchange.getBody();
        System.out.println(JSON.parseObject(body).toJSONString());

        return JSON.parseObject(body).toJSONString();

    }
}
