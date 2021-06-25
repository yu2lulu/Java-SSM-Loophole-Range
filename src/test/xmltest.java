import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 遍历xml所有节点（包括子节点下还有子节点多层嵌套）
 */
public class xmltest {

    public static void main(final String[] args) {
        String input = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!DOCTYPE foo [   <!ELEMENT foo ANY >  <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]><foo><t1>&xxe;</t1><t2>sdf</t2></foo>";

        final xmltest test = new xmltest();
        try {
            HashMap<String, String> stringStringHashMap = test.testGetRoot(input);
            System.out.println(stringStringHashMap);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 获取文件的xml对象，然后获取对应的根节点root
     */
    public HashMap<String, String> testGetRoot(String data) throws Exception {
//        final SAXReader sax = new SAXReader();// 创建一个SAXReader对象
        SAXBuilder saxBuilder = new SAXBuilder();
        org.jdom2.Document document = saxBuilder.build(new InputSource(new StringReader(data)));
//        final Document document = sax.read(new InputSource(new StringReader(data)));// 获取document对象,如果文档无节点，则会抛出Exception提前结束
//        final Element root = document.getRootElement();// 获取根节点
        org.jdom2.Element root = document.getRootElement();

        List<org.jdom2.Element> listElement = root.getChildren();

//        final List<Element> listElement = root.elements();// 所有一级子节点的list
        HashMap<String, String> sh = new HashMap<>();
        for (org.jdom2.Element e:listElement) {
            sh.put(e.getName(),e.getTextTrim());

        }

//        for (final Element e : listElement) {// 遍历所有一级子节点
//            sh.put(e.getName(),e.getTextTrim());
//        }

        return sh;

    }

    /**
     * 从指定节点Element node开始,递归遍历其所有子节点
     */
    public void getNodes(final Element node) {
//        System.out.println("-------开始新节点-------------");
//
//        // 当前节点的名称、文本内容和属性
//        System.out.println("当前节点名称：" + node.getName());// 当前节点名称
//        System.out.println("当前节点的内容：" + node.getTextTrim());// 当前节点内容
//        final List<Attribute> listAttr = node.attributes();// 当前节点的所有属性
//        for (final Attribute attr : listAttr) {// 遍历当前节点的所有属性
//            final String name = attr.getName();// 属性名称
//            final String value = attr.getValue();// 属性的值
//            System.out.println("属性名称：" + name + "---->属性值：" + value);
//        }

        // 递归遍历当前节点所有的子节点
        final List<Element> listElement = node.elements();// 所有一级子节点的list
        for (final Element e : listElement) {// 遍历所有一级子节点
//            getNodes(e);// 递归
            System.out.println(e.getName());
            System.out.println(e.getTextTrim());
        }
    }
}
