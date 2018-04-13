package io.github.sisRide.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        //Se nao for a ação de login entao o a sessão deveria ter um atributo chamado de 'Usuario'
        //contendo o usuario logado, caso esse atributo seja null entao, nesta sessão, não foi realizado
        //o login,Logo, Caso a ação não seja login e o usuario seja null ele não está autorizado.
        if (!request.getParameter("action").equals("Login") && session.getAttribute("Usuario") != null) {
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
