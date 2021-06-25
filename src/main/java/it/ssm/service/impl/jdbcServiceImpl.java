package it.ssm.service.impl;

import it.ssm.dao.jdbcDao;
import it.ssm.service.jdbcService;
import it.ssm.tools.charEncoding;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;
import java.util.List;


@Service
public class jdbcServiceImpl implements jdbcService {
    @Override
    public List getUserById(String id) throws SQLException, ClassNotFoundException {
        //1.有注入的代码
        String sql = "select * from Userinfo where id=" + id;
        List<HashMap<String, String>> data = jdbcDao.query(sql);


        //2.预编译模式代码
//        String sql = "select * from Userinfo where id=?";
//        List<HashMap<String, String>> data = jdbcDao.querySafe(sql, id);

        //3.esapi过滤
//        String newid = charEncoding.sqlFilter(id);
//        String sql = "select * from Userinfo where id=" + newid;
//        System.out.println("id:"+id+",当前执行的SQL语句为:"+sql);
//        List<HashMap<String, String>> data = jdbcDao.query(sql);

        return data;
    }



}
