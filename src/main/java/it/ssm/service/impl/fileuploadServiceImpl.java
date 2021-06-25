package it.ssm.service.impl;

import it.ssm.service.fileuploadService;
import it.ssm.tools.fileUploadCheck;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Service
public class fileuploadServiceImpl implements fileuploadService {

    @Override
    public Boolean fileuploadAction(MultipartFile file) throws IOException {
        //1.获取上传文件名
        String srcFileName = file.getOriginalFilename();

        //加入安全检测控制
//        Boolean isOk = fileUploadCheck.fileTypeCheck(srcFileName);
//        if (isOk==false){
//            return false;  //名称类型检测失败则不上传
//        }

        //2.获取需要上传到的路径位置
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        String path = servletContext.getRealPath("/")+File.separator+ "static";

        System.out.println("文件上传到本地路径为:"+path);
        //3.执行上传操作,最好文件随机字符串重命名处理
        file.transferTo(new File(path+File.separator+srcFileName));
        return true;
    }
}
