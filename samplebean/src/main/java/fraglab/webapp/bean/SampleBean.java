package fraglab.webapp.bean;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SampleBean {

    private AtomicInteger id = new AtomicInteger(0);
    private LoadingCache<String, String> cache;
    private String beanName;

    public SampleBean() {

        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                return dateFormat.format(new Date());
            }
        };

        this.cache = CacheBuilder.newBuilder()
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .build(loader);
    }

    public AtomicInteger getId() {
        return id;
    }

    public void setId(AtomicInteger id) {
        this.id = id;
    }

    public int incrementAndGetId() {
        return this.id.incrementAndGet();
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getKey(String key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "SampleBean["+super.toString()+"]{" +
                "id='" + id + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

}
