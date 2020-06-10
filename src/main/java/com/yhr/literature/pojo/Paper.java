package com.yhr.literature.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * paper实体类
 * @author Administrator
 *
 */
@Table(name="tb_paper")
public class Paper implements Serializable{

	@Id
	private String id;//论文id


	

	private String title;//论文题目

	private String author;//作者

	private String userId;//用户id

	private String company;//工作单位

	private java.util.Date createTime;//创建时间

	private java.util.Date lastTime;//最后修改时间

	private String outline;//文章概要

	private String keyWord;//关键词

	private Integer readNum;//阅读数

	private String nos;//主题编号

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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

	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) {
		this.outline = outline;
	}

	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getReadNum() {
		return readNum;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public String getNos() {
		return nos;
	}
	public void setNos(String nos) {
		this.nos = nos;
	}


	
}
