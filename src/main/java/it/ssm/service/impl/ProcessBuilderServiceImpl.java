package it.ssm.service.impl;

import it.ssm.service.ProcessBuilderService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ProcessBuilderServiceImpl implements ProcessBuilderService {
    @Override
    public String goAction(String ipaddr) throws IOException {
        String cmds = "/sbin/ping -c 1 " + ipaddr;
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c",cmds);
        Process start = processBuilder.start();
        InputStream inputStream = start.getInputStream();
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len=inputStream.read())!=-1){
            System.out.print((char)len);
            sb.append((char)len);
        }
        return sb.toString();
    }
}
