package it.ssm.controller.sqlinject;


import com.alibaba.fastjson.JSON;
import it.ssm.domain.Userinfo;
import it.ssm.service.impl.jdbcTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * http://127.0.0.1:8080/sqlinject/jdbctemplate?id=1
 *
*/
@Controller
@RequestMapping("/sqlinject")
public class JdbcTemplateController {

    @Autowired
    private jdbcTemplateServiceImpl jdbcTemplateService;


    @RequestMapping(value = "/jdbctemplate",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String jdbcTemplate(@RequestParam("id") String id){

        Userinfo userinfoOne = jdbcTemplateService.getUserinfoOne(id);

        //预编译处理调用
//        Userinfo userinfoOne = jdbcTemplateService.getUserinfoOneSafe(id);

        String ret = JSON.toJSONString(userinfoOne);

        return ret;
    }
}
