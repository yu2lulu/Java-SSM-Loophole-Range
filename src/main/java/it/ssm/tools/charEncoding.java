package it.ssm.tools;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.UnixCodec;
import org.springframework.stereotype.Component;
import sun.font.EAttribute;

/*
  用于过滤特殊字符，解决xss问题
 */
@Component
public class charEncoding {
    // html编码
    static public String charFilter(String content){
        String s = content.replaceAll("&", "&amp;");
        String s1 = s.replaceAll("<", "&lt;");
        String s2 = s1.replaceAll(">", "&gt;");
        String s3 = s2.replaceAll("\"", "&quot;");
        String s4 = s3.replaceAll("'", "&#x27;");
        String s5 = s4.replaceAll("/", "&#x2F;");

        return s5;
    }


    //html编码
     static public String charFilterESAPI(String content){
        return ESAPI.encoder().encodeForHTML(content);
    }

    //sql注入过滤编码
    static public String sqlFilter(String content){
        return ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD), content);
    }


    //命令执行esapi编码
    static public String osCmdFilterESAPI(String content){
        UnixCodec unixCodec = new UnixCodec();
        return ESAPI.encoder().encodeForOS(unixCodec,content);
    }
}
