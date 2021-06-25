package it.ssm.controller.command;


import it.ssm.service.impl.runTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/*
 http://127.0.0.1:8080/cmd/runtime?ip=localhost
* http://127.0.0.1:8080/cmd/runtime?ip=localhost;cat%20/etc/passwd
* */
@Controller
@RequestMapping("/cmd")
public class RuntimeController {

    @Autowired
    private runTimeServiceImpl runTimeService;

    @RequestMapping("/runtime")
    @ResponseBody
    public String run(@RequestParam(value = "ip") String ip){

        System.out.println(ip);

        String ret = null;
        try {
            ret = runTimeService.goAction(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
