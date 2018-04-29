package team.hymxj.entity;

import java.util.Date;

public class Category {
	private Integer id;
	private String name;
	private Short status;
	private Date createTime;
	private Date updateTime;
	public Category(){}
	
	public Category(Integer id, String name, Short status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Category(String name, Short status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
