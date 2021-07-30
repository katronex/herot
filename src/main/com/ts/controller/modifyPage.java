package main.com.ts.controller;

import com.google.gson.Gson;
import main.com.ts.entity.Hero;
import main.com.ts.service.HeroService;
import main.com.ts.service.Impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/modify")
public class modifyPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        HeroService heroService = new HeroServiceImpl();
        Hero one = heroService.findOne(name);
        Gson gson = new Gson();
        String s = gson.toJson(one);
        System.out.println(s);
       resp.getWriter().write(s);
    }
}
