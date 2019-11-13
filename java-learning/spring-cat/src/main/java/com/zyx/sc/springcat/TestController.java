package com.zyx.sc.springcat;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhaoyunxiang
 * @date:2019/10/21 3:23 下午
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("a")
    public String test1() {
        Transaction t = Cat.newTransaction("URL", "test/a");
        try {
            Cat.enable();
            Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=127.0.0.1");
            Cat.logMetricForCount("count");
            Cat.logMetricForDuration("key", 5);
            t.setStatus(Transaction.SUCCESS);
        } catch (Exception e) {
            t.setStatus(e);
            Cat.logError(e);
        } finally {
            t.complete();
        }
        return "aaa";
    }
}
