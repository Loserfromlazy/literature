package com.yhr.literature.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * paperDetails实体类
 * @author Administrator
 *
 */
@Table(name="tb_paper_details")
public class PaperDetails implements Serializable{

	@Id
	private String id;//论文详情id


	

	private String wid;//论文id

	private String content;//论文内容

	
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

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
}
