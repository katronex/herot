package main.com.ts.dao;

import main.com.ts.entity.Hero;
import main.com.ts.entity.User;

import java.util.List;

public interface HeroDao {
        //选择全部
        public List<Hero> select();
        //修改
        public int upDate(Hero hero);
        //添加
        public int insert(Hero hero);
        //删除
        public  int delete(int id);
        //选择一个
        public Hero selectOne(String name);
        //查找用户
        public User searchOne(String name);


}
