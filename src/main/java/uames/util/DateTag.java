package uames.util;

import java.text.SimpleDateFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTag extends TagSupport {

    private String value;
    private String pattern;

    /**
	 * 
	 */
    private static final long serialVersionUID = -2778146367516880170L;

    @Override
    public int doStartTag() throws JspException {
        // TODO Auto-generated method stub
        String str = "";
        Long time = UamesUtil.IsLong(this.value);
        try {
            if(time > 0){
                if (this.pattern.equals("toNowM")) {
                    str = UamesUtil.getToNowMinutes(time);
                }else if(this.pattern.equals("toNowS")){
                    str = UamesUtil.getToNowSeconds(time);
                }else{
                    SimpleDateFormat format = new SimpleDateFormat(this.pattern);
                    str = format.format(time);
                } 
            }
            this.pageContext.getOut().write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}
