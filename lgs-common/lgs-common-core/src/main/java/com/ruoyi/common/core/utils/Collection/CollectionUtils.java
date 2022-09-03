package com.ruoyi.common.core.utils.Collection;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.*;

/**
 * @ClassName CollectionUtils * @Description TODO
 * @Author lgn
 * @Date 11:33 2022/8/12
 * @Version 1.0
 **/
public class CollectionUtils {

    /**
    　　* @description: TODO
    　　* @param Optional方法
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 11:32
    　　*/
    public static void getDogName2() {

/*        if (null != person) {
            DogEntity dog = person.getDog();
            if (null != dog) {
                return dog.getName();
            }
        }*/

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id","[1,2]");

        JSONArray jsonArray=new JSONArray();
        System.out.println("---:"+Optional.ofNullable(jsonObject.get("id")).orElse(jsonArray));

    }


    public static void main(String[] args) {
        //String ids=Optional.ofNullable(lgsGroupMapping).map(m-> m.getSubprocessIds()).get();
        //String ids=Optional.ofNullable(lgsGroupMapping).map(m-> m.getSubprocessIds()).orElse("[]");
        //JSONArray jsonArray = JSONArray.parseArray(ids);

        Map<Integer, List<String>> personnelMap =new HashMap<>();

        List<String> list=new ArrayList<>();

        personnelMap.put(0,list);

        Optional.ofNullable(personnelMap.get(2)).orElse(list);

        System.out.println("---------:"+personnelMap);

        getDogName2();

    }
}
