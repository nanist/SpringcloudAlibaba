package com.ruoyi.common.core.utils.Collection;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadUtils * @Description TODO
 * @Author lgn
 * @Date 16:19 2022/8/31
 * @Version 1.0
 **/
public class ThreadUtils {

    public static void main(String[] args) {

        ArrayList<Integer> list=new ArrayList<>();

        for (int i=0;i<2300;i++){
            list.add(i);
        }

        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < list.size(); i++) {
            final int index = i;

            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {//execute方法,可以看异常输出在控制台，而submit在控制台没有直接输出，必须调用Future.get()方法时，可以捕获到异常。
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getName()+"-------------:"+index);
                }
            });

        }
        cachedThreadPool.shutdown();
    }
}
