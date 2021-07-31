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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/heroes")
public class HerosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HeroService heroService = new HeroServiceImpl();
        List<Hero> heroes = heroService.showAll();
        Gson gson = new Gson();
        String HeroJson = gson.toJson(heroes);
        System.out.println(HeroJson);
        resp.getWriter().write(HeroJson);
        }
}
