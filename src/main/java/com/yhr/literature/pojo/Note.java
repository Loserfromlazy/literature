package com.yhr.literature.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * note实体类
 * @author Administrator
 *
 */
@Table(name="tb_note")
public class Note implements Serializable{

	@Id
	private String id;//笔记id


	

	private String wid;//论文id

	private String uid;//用户id

	private String context;//笔记内容

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}


	
}
