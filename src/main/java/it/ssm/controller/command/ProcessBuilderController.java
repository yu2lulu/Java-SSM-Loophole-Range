package it.ssm.controller.command;

import it.ssm.service.impl.ProcessBuilderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
/*
 http://127.0.0.1:8080/cmd/processbuild?ip=localhost
* http://127.0.0.1:8080/cmd/processbuild?ip=localhost;cat%20/etc/passwd
* */
@Controller
@RequestMapping("/cmd")
public class ProcessBuilderController {
    @Autowired
    private ProcessBuilderServiceImpl processbuilderserviceimpl;

    @RequestMapping("/processbuild")
    @ResponseBody
    public String run(@RequestParam("ip") String ip){

        String ret = null;
        try {
            ret = processbuilderserviceimpl.goAction(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
