package fraglab.webapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "SampleFilter", urlPatterns = {"/*"}, asyncSupported = true)
public class SampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initializing filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter invoked. Chaining...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter chain returned.");

    }

    @Override
    public void destroy() {
        System.out.println("Destroying filter");
    }
}
