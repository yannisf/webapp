package fraglab.webapp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SampleListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet context destroyed.");
    }

}
