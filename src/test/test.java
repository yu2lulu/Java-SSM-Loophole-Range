import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.jupiter.api.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.UnixCodec;
import org.owasp.esapi.errors.EncodingException;
import org.springframework.web.context.ContextLoader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class test {
    @Test
    public void test1(){
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
    }


    @Test
    public void test2() throws IOException {
        String cmds = "ping 5 192.168.1.1 2  || cat /etc/passwd";
        String[] cmd = new String[]{"sh","-c",cmds};
        Process exec = Runtime.getRuntime().exec(cmd);

        InputStreamReader inputStreamReader = new InputStreamReader(exec.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;

        while ((line = bufferedReader.readLine()) != null)
            System.out.print(line);
    }

    @Test
    public void test3() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("sh", "-c", "ifconfig;cat /etc/passwd");
        Process start = processBuilder.start();
        InputStream inputStream = start.getInputStream();
        int len = 0;
        while ((len=inputStream.read())!=-1){
            System.out.print((char)len);
        }
    }

    @Test
    public void test4(){
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
    }

    @Test
    public void test5() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request req = new Request.Builder().get().url("http://www.baidu.com:9090").build();
        Response resp = okHttpClient.newCall(req).execute();

        System.out.println(resp.body().string());
        System.out.println(resp.code());

    }

    @Test
    public void test6(){
        String name = "sdlkjfsdkjftxt";
        int i = name.lastIndexOf(".");

        System.out.println(i);
        String substring = name.substring(i);
        System.out.println(substring);
    }

    @Test
    public void test7() throws EncodingException {
//        System.out.println(ESAPI.encoder().encodeForURL("../../../../../../../../etc/passwd"));
        UnixCodec unixCodec = new UnixCodec();
        System.out.println(ESAPI.encoder().encodeForOS(unixCodec,"/sbin/ping -c 1 localhost;cat /etc/passwd"));
    }

    @Test
    public void test8() throws DocumentException, SAXException, IOException, ParserConfigurationException, JDOMException, XMLStreamException {

        String input = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [   <!ELEMENT foo ANY >  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]><foo><t1>123</t1><t2>sdf</t2></foo>";


       // String input = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [   <!ELEMENT foo ANY >  <!ENTITY xxe SYSTEM \"http://139.199.209.148\" >]><foo>&xxe;</foo>";
////        String tmp = "";
//        SAXReader reader = new SAXReader();
//        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//        reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
//        reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//        Document document = reader.read(new InputSource(new StringReader(input)));
////

        //dom4j
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(new InputSource(new StringReader(input)));
//        Element root=document.getRootElement();
//        String stringValue = document.getStringValue();
//        System.out.println(stringValue);
//        String name = root.getName();
//        Object data = root.getData();
//        System.out.println(data);


        //jdom
//        SAXBuilder saxBuilder = new SAXBuilder();
//        org.jdom2.Document build = saxBuilder.build(new InputSource(new StringReader(input)));
//        org.jdom2.Element rootElement = build.getRootElement();
//        String text = rootElement.getText();
//        System.out.println(text);

        //stax
        String tmp ="";
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(input));
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if (reader.getName().toString().equals("foo")) {
                    tmp = reader.getElementText();
                }
            }
        }
        System.out.println(tmp);


    }


    @Test
    public void test9() throws MalformedURLException {
        URL url = new URL("http://www.baidu.com");

        String host = url.getHost();
        int port = url.getPort();
        System.out.println(host);
        System.out.println(port);
    }

    @Test
    public void test10() throws MalformedURLException {
        ArrayList<String> whiteHost = new ArrayList<>();
        whiteHost.add("www.baidu.com");
        whiteHost.add("www.qq.com");

        URL checkUrl = new URL("http://www.baidu.com:81/img/baidu.svg");
        String host = checkUrl.getHost();  //域名
        int port = checkUrl.getPort(); //端口

        System.out.println(host);
        System.out.println("port:"+port);

        if (whiteHost.indexOf(host.toLowerCase()) == -1){
            System.out.println("111111");
            System.out.println(host.toLowerCase());
        }

    }
}
