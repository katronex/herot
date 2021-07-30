package main.com.ts.Filter;

import com.google.gson.Gson;
import main.com.ts.entity.User;
import main.com.ts.service.Impl.HeroServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
@WebFilter("/*")
public class LoginFilger implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("loginfilter");
//        servletRequest.setCharacterEncoding("UTF-8");
//        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        String requestURI = servletRequest1.getRequestURI();
        System.out.println("uri="+requestURI);
        if (requestURI.contains("/login")||requestURI.contains("/js")||requestURI.contains("/login.html")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            HttpSession session = servletRequest1.getSession();
            User user = (User)session.getAttribute("user");

            if (user!=null){
                System.out.println("username="+user.getName());
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletResponse)servletResponse).sendRedirect("htmlt/login.html");
            }
        }
    }
    @Override
    public void destroy() {

    }
}
