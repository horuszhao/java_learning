package com.zyx.sc.springcat;

import org.springframework.util.StopWatch;

/**
 * @author:zhaoyunxiang
 * @date:2020/8/6 2:10 下午
 */
public class StopwatchTest {

    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(100);
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }
}
