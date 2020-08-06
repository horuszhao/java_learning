package com.zyx.sc.springcat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class MyAsyncConfiguration implements AsyncConfigurer {

    private final Logger LOGGER = LoggerFactory.getLogger( MyAsyncConfiguration.class );

    private static final Integer CORE_POOL_SIZE = 2;
    private static final Integer QUEUE_CAPACITY = 5;
    private static final Integer MAX_POOL_SIZE = 10;
    private static final String THREAD_NAME_PREFIX = "myAsyncExecutor-";
    private static final Integer AWAIT_TERMINATION_SECONDS = 10;

    @Bean( name = "myAsync" )
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize( CORE_POOL_SIZE );
        executor.setMaxPoolSize( MAX_POOL_SIZE );
        executor.setQueueCapacity( QUEUE_CAPACITY );
        executor.setThreadNamePrefix( THREAD_NAME_PREFIX );
        /* 拒绝策略 CallerRunsPolicy，当达到或超过maxPool时，交由线程池所在线程执行 */
        executor.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy() );
        executor.setWaitForTasksToCompleteOnShutdown( true );
        executor.setAwaitTerminationSeconds( AWAIT_TERMINATION_SECONDS );
        executor.initialize();
        return executor;
    }

    @Bean( name = "taskExecutor" )
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    /**
     * 异常处理
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异常处理类
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException( Throwable throwable, Method method, Object... obj ) {
            LOGGER.error( "asyncExecutor exception->{}", throwable.getMessage() );
        }
    }

}
