package uames.process;
 
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1:将JavaBean转换成Map、JSONObject
 * 2:将Map转换成Javabean
 * 3:将JSONObject转换成Map、Javabean
 * 
 * @author Alexia
 */

public class JsonHelper {
    
    /**
     * 将Javabean转换为Map
     * 
     * @param javaBean
     *            javaBean
     * @return Map对象
     */
    public static Map<String, String> toMap(Object javaBean) {

        Map<String, String> result = new HashMap<String, String>();
        Method[] methods = javaBean.getClass().getDeclaredMethods();

        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {

                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);

                    Object value = method.invoke(javaBean, (Object[]) null);
                    result.put(field, null == value ? "" : value.toString());

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return result;

    }

   
}