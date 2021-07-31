package main.com.ts.controller;

import main.com.ts.entity.Hero;
import main.com.ts.service.HeroService;
import main.com.ts.service.Impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/change")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HeroService heroService = new HeroServiceImpl();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String force = req.getParameter("force");
        String address = req.getParameter("address");
        String info = req.getParameter("info");
        Hero hero = new Hero(Integer.valueOf(id),name,force,address,info);
        heroService.modify(hero);
        resp.sendRedirect("/hero/htmlt/showHeroes.html");
    }
}
