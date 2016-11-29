package com.dcits.djk.manager.util;

import java.util.List;

public class TreeNodeBean implements Comparable<TreeNodeBean>{
	private String id = "";
	private String text = "";
	private String parentId = "";
	private String code = "";
	private List<TreeNodeBean> children;
	public TreeNodeBean(String id,String text,String parentId,String code){
		this.id = id;
		this.text = text;
		this.parentId = parentId;
		this.code = code;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<TreeNodeBean> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNodeBean> children) {
		this.children = children;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public int compareTo(TreeNodeBean o) {
		if(o == null){
			return 1;
		}
		int i = this.code.compareTo(o.getCode());
		return i;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"id\":");
		sb.append("\""+this.id+"\"");
		sb.append(",\"text\":");
		sb.append("\""+this.text+"\"");
		sb.append(",\"parentId\":");
		sb.append("\""+this.parentId+"\"");
		sb.append(",\"code\":");
		sb.append("\""+this.code+"\"");
		sb.append(",\"children\":");
		if(children != null && children.size() > 0){
			sb.append(children.toString());
		}else{
			sb.append("[]");
		}
		sb.append("}");
		return sb.toString();
	}
	
}
