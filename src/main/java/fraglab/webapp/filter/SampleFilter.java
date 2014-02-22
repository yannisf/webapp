package fraglab.webapp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class SampleFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(SampleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("Initializing filter... ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("Filter invoked. Chaining... ");
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Filter chain returned. ");

    }

    @Override
    public void destroy() {
        LOG.info("Destroying filter. ");
    }
}
