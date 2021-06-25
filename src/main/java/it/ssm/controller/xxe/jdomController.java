package it.ssm.controller.xxe;


import com.alibaba.fastjson.JSON;
import it.ssm.domain.article;
import it.ssm.domain.retMessage;
import it.ssm.service.impl.dom4jServiceImpl;
import it.ssm.tools.xml2hashmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xxe")
public class jdomController {

    @Autowired
    private dom4jServiceImpl dom4jserviceImpl;

    @ResponseBody
    @RequestMapping(value = "/jdom",produces = {"application/json;charset=utf-8"})
    public String jdomAction(@RequestBody String input){

        retMessage ret = new retMessage();
        try {
            String id = xml2hashmap.getAttribute(input, "id");

            article OneArticle = dom4jserviceImpl.getArticleById(id); // id = /etc/passwd的内容
            ret.setStatusCode(200);
            ret.setData(OneArticle); // null
            ret.setReqData(id);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setStatusCode(500);
            ret.setData(e.getMessage());
            ret.setReqData(input);
        }

        return JSON.toJSONString(ret);
    }
}
