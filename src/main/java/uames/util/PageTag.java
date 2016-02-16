package uames.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {

    /**
	 * 
	 */
    private static final long serialVersionUID = 8966181381030149715L;

    private Integer page; // 当前页
    private Integer count;// 总页数
    private String url;// 链接地址

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
	 * 
	 */

    @Override
    public int doStartTag() throws JspException {
        // TODO Auto-generated method stub
        try {
            StringBuffer buffer = new StringBuffer();
            @SuppressWarnings("unchecked")
            Map<String, String[]> p = pageContext.getRequest().getParameterMap();
            Iterator<Entry<String, String[]>> it = p.entrySet().iterator();
            String prm = "";
            /*while (it.hasNext()) {  
                Entry<String, String[]> entry = it.next();
                if (!entry.getKey().equals("page") && entry.getValue().length > 0) {
                    //prm += String.format("{%}={%}&", entry.getKey(), entry.getValue()[0]);
                    prm += entry.getKey() + "=" + entry.getValue()[0] + "&";
                }
            }*/
            url += "?" + prm;
            if (count > 0) {
                page = page < 1 ? 1 : page;
                buffer.append("<ul class=\"page\"><li><a class=\"one\">第" + page + "页/共" + count + "页</a></li>");
                // 首页
                buffer.append("<li><a href=\"" + url + "page=1\">首页</a></li>");

                if (page > 1) { // 还有上一页
                    buffer.append("<li><a href=\"" + url + "page=" + (page - 1) + "\">上一页</a></li>");
                }

                Integer maxShowPage = 5; // 最多显示4页
                Integer Lmax = 2;
                Integer Rmax = 2;
                Integer startPage = page - Lmax;
                Integer endPage = page + Rmax;

                if (page <= Lmax) {
                    startPage = 1;
                    endPage = maxShowPage;
                }
                if (count <= maxShowPage) {
                    startPage = 1;
                    endPage = count;
                }
                if (count > maxShowPage && count - page <= Rmax) {
                    startPage = count - maxShowPage + 1;
                    endPage = count;
                }

                for (Integer i = startPage; i <= endPage; i++) {
                    if (i == page)
                        buffer.append("<li><a class=\"current\" href=\"" + url + "page=" + i + "\">" + i + "</a></li>");
                    else
                        buffer.append("<li><a href=\"" + url + "page=" + i + "\">" + i + "</a></li>");
                }
                /*
                 * //当前页的前半部分 for(int i=6;i>0;i--){ if(page-i>0){
                 * buffer.append("<li><a href=\""
                 * +url+"?page="+(page-i)+"\">"+(page-i)+"</a></li>"); } }
                 * 
                 * //当前页
                 * buffer.append("<li><a href=\"#\" class=\"cur\">"+page+"</a></li>"
                 * ); //当前页的后半部分 for(int i=1;i<=5;i++){ if(page+i<=count){
                 * buffer
                 * .append("<li><a href=\""+url+"?page="+(page+i)+"\">"+(page
                 * +i)+"</a></li>"); } }
                 */
                // 还有下一页
                if (page < count) {
                    buffer.append("<li><a href=\"" + url + "page=" + (page + 1) + "\">下一页</a></li>");
                }
                // 尾页
                buffer.append("<li><a href=\"" + url + "page=" + count + "\">尾页</a></li></ul>");

            } else {
                buffer.append("<ul class=\"page\"><li><span style=\"color:#f00\">没有记录！</span></li></ul>");
            }
            this.pageContext.getOut().write(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }
}
