package it.ssm.controller.xxe;

import com.alibaba.fastjson.JSON;
import it.ssm.domain.article;
import it.ssm.domain.retMessage;
import it.ssm.service.impl.dom4jServiceImpl;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;

@Controller
@RequestMapping("/xxe")
public class dom4jController {

    @Autowired
    private dom4jServiceImpl dom4jserviceImpl;

    @ResponseBody
    @RequestMapping(value = "/dom4j",produces = {"application/json;charset=utf-8"})
    public String dom4jAction(@RequestBody String data) throws SAXException {
        System.out.println(data);

        //解析xml文件
         SAXReader reader = new SAXReader();

         //禁止外部DTD
//        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//        reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
//        reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        retMessage ret = new retMessage();
        try {
            Document document = reader.read(new InputSource(new StringReader(data)));
            Element root=document.getRootElement();
            String id = document.getStringValue();
            article OneArticle = dom4jserviceImpl.getArticleById(id);
            ret.setStatusCode(200);
            ret.setData(OneArticle);
            ret.setReqData(id);

        } catch (DocumentException e) {
            e.printStackTrace();

            ret.setStatusCode(500);
            ret.setData(e.getMessage());
            ret.setReqData(data);
        }

        return JSON.toJSONString(ret);
    }
}
