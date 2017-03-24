package fraglab.webapp.bean;

import java.util.concurrent.atomic.AtomicInteger;

public class SampleBean {

    private AtomicInteger id = new AtomicInteger(0);
    private String beanName;

    public SampleBean() {
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

    @Override
    public String toString() {
        return "SampleBean["+super.toString()+"]{" +
                "id='" + id + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

}
