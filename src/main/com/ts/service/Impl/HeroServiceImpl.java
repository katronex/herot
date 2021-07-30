package main.com.ts.service.Impl;

import main.com.ts.dao.HeroDao;
import main.com.ts.dao.Impl.HeroDaoImpl;
import main.com.ts.entity.Hero;
import main.com.ts.entity.User;
import main.com.ts.service.HeroService;

import java.util.List;

public class HeroServiceImpl implements HeroService {
    HeroDao heroDao = new HeroDaoImpl();
    @Override
    public List<Hero> showAll() {
        return heroDao.select();

    }

    @Override
    public int modify(Hero hero) {
        return heroDao.upDate(hero);
    }

    @Override
    public int addHero(Hero hero) {
        return heroDao.insert(hero);
    }

    //删除
    @Override
    public int removeHero(int id) {
        return heroDao.delete(id);
    }

    @Override
    public Hero findOne(String name) {
        return heroDao.selectOne(name);
    }

    @Override
    public User searUser(String name) {
        return heroDao.searchOne(name);
    }

}
