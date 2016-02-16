package common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("serial")
public class Log4jInit extends HttpServlet{
	public void init(ServletConfig config) throws ServletException {
        String prefix = config.getServletContext().getRealPath("/"); //获取当前路径
        String file = config.getInitParameter("log4j");//从web.xml中获取参数值,找到log4j这个文件
        System.setProperty("webRoot", prefix); //log4j.properties文件中的变量是在这里设置的
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);
        }
    }
}
