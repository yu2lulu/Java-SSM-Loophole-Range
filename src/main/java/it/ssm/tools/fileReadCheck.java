package it.ssm.tools;

import java.io.File;

/*
任意文件读取过滤函数
* */
public class fileReadCheck {
    //判断字符串格式的文件名是否在目录中存在
    static public Boolean isFileInDir(String fileName, File dir){
        if(dir.isDirectory()==false){
            return false;
        }
        //1。获取目录下的所有文件名
        File[] files = dir.listFiles();

        System.out.println(fileName);
        for (int i = 0; i < files.length; i++) {
            if (fileName.equals(files[i].getName())){
                return true;
            }
        }
        return false;
    }
}
