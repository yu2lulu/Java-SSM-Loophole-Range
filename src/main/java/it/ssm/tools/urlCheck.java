package it.ssm.tools;


import org.apache.ibatis.reflection.ArrayUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/*
* url 检测
* */
public class urlCheck {
    public static Boolean isValid(String url){

        ArrayList<String> whiteHost = new ArrayList<>();
        whiteHost.add("www.baidu.com");
        whiteHost.add("www.qq.com");

        int whitePort = 80;
        URL checkUrl = null;
        try {
            checkUrl = new URL(url);
            String host = checkUrl.getHost();  //域名
            int port = checkUrl.getPort(); //端口

            if (whiteHost.indexOf(host.toLowerCase()) == -1){
                return false;
            }

            if (port==-1){  //表示没有端口号，需要通过http和https进行判断
                if (url.toLowerCase().startsWith("https")){
                    return false;
                }
            }else if (whitePort != port ){
                return false;
            }else{
                return true;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
