package it.ssm.controller.sqlinject;


import com.alibaba.fastjson.JSON;
import it.ssm.domain.Userinfo;
import it.ssm.service.impl.myBatisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * http://127.0.0.1:8080/sqlinject/mybatis?id=1
 *
 */
@Controller
@RequestMapping("/sqlinject")
public class MyBatisController {

    @Autowired
    private myBatisServiceImpl myBatisService;

    @RequestMapping(value = "/mybatis",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getUserinfo(@RequestParam("id") String id){

        Userinfo userinfo = myBatisService.getUserById(id);

        return JSON.toJSONString(userinfo);
    }

}
