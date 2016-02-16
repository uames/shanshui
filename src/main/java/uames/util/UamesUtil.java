package uames.util;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UamesUtil {
    public static String formatString(String name) {
        try {
            if (!name.contains("_")) {
                return name;
            } else {
                while (name.contains("_")) {
                    int beginindex = name.indexOf("_");
                    name = name.substring(0, beginindex)
                            + name.substring(beginindex + 1, beginindex + 2)
                                    .toUpperCase()
                            + name.substring(beginindex + 2);
                }
                return name;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFormatBydate(String format, Object date) {
        try {
            SimpleDateFormat fm = new SimpleDateFormat(format);
            return fm.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 时间戳转换成时间格式
     * @param _time
     * @param format
     * @return
     */
    public static String getStrTime(Long _time,String format){
        String time ="";
        try {
            if(format == null)
                format = "yyyy-MM-dd HH:mm:ss";
            if(_time!=null){
                Date new_date = new Date(_time); 
                time = new SimpleDateFormat(format).format(new_date); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
    public static Date getDateByFormat(String format, String date){
    	try {
            SimpleDateFormat fm = new SimpleDateFormat(format);
            return fm.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    	
    }

    public static Field[] getFields(Class<?> clazz) {
        try {
            Field[] field = clazz.getDeclaredFields();
            if (field == null) {
                field = clazz.getSuperclass().getDeclaredFields();
                return field;
            } else {
                List<Field> list = new ArrayList<Field>();
                for (Field fb : clazz.getSuperclass().getDeclaredFields()) {
                    list.add(fb);
                }
                for (Field m : field) {
                    list.add(m);
                }
                return list.toArray(new Field[list.size()]);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Field getField(Class<?> clazz, String name) {
        Field result = null;
        try {
            result = clazz.getDeclaredField(name);
        } catch (Exception e) {
        }
        if (result == null) {
            try {
                result = clazz.getSuperclass().getDeclaredField(name);
            } catch (Exception e) {
            }
        }
        return result;
    }
    
    /*
     * 根据对象获取json字符串串
     */
    public static String getJSONStringFromObject(Object obj) {
        try {
            JSONObject json = JSONObject.fromObject(obj);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * 根据列表对象获取json字符串串
     */
    public static String getJSONStringFromList(List<?> list) {
        try {
            JSONArray json = JSONArray.fromObject(list);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getRandomCode(Integer length){
    	String str="";
    	Random random=new Random();
    	for(int i=0;i<length;i++){
    		str+=random.nextInt(10);
    	}
    	return str;
    }
    
    public static String getRandomString(int length) { //length表示生成字符串的长度  
        String base = "AaBbC0cDdEe1FfGgHh2IiJjK3kLlMm4NnOoP5pQqRr6SsTtU7uVvWw8XxYyZ9z"; //包含a-z,A-Z,0-9的字符串,且都只包含一个
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();     
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }     
        return sb.toString();     
     }     

    public static String getGlobalID() {
        Long time = new Date().getTime();
        String str = getRandStr();
        String str1 = getRandStr();
        return ParseMD5.parseStrToMd5L32(str + str1 +  time.toString());
    }
    public static String fomatDate(Long time,String parttern){
        String reval ="";
    	try{
    	    if(time!=null){
                if(parttern==null)
                    parttern="yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat format=new SimpleDateFormat(parttern);
                reval = format.format(time);   
    	    }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return reval;
    }
	
    /**
	 * 判断字符串是否为空(非空false;否则true)
	 * @param str
	 * @return
	 */
    public static Boolean IsNullOrWhiteSpace(String str){
    	Boolean result;
    	if(str==null || str.equals("")){
    		result = true;
    	}
    	else
    		result=false;
    	return result;
    }
    public static String IsString(String _str){
        String str ="";
        try {
            if(!IsNullOrWhiteSpace(_str))
                str = _str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public static Long IsLong(String str){
    	Long val= Long.valueOf(0);
    	try{
    		if(!IsNullOrWhiteSpace(str)){
    			val = Long.valueOf(str);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return val;
    }
    public static Integer IsInt(Double val){
        Integer reval = 0;
        try {
            if(val !=null && val >0){
                String _val = Double.toString(val);
                reval = IsInt(_val);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return reval;
    }
    public static Integer IsInt(String str){
        Integer val= 0;
        try{
            if(!IsNullOrWhiteSpace(str)){
                val = Integer.valueOf(str);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return val;
    }
    public static Double IsDouble(String str){
    	Double val= Double.valueOf(0);
    	try{
    		if(!IsNullOrWhiteSpace(str)){
    			val = Double.valueOf(str);
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return val;	
    }
    /**
     * 判断是否有效值
     * @param val
     * @return
     */
    public static Boolean istPositiv(Double val){
		if (val<=0){
			return false;
		}
		return true;
	}
    
    /**
     * 获取某个时间到当前时间的分钟数
     * @param val
     * @return
     */
    public static String getToNowMinutes(Long time){
    	Long minute = (time - new Date().getTime())/60000;
		return String.valueOf(minute);
	}
    
    public static String getToNowSeconds(Long time) {
        Long second = (time - new Date().getTime())/1000;
        return String.valueOf(second);
    }
    
   

    /**
     * 转换时间戳(dateString :　"yyyy-MM-dd HH:mm:ss")
     * @param dateString
     * @param format
     * @param hours(+,- 表示加减时间)
     * @return
     */
    public static Long getTimeStamp(String dateString, String format,Integer hours) {
        Long val =Long.valueOf(0);
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        } 
        if(hours == null)
            hours = 0;

        try {
            if(dateString!=null&&!dateString.equals("")){
                SimpleDateFormat dateFor = new SimpleDateFormat(format);
                if(hours > 0){
                    val = dateFor.parse(dateString).getTime();
                    Date new_date = new Date(val);  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(new_date); 
                    String _dayafter = dayAfter + " " +hours.toString() +":00:00";
                    new_date = sdf.parse(_dayafter);
                    val = new_date.getTime();
                }else{
                    val = dateFor.parse(dateString).getTime();
                }  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return val;
    }   
    /**
     * 指定日期的‘前/后’ N 天
     * @param date
     * @param days
     * @return
     */
    public static Long getSpecifiedDayBefore(Date date,Integer days){
        Long reval=Long.valueOf(0);
        try{
            String fromat = "yyyy-MM-dd HH:mm:ss";
            Date new_date = new Date();  
            Calendar c = Calendar.getInstance();
            c.setTime(date); 
            int day = c.get(Calendar.DATE);  
            c.set(Calendar.DATE, day + days);       // 前一天: -1；
                                                    // 后一天: +1；
            new_date  =c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat(fromat);
            String dayAfter = new SimpleDateFormat(fromat).format(new_date); 
            new_date = sdf.parse(dayAfter);
            reval = Long.valueOf(new_date.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }

        return reval;
    }
    /**
     * 日期 +-
     * @param time
     * @param days
     * @return
     */
    public static Long getSpecifiedDayBefore(Long time,Integer days){
        Long val = Long.valueOf(0);
        try {
            String format = "yyyy-MM-dd HH:mm:ss";
            String ss= getStr2Time(time, format);
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            Date date = sdf.parse(ss);  
            val = getSpecifiedDayBefore(date,days);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
	/**
	 * 获取指定日期的指定时间点（小时）
	 * @param date
	 * @param days
	 * @param hours(1-24)
	 * @return
	 */
	public static Long getDateTimeAfterDays(Date date,Integer days,Integer hours){
		Long reval=Long.valueOf(0);
		try{
			Date new_date = new Date();  
			Calendar c = Calendar.getInstance();
			Integer _hours=0;
			c.setTime(date); 
			int day = c.get(Calendar.DATE);  
			c.set(Calendar.DATE, day + days);		// 前一天: -1；
													// 后一天: +1；
			if(hours>=1 && hours<=24)
				_hours = hours;
			else
				_hours = 24;
			new_date  =c.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(new_date); 
			String _dayafter = dayAfter + " " +_hours.toString() +":00:00";
			new_date = sdf.parse(_dayafter);
			reval = Long.valueOf(new_date.getTime());

		}catch(Exception e){
			e.printStackTrace();
		}

		return reval;
	}
	
   
    
    public static Long getLongTime(String dateString, String format) {
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss";
        } 
        try {
            SimpleDateFormat dateFor = new SimpleDateFormat(format);
            return dateFor.parse(dateString).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
  /**
   * 时间戳转换成时间格式
   * @param _time
   * @param format
   * @return
   */
    public static String getStr2Time(Long _time,String format){
        String time ="";
        try {
            if(format == null)
                format = "yyyy-MM-dd HH:mm:ss";
            if(_time!=null && _time.longValue() > 0){
                Date new_date = new Date(_time); 
                time = new SimpleDateFormat(format).format(new_date); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }
    
    /**
     * 千分号
     * @param reval
     * @param digit
     * @return
     */
    public static String getStrFormat(Double reval,Integer digit){
        String s_reval ="";
        try {
            DecimalFormat format=new DecimalFormat(",###.00");
            Double t_val = getDFormat(reval,digit);
            if(t_val >=1000.00)
                s_reval = format.format(UamesUtil.getDFormat(reval,digit));
            else
                s_reval =t_val.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s_reval;
    }
    
    /**
     * 千分号
     * @param reval
     * @param digit
     * @return
     */
    public static String getStrFormat1(Double reval,Integer digit){
        String s_reval ="";
        try {
            DecimalFormat format=new DecimalFormat(",###.000");
            if(getDFormat(reval,digit) >0)
                s_reval = format.format(UamesUtil.getDFormat(reval,digit));
            else
                s_reval ="0.0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s_reval;
    }
    
    public static String getStrFormat(Long reval,Integer digit){
        String s_reval ="";
        try {
            DecimalFormat format=new DecimalFormat(",###");
            if(reval >0)
                s_reval = format.format(reval);
            else
                s_reval ="0";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s_reval;
    }
    
    /**
     * 格式化double类型
     * @param _val
     * @param digit 保留小数点后面位数
     * @return
     */
    public static Double getDFormat(Double _val,Integer digit){
        Double val = 0.00;
        String tmp ="";
        try {
            DecimalFormat df =null;
            if(digit== 1)
                df = new DecimalFormat("#.0");   // 小数点后1位
            else if(digit == 2)
                df = new DecimalFormat("#.00");   // 小数点后2位
            else if(digit == 3)
                df = new DecimalFormat("#.000");   // 小数点后3位
            else
                df = new DecimalFormat("#.00");   // 小数点后2位
            
            if(_val!=null && _val > 0){
                tmp = df.format(_val);
                val =  IsDouble(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
 
    public static String getStringDFormat(Double _val,Integer digit){
        String str = "";
        try {
            str =  getDFormat(_val,digit).toString();
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        return str;
    }

     /**
      * 获取JSON的键值
      * @param config
      * @param key
      * @return
      */
    public static String getJsonValue(String config,String key){
        String str ="";
        try {

            JSONArray jsonArray = JSONArray.fromObject(config);
            int size = jsonArray.size();
            for(Integer  i = 0; i < size; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name ="";
                name = UamesUtil.IsString(jsonObject.getString("name"));
                if(name.equals(key)){
                    str = jsonObject.getString("value");
                    break;
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * Double 转换成Long
     * @param _val
     * @return
     */
    public static Long Double2Long(Double _val){
        Long reval = Long.valueOf(0);
        try {
            if(_val!=null){
                String _tep = _val.toString();
                if(!UamesUtil.IsNullOrWhiteSpace(_tep)){
                    String s_val = _tep.substring(0, _tep.lastIndexOf("."));
                    reval = Long.valueOf(s_val);  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reval;
    }
    /**
     * Long 转换成 Double
     * @return
     */
    public static Double Long2Double(Long _val){
        Double reval = 0.00;
        if(_val.longValue()>0){
            reval = new Double(_val.toString());
        }
        return reval;
    }
    public static String getPrint(HttpServletResponse response){
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>");
            //out.println("window.close();");
           // out.println("document.getElementByTagName('body').style.display='none';");
            out.println("alert('支付成功，请关闭当前浏览器')");
            out.println("</script>");
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;  
     }
    public static String getIpAddr(HttpServletRequest request) {
        if (null == request) {
            return null;
        }
        String proxs[] = { "X-Forwarded-For", "Proxy-Client-IP",
                "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR","x-forwarded-for"
                ,"X-Real-IP"};
 
        String ip = null;
 
        for (String prox : proxs) {
            ip = request.getHeader(prox);
            if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip) || "127.0.0.1".equalsIgnoreCase(ip)) {
                continue;
            } else {
                break;
            }
        }
        if(ip == null || ip.length() == 0 || "127.0.0.1".equalsIgnoreCase(ip)) { 
            try {
                Enumeration<NetworkInterface> netIf = NetworkInterface.getNetworkInterfaces();
                while (netIf.hasMoreElements()) {
                    NetworkInterface nwi = netIf.nextElement();
                    Enumeration address = nwi.getInetAddresses();
                    while (address.hasMoreElements()) {
                        InetAddress in = (InetAddress) address.nextElement();
                        if(in.isSiteLocalAddress()){
                            String tempipv4 = InetAddress.getLocalHost().getHostAddress();
                            if(ip == null || ip.length() == 0 || tempipv4.equals("127.0.0.1")){
                                ip = in.getHostAddress();
                            }else{
                                ip = tempipv4;
                            }
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isBlank(ip) || "127.0.0.1".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
   public static String getUri(HttpServletRequest request){
       String uri ="";
       try{
           String url = request.getHeader("referer");
           if(!UamesUtil.IsNullOrWhiteSpace(url))
               uri = url;          
       }catch (Exception e) {
           e.printStackTrace();
       }
       return uri;
   }
   /**
    * 过滤、判断非法字符
    * 判断字符串是否只包含字母、数字、中文和下划线，是返回true，否则返回false。
    * m.replaceAll("").trim()返回的字符串为清除了所有非法字符后的字符串。
    * @param str
    * @return
    * @throws PatternSyntaxException
    */
   public static boolean StringFilter(String str) throws PatternSyntaxException{
       String regEx="[`~!@#$%^&*()+=|{}':;',//[//]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
       Pattern  p = Pattern.compile(regEx);
       Matcher  m = p.matcher(str);
       return   m.replaceAll("").trim().length()==str.length();
   }

   /**
    * ‘0-9 + a-z’ 随机码
    * @return String
    */
   public static String getRandStr()
   {
       StringBuffer array = new StringBuffer();
       for (int i = 0; i <= 9; i++) {
           array.append(i);
       }
       for (int i = 'a'; i <= 'z'; i++) {
           array.append((char) i);
       }
       int length = array.length();
       int n = 7;
       StringBuffer str = new StringBuffer("");
       for (int i = 0; i < n; i++) {
           char c = array.charAt((int) (Math.random() * length));
           str.append(c);
       }
       String fix = "cjj_";
       return fix + str.toString();        
   }
   
}
