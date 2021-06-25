package it.ssm.controller.sqlinject;


import com.alibaba.fastjson.JSON;
import it.ssm.service.impl.jdbcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

/*
* http://127.0.0.1:8080/sqlinject/jdbc?id=1
* */
@Controller
@RequestMapping("/sqlinject")
public class JdbcController {

    @Autowired
    private jdbcServiceImpl jdbcserviceimpl; // new ...

    @RequestMapping(value = "/jdbc",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String show(@RequestParam("id") String id){

        List userData = null;
        try {
            userData = jdbcserviceimpl.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(userData);
    }
}
