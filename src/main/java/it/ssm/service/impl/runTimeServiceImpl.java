package it.ssm.service.impl;

import it.ssm.service.runTimeService;
import it.ssm.tools.charEncoding;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class runTimeServiceImpl implements runTimeService {

    @Override
    public String goAction(String ipaddr) throws IOException {

        //安全过滤
//        ipaddr= charEncoding.osCmdFilterESAPI(ipaddr);
//        System.out.println(ipaddr);

        String cmds = "/sbin/ping -c 1 " + ipaddr; ///sbin/ping -c 1 localhost;cat /etc/passwd
        String[] cmd = new String[]{"sh","-c",cmds};


        //执行命令获取返回值
        InputStream inputStream = Runtime.getRuntime().exec(cmd).getInputStream();
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while ((len=inputStream.read())!=-1){
            sb.append((char)len);
        }
        return sb.toString();
    }
}
