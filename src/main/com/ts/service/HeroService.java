package main.com.ts.service;

import main.com.ts.entity.Hero;
import main.com.ts.entity.User;
import sun.java2d.pipe.SolidTextRenderer;

import java.util.List;

public interface HeroService {
    //展示列表
    public List<Hero> showAll();
    //修改
    public int modify(Hero hero);
    //添加
    public int addHero(Hero hero);
    //删除
    public int removeHero(int id);
    //找出一个
    public Hero findOne(String name);
    public User searUser(String name);
}
