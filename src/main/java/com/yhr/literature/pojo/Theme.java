package com.yhr.literature.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * theme实体类
 * @author Administrator
 *
 */
@Table(name="tb_theme")
public class Theme implements Serializable{

	@Id
	private String id;//主题id


	

	private Integer no;//主题编号

	private String name;//主题名

	private String keyWord;//关键词

	private String message;//主题说明

	private String userId;//用户id

	private java.util.Date createTime;//创建时间

	private java.util.Date lastTime;//上次修改时间

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}


	
}
