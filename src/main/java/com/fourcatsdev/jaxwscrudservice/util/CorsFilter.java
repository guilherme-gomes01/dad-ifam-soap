package com.fourcatsdev.jaxwscrudservice.util;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*") // Aplica o filtro a todas as requisicoes
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        // Adiciona os cabeçalhos CORS
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, SOAPAction");
        res.setHeader("Access-Control-Allow-Credentials", "true");
      //  res.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
      //  res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");


        // Lida com pré-requisições OPTIONS
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            res.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Continua a cadeia de filtros
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }


}