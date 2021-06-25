package it.ssm.controller.fileupload;


import com.alibaba.fastjson.JSON;
import it.ssm.service.impl.fileuploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/*
* http://127.0.0.1:8080/fileupload/multipart
* */
@Controller
@RequestMapping("/fileupload")
public class MultipartFileController {

    @Autowired
    private fileuploadServiceImpl fileuploadserviceimpl;

    @RequestMapping(value = "/multipart",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String fileupload(MultipartFile file) throws IOException {
        Boolean aBoolean = fileuploadserviceimpl.fileuploadAction(file);

        HashMap<String, String> ret = new HashMap<>();

        if (aBoolean == true){  //上传成功
            ret.put("data","200");
            ret.put("msg","上传成功");
            ret.put("path","/static/"+file.getOriginalFilename());
        }else{  //上传失败
            ret.put("data","400");
            ret.put("msg","上传失败");
            ret.put("path","");
        }


        return JSON.toJSONString(ret);
    }
}
