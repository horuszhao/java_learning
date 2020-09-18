import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.Data;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:zhaoyunxiang
 * @date:2020/9/17 1:55 下午
 */
public class GuavaLocalCacheTest {
    protected static final ListeningExecutorService executorService =
            MoreExecutors.listeningDecorator(new ThreadPoolExecutor(2, 5, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<>()));

    private static final LoadingCache<String, Integer> businessDateCache = CacheBuilder.newBuilder().maximumSize(5000).refreshAfterWrite(3, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Integer>() {
                @Override
                public Integer load(String key) {
                    System.out.println("load-key:"+key);
                    return getData(key);
                }

                @Override
                public ListenableFuture<Integer> reload(String key, Integer oldValue) {
                    System.out.println("reload-key:"+key);
                    return executorService.submit(() -> getData(key));
                }

                private Integer getData(String key) {
                    String[] keys = key.split("&");
                    CommonField param = new CommonField();
                    param.setOwnerId(Integer.valueOf(keys[0]));
                    param.setOrgId(Integer.valueOf(keys[1]));
                    System.out.println(param);
                    if(param.getOwnerId()%2==0) {
                        return null;
                    }else{
                        return  param.getOwnerId();
                    }
                }
            });

    public static void main(String[] args) {
        CommonField cf = new CommonField();
        cf.setOwnerId(1);
        cf.setOrgId(2);
        int i = 0;
        int j=0;
        while (true) {
            if(i==10){
                i=0;
                j++;
            }
            i++;
            cf.setOwnerId(i);
            System.out.println("---------------start"+i);
            System.out.println(getData(cf));
            System.out.println("---------------end"+i);
            if(j==2){
                System.out.println(businessDateCache.asMap());
                System.out.println(businessDateCache.stats());
                break;
            }
        }

    }

    public static Integer getData(CommonField commonField) {
        try {
            String key = commonField.getOwnerId().toString().concat("&").concat(commonField.getOrgId().toString());
            return businessDateCache.get(key, ()->{
                System.out.println("hello");
                return commonField.getOwnerId();
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    @Data
    public static class CommonField{
        private Integer ownerId;
        private Integer orgId;
    }
}
