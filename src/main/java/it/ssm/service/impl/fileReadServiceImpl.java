package it.ssm.service.impl;

import it.ssm.service.fileReadService;
import it.ssm.tools.charEncoding;
import it.ssm.tools.fileReadCheck;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import java.io.*;

@Service
public class fileReadServiceImpl implements fileReadService {

    @Override
    public String fileRead(String filePath) {
        //1.获取文件路径
        String staticPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/static");

        //安全检验
//        Boolean fileInDir = fileReadCheck.isFileInDir(filePath, new File(staticPath));
//        if (fileInDir==false){
//            return null;
//        }

        //2.得到文件路径
        File filepath = new File(staticPath+File.separator+filePath);

        //3.判断文件是否存在
        if(filepath.isFile()==false){
            return null; //表示不存在该文件
        }

        //3.读取文件内容并返回
        String sb = null;
        try {
            sb = readAction(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb;

    }

    @Override
    public String readAction(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                "UTF-8"));
        String lineTxt = null;
        StringBuilder sb = new StringBuilder();
        while ((lineTxt = br.readLine()) != null) { //数据以逗号分隔
            sb.append(lineTxt+"<br>");
        }
//        StringBuilder sb = new StringBuilder();
//        FileReader fileReader = new FileReader(file);
//        int read = 0;
//
//        while ((read = fileReader.read())!=-1){
//            sb.append((char) read);
//        }
        return sb.toString();
    }
}
