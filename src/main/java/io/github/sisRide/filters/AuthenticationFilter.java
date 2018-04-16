package io.github.sisRide.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Authentication")
public class AuthenticationFilter implements Filter {

    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if (request.getParameter("action").equals("Login")
                || request.getParameter("action").equals("UsuarioCadastro")) {

            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session.getAttribute("Usuario") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/TeladeLogin.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
