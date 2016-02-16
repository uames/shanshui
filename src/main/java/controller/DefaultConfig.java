package controller;

import java.util.Properties;

import uames.util.JedisUtil;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.sun.xml.internal.fastinfoset.stax.events.Util;

public class DefaultConfig extends JFinalConfig {
    
    private static Properties properties;
    
    @SuppressWarnings("restriction")
	public static String getPropery(String key) {
        String url = properties.getProperty(key);
        String result="";
        if(!Util.isEmptyString(url)){
            result = properties.getProperty(key).trim();
        }else{
            // jdbc:mysql://192.168.1.91/aucn01?useUnicode=true&characterEncoding=utf8
            // jdbc:mysql://10.0.0.24/aucn01?useUnicode=true&characterEncoding=utf8
            result = JedisUtil.get(key).trim();         
        }
        return result;
    }
    
    public static Integer getIntPropery(String key) {
        return Integer.valueOf(getPropery(key));
    }
    
    public static Long getLongPropery(String key) {
        return Long.valueOf(getPropery(key));
    }
    
    public static Boolean getBoolPropery(String key) {
        return Boolean.valueOf(getPropery(key));
    }
    
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setViewType(ViewType.JSP);
        me.setError404View("/WEB-INF/view/doc/nofind404.jsp");
        me.setError500View("/WEB-INF/view/doc/nofind500.jsp");
        properties = loadPropertyFile("web.properties");
    }

    @Override
    public void configHandler(Handlers arg0) {
        // TODO 自动生成的方法存根
        arg0.add(new ContextPathHandler("ctx_path"));

    }

    @Override
    public void configInterceptor(Interceptors arg0) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void configPlugin(Plugins me) {
        C3p0Plugin cp = new C3p0Plugin(getPropery("data_url"), getPropery("data_user"), getPropery("data_pwd"));
        me.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        me.add(arp);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", MainController.class);
        me.add("/member", MemberController.class);
    }
}
