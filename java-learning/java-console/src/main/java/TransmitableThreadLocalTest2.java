import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author:zhaoyunxiang
 * @date:2020/2/7 10:53 上午
 */
public class TransmitableThreadLocalTest2 {
    static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<String>();
    static final ThreadLocal<String> context_L = new ThreadLocal<>();
    static final InheritableThreadLocal<String> context_I = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("TransmitableThreadLocalTest-pool-%d").build();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue<>();

        ExecutorService executorService = new ThreadPoolExecutor(10, 20,
                100, TimeUnit.MILLISECONDS, linkedBlockingQueue,namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        try {
            executorService.invokeAll(Arrays.asList(new NullTask(),new NullTask(),new NullTask(),new NullTask(),new NullTask()
                    ,new NullTask(),new NullTask(),new NullTask(),new NullTask(),new NullTask(),new NullTask(),new NullTask(),new NullTask()));
//            executorService.shutdown();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.set("TransmittableThreadLocal-in-parent");
        context_L.set("ThreadLocal-in-parent");
        context_I.set("InheritableThreadLocal-in-parent");
        executorService = TtlExecutors.getTtlExecutorService(executorService);
//        ExecutorService executorService = new ThreadPoolExecutor(2, 3,
//                100, TimeUnit.MILLISECONDS, linkedBlockingQueue, namedThreadFactory,
//                new ThreadPoolExecutor.AbortPolicy());
        try {
            executorService.invokeAll(Arrays.asList(new NewTask(), new NewTask(), new NewTask()));
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class NewTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "->" + context_L.get());
            System.out.println(Thread.currentThread().getName() + "->" + context_I.get());
            System.out.println(Thread.currentThread().getName() + "->" + context.get());
            return 0;
        }
    }

    static class NullTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return 0;
        }
    }
}
