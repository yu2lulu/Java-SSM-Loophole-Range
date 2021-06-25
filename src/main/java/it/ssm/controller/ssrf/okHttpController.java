package it.ssm.controller.ssrf;


import it.ssm.service.impl.okHttpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/ssrf")
public class okHttpController {

    @Autowired
    private okHttpServiceImpl okHttpServiceImpl;

    @ResponseBody
    @RequestMapping(value = "okhttp",produces = {"text/html;charset=utf-8"})
    public String goAction(@RequestParam("url") String url){


        String response = null;
        try {
            response = okHttpServiceImpl.getUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

}
