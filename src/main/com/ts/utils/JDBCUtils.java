package main.com.ts.utils;

import java.sql.*;

public class JDBCUtils {

        private static String url;
        private static String user;
        private static String password;
        private static String driver;
        //静态代码块
        static {
            //读取资源文件，获取值
            try {
                //1.创建Properties集合类
//                Properties pro =new Properties();
//                //2.加载文件
//                pro.load(new FileReader("src/db.properties"));

                //3.获取数据，赋值
                url = "jdbc:mysql://localhost:3306/test";
                user = "root";
                password = "root";
                driver = "com.mysql.cj.jdbc.Driver";

                //4.注册驱动
                Class.forName(driver);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    //释放资源
    public static void close(Statement stemt, Connection conn){
        if(stemt!=null){
            try {
                stemt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stemt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stemt!=null){
            try {
                stemt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

