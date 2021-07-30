package main.com.ts.dao.Impl;

import main.com.ts.dao.HeroDao;
import main.com.ts.entity.Hero;
import main.com.ts.entity.User;
import main.com.ts.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao {

    @Override
    public List<Hero> select() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        List<Hero> heroes =new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from hero";
            Statement stm = connection.createStatement();
             set  = stm.executeQuery(sql);
            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String force_value = set.getString(3);
                String addr= set.getString(4);
                String info = set.getString(5);
                Hero hero = new Hero(id,name,force_value,addr,info);
                heroes.add(hero);
            }
            return heroes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(set,preparedStatement,connection);
        }
        return null;
    }

    @Override
    public int upDate(Hero hero) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update hero set name = ? , force_value = ? , addr = ? , info = ? where id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hero.getName());
            preparedStatement.setString(2, hero.getForce_name());
            preparedStatement.setString(3, hero.getAddr());
            preparedStatement.setString(4, hero.getInfo());
            preparedStatement.setInt(5,hero.getId());
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtils.close(preparedStatement,connection);
        return 0;
    }

    @Override
    public int insert(Hero hero) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into hero(name,force_value,addr,info) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hero.getName());
            preparedStatement.setString(2, hero.getForce_name());
            preparedStatement.setString(3, hero.getAddr());
            preparedStatement.setString(4, hero.getInfo());

            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtils.close(preparedStatement,connection);
        return 0;
    }

    @Override
    public int delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from hero where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
        return 0;
    }

    @Override
    public Hero selectOne(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from hero where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            set = preparedStatement.executeQuery();
            while (set.next()){
                int id = set.getInt(1);
                String name1 = set.getString(2);
                String force_value = set.getString(3);
                String addr= set.getString(4);
                String info = set.getString(5);
                Hero hero = new Hero(id,name1,force_value,addr,info);
                return hero;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
            return null;
    }

    @Override
    public User searchOne(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from user where name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            set = preparedStatement.executeQuery();
            while (set.next()){
                int id = set.getInt(1);
                String name1 = set.getString(2);
                String password = set.getString(3);
                String address= set.getString(4);
                String phone = set.getString(5);
                User user = new User(id,name1,password,address,phone);
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement,connection);
        }
        return null;
    }
}
