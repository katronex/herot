package main.com.ts.controller;

import main.com.ts.service.HeroService;
import main.com.ts.service.Impl.HeroServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete")
public class DelServlet extends HttpServlet {
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
        String address = req.getParameter("address");
        heroService.removeHero(Integer.valueOf(id));
            resp.sendRedirect("/hero");
    }
}
