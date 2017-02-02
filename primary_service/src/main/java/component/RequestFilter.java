package component;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import java.io.IOException;

@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put("user", user());
            MDC.put("requestId", requestId());
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    private String requestId() {
        return UUID.randomUUID().toString();
    }

    private String user() {
        return "primary_user";
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
