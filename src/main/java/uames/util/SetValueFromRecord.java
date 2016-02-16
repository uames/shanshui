package uames.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.jfinal.plugin.activerecord.Record;

public class SetValueFromRecord {
 
    public static void copyProtis(Object obj, Record record) {
    	if(record==null)
    		return;
        for (Field m : UamesUtil.getFields(obj.getClass())) {
            try {
                String methName = m.getName().substring(0, 1).toUpperCase() + m.getName().substring(1);
                Method method = obj.getClass().getMethod("set" + methName, m.getType());
                String value = String.valueOf(record.get(m.getName().toLowerCase())==null?"":record.get(m.getName().toLowerCase()));
                if (value == null || value.equals("") || value.equals("null")) { // 如果为null或者为空字符串
                    continue; // 终止此次循环
                }

                if (m.getType() == String.class) { // String 类型
                    method.invoke(obj, value);
                } else if (m.getType() == Long.class) {// 长整形
                    method.invoke(obj, Long.parseLong(value));
                } else if (m.getType() == Integer.class) {// 整形类型
                    method.invoke(obj, Integer.parseInt(value));
                } else if (m.getType() == Date.class) {// 日期类型
                    method.invoke(obj, new Date(Long.parseLong(value)));
                } else if (m.getType() == Float.class) {// double类型
                    method.invoke(obj, Float.parseFloat(value));
                } else if (m.getType() == Double.class) { // 浮点类型
                    method.invoke(obj, Double.parseDouble(value));
                }
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static Record GetRecordFromObj(Object obj) {
        Record record = new Record();
        for (Field m : UamesUtil.getFields(obj.getClass())) {
            try {
                String methName = m.getName().substring(0, 1).toUpperCase() + m.getName().substring(1);
                Method method = obj.getClass().getMethod("get" + methName);
                Object result = method.invoke(obj);
                if (result != null) {
                    String value = String.valueOf(result);
                    if (method.getReturnType() == Long.class) {
                        record.set(m.getName().toLowerCase(), Long.parseLong(value));
                    } else if (method.getReturnType() == Integer.class) {
                        record.set(m.getName().toLowerCase(), Integer.parseInt(value));
                    } else if (method.getReturnType() == String.class) {
                        record.set(m.getName().toLowerCase(), value);
                    } else if (method.getReturnType() == Date.class) {
                        record.set(m.getName().toLowerCase(), UamesUtil.getFormatBydate("yyyy-MM-dd HH:mm:ss", result));
                    } else {
                        record.set(m.getName().toLowerCase(), result);
                    }
                }
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return record;
    }
}
