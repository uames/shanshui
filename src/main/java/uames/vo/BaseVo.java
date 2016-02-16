package uames.vo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import uames.exception.VoException;
import uames.po.Base;
import uames.util.UamesUtil;

import com.jfinal.core.Controller;

public class BaseVo<T extends Base> {
    private T po;

    public BaseVo() {

    }

    public BaseVo(T t) {
        po = t;
    }

    public T getPo() {
        return po;
    }

    public void setPo(T po) {
        this.po = po;
    }

    public T getParam(Controller ctrl) throws VoException {
        for (String key : ctrl.getParaMap().keySet()) {
            if (key.substring(0, 3).equals("vo.")) {
                String[] prms = key.split("\\.");
                if (prms.length == 3) {
                    setParam(prms[0] + "." + prms[1], this, ctrl, prms[2]);
                } else {
                    setParam(key, this, ctrl, "");
                }
            } else if (key.substring(0, 3).equals("po.")) {
                setParam(key, po, ctrl, null);
            }
        }
        return po;
    }

    private void setParam(String key, Object obj, Controller ctrl, String child) throws VoException {
        try {
            Method method = null;
            Field field = null;
            if (child != null) {
                if (child.equals("")) {
                    method = obj.getClass().getMethod("set" + key.substring(3, 4).toUpperCase() + key.substring(4), String.class);
                } else {
                    method = obj.getClass().getMethod("set" + key.substring(3, 4).toUpperCase() + key.substring(4), String.class, String.class);
                }
            } else {
                field = UamesUtil.getField(obj.getClass(), key.substring(3));
                if (field == null) {
                    return;
                }
                method = obj.getClass().getMethod("set" + key.substring(3, 4).toUpperCase() + key.substring(4), field.getType());
            }
            if (method == null) {
                return;
            }
            if (child != null) {
                if (child.equals("")) {
                    method.invoke(obj, ctrl.getPara(key));
                } else {
                    method.invoke(obj, child, ctrl.getPara(key + "." + child));
                }
            } else if (field.getType() == String.class) {
                method.invoke(obj, ctrl.getPara(key));
            } else if (field.getType() == Long.class) {
                method.invoke(obj, ctrl.getParaToLong(key));
            } else if (field.getType() == Integer.class) {
                method.invoke(obj, ctrl.getParaToInt(key));
            } else if (field.getType() == Date.class) {
                method.invoke(obj, ctrl.getParaToDate());
            } else if (field.getType() == Float.class) {
                method.invoke(obj, Float.valueOf(ctrl.getPara(key)));
            } else if (field.getType() == Double.class) {
                method.invoke(obj, Double.valueOf(ctrl.getPara(key)));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            if (e.getTargetException().getClass() == VoException.class) {
                throw (VoException) e.getTargetException();
            } else {
                e.printStackTrace();
            }
        }

    }

}
