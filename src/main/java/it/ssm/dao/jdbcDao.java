package it.ssm.dao;

import it.ssm.domain.Userinfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class jdbcDao {
    public static Connection getConnect() throws ClassNotFoundException, SQLException {
        //1.获取连接
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=utf8", "root", "123456");

        return connection;
    }

    public static List<HashMap<String,String>> query(String sql) throws SQLException, ClassNotFoundException {
        //1.获取连接
        Connection connect = getConnect();
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("当前执行的SQL语句为:"+sql);
        List<HashMap<String,String>> ret = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hs = new HashMap<>();
        while (resultSet.next()){

            String uid = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String sex = resultSet.getString("sex");
            String age = resultSet.getString("age");

            hs.put("username",username);
            hs.put("password",password);
            hs.put("sex",sex);
            hs.put("age",age);
            hs.put("id",uid);

            ret.add(hs);
        }
        return ret;
    }

    //安全的封装query方法
    public static List<HashMap<String,String>> querySafe(String sql, Object ...args) throws SQLException, ClassNotFoundException {
        //1.获取连接
        Connection connect = getConnect();

        //调整的地方
        PreparedStatement ps = connect.prepareStatement(sql);
        for (int i = 1; i <= args.length; i++) {
            ps.setObject(i,args[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        System.out.println("当前执行的SQL语句为:"+ps);
        List<HashMap<String,String>> ret = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hs = new HashMap<>();
        while (resultSet.next()){

            String uid = resultSet.getString("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String sex = resultSet.getString("sex");
            String age = resultSet.getString("age");

            hs.put("username",username);
            hs.put("password",password);
            hs.put("sex",sex);
            hs.put("age",age);
            hs.put("id",uid);

            ret.add(hs);
        }
        return ret;
    }
}
