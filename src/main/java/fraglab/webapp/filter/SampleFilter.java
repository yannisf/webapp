package fraglab.webapp.filter;

import fraglab.webapp.axis.client.Person;

import javax.servlet.*;
import java.io.IOException;

public class SampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initializing filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Person p = new Person("Yannis", "Frangos");
        System.out.println(p.getFullName());

        System.out.println("Filter invoked. Chaining...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter chain returned.");

    }

    @Override
    public void destroy() {
        System.out.println("Destroying filter");
    }
}
