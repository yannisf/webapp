package fraglab.webapp.axis;

public class HelloService {

    public String hello() {
        return "Hello!";
    }

    public String personalizedHello(String name) {
        return "Hello, " + name + "!";
    }

}
