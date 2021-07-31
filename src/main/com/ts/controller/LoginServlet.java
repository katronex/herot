package main.com.ts.controller;

import com.google.gson.Gson;
import main.com.ts.entity.Hero;
import main.com.ts.entity.User;
import main.com.ts.service.Impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HeroServiceImpl heroService = new HeroServiceImpl();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = heroService.searUser(name);
        Gson gson = new Gson();
        HashMap<Object, Object> map = new HashMap<>();
        if (password.equals(user.getPassword())){
            session.setAttribute("user",user);
           // req.getRequestDispatcher("/htmlt/showHeroes.html").forward(req,resp);
            map.put("msg","/hero/htmlt/showHeroes.html");
            String s = gson.toJson(map);
            resp.getWriter().write(s);
        }else{
            map.put("msg","密码或用户名错误！！！");
            String s = gson.toJson(map);
            resp.setStatus(404);
            resp.getWriter().write(s);
        }
    }
}