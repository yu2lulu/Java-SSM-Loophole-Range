package it.ssm.tools;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

/*
 文件上传校验
 */
@Component
public class fileUploadCheck {
    private static String[] fileType = {".txt",".jpg",".png",".doc",".docs",".gif"};
    // 文件大小
    static public Boolean fileSizeCheck(){

        return true;
    }

    //文件类型
    static public Boolean fileTypeCheck(String FileName){
        if (FileName==null){
            return false;
        }
        int i = FileName.lastIndexOf(".");
        if (i==-1){
            return false;
        }else{
            String type = FileName.substring(i);
            int j = 0;
            for (j = 0; j < fileType.length; j++) {
                if (type.toLowerCase().equals(fileType[j])){
                    return true;
                }
            }
        }
        return false;
    }

}
