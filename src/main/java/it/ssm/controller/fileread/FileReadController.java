package it.ssm.controller.fileread;


import it.ssm.service.impl.fileReadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/*
 http://127.0.0.1:8080/fileread/read?file=1.txt
 http://127.0.0.1:8080/fileread/read?file=../../../../../../../../etc/passwd
* */
@Controller
@RequestMapping("fileread")
public class FileReadController {

    @Autowired
    private fileReadServiceImpl fileReadserviceimpl;

    @RequestMapping(value = "/read",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String readFile(@RequestParam("file") String file){

        String ret = null;

        ret = fileReadserviceimpl.fileRead(file);

        if (ret == null){
            ret = "当前文件不存在";
        }

        return ret;
    }
}
