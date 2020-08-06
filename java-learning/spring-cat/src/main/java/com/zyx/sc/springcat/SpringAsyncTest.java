package com.zyx.sc.springcat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author:zhaoyunxiang
 * @date:2020/7/22 10:23 上午
 */
@Service
public class SpringAsyncTest {

    @Async("myAsync")
    public void run(int  i){
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execute method asynchronously. "
                + Thread.currentThread().getName());
    }

    public void start(){
        for(int i=0;i<10;i++){
            run(i);
        }
    }
}
