package uames.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil <T> {
	private Integer page; 		// 当前页
	private Long pagesize;		// 每页的数量
	private Integer pagecount;	// 分页总数
	private Long count; 		// 数据总数
	private List<T> list;
	private Integer status;
	
	public PageUtil()
	{
		list = new ArrayList<T>();
		status = 1;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Long getPagesize() {
		return pagesize;
	}
	public void setPagesize(Long pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	

	
}
