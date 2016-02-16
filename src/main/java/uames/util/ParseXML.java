package uames.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseXML {

    public static Map<String, String> getElementByXML(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            Iterator<?> it = root.elementIterator();
            while (it.hasNext()) {
                Element el = (Element) it.next();
                map.put(el.getName(), el.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
