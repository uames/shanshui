package uames.po;

public class Base {
   
	private Long id;
	private Long add_time;
	private Long update_time;
    private Integer status;
    private Integer sort;
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}

	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAdd_time() {
		return add_time;
	}

	public Long getUpdate_time() {
		return update_time;
	}
	
}
