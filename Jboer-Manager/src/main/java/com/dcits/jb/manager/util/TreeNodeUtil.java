package com.dcits.jb.manager.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNodeUtil {
	private List<TreeNodeBean> treeNodeBeanAllList;
	
	private Map<String,TreeNodeBean> treeNodeBeanAllMap;
	
	private List<TreeNodeBean> treeNodeBeanResultList;
	
	public List<TreeNodeBean> getTreeNodeBeanAllList() {
		return treeNodeBeanAllList;
	}

	public void setTreeNodeBeanAllList(List<TreeNodeBean> treeNodeBeanAllList) {
		this.treeNodeBeanAllList = treeNodeBeanAllList;
	}
	
	public TreeNodeUtil(){
		treeNodeBeanAllMap = new HashMap<String,TreeNodeBean>();
		treeNodeBeanResultList = new ArrayList<TreeNodeBean>();
	}
	
	public List<TreeNodeBean> exeCreateTreeNode(){
		while(treeNodeBeanAllList.size() > 0){
			//System.out.println(treeNodeBeanAllList.size());
			TreeNodeBean tnb = treeNodeBeanAllList.get(0);
			this.getChildrenList(tnb);
			
			treeNodeBeanAllMap.put(tnb.getId(), tnb);
			this.clearTreeNodeAllListByMap();
		}
		
		this.getTreeMapToTreeList();
		return this.treeNodeBeanResultList;
	}
	
	
	public void getChildrenList(TreeNodeBean tnb){//获取某一节点下所有子节点
		//System.out.println(tnb.getId());
		List<TreeNodeBean> treeNodeBeanChildList = new ArrayList<TreeNodeBean>();
		boolean flag = false;
		for(int i = 0;i < treeNodeBeanAllList.size();i++){
			TreeNodeBean tnbC = treeNodeBeanAllList.get(i);
			if(tnbC.getParentId().equals(tnb.getId())){
				flag = true;
				break;
			}
		}
		if(flag){
			for(int i = 0;i < treeNodeBeanAllList.size();i++){
				TreeNodeBean tnbC = treeNodeBeanAllList.get(i);
				if(tnbC.getParentId().equals(tnb.getId())){
					TreeNodeBean tnbCA = treeNodeBeanAllMap.get(tnbC.getId());
					if(tnbCA != null){
						treeNodeBeanChildList.add(tnbCA);
						treeNodeBeanAllMap.remove(tnbC.getId());
					}else{
						treeNodeBeanChildList.add(tnbC);
						this.getChildrenList(tnbC);
					}
				}
			}
			if(treeNodeBeanChildList.size() > 0){
				Collections.sort(treeNodeBeanChildList);
				tnb.setChildren(treeNodeBeanChildList);
			}
		}
	}
	
	public void clearTreeNodeAllListByMap(){
		for(TreeNodeBean tnb:treeNodeBeanAllMap.values()){
			this.clearTreeNodeAllListByTNB(tnb);
		}
	}
	
	public void clearTreeNodeAllListByTNB(TreeNodeBean tnb){
		if(tnb.getChildren() != null && tnb.getChildren().size() >0){
			List<TreeNodeBean> treeNodeBeanList = tnb.getChildren();
			for(int i = 0;i < treeNodeBeanList.size();i++){
				TreeNodeBean tnbC = treeNodeBeanList.get(i);
				this.clearTreeNodeAllListByTNB(tnbC);
			}
		}
		for(int i = 0;i < treeNodeBeanAllList.size();i++){
			TreeNodeBean tnbC = treeNodeBeanAllList.get(i);
			if(tnbC.getId().equals(tnb.getId())){
				treeNodeBeanAllList.remove(i);
				break;
			}
		}
	}
	
	public void getTreeMapToTreeList(){
		for(TreeNodeBean tnb:treeNodeBeanAllMap.values()){
			treeNodeBeanResultList.add(tnb);
		}
		Collections.sort(treeNodeBeanResultList);
	}
	
	
	public static void main(String[] arg){
//		List<TreeNodeBean> treeNodeBeanList = new ArrayList<TreeNodeBean>(); 
//		for(int i = 1;i < 1001;i++){
//			String parentId = "0";
//			if(i > 10){
//				parentId = ""+(i/10);
//			}
//			TreeNodeBean tnb = new TreeNodeBean(i+"","text"+i,parentId,i+"");
//			treeNodeBeanList.add(tnb);
//		}
//		TreeNodeUtil tnu = new TreeNodeUtil();
//		tnu.setTreeNodeBeanAllList(treeNodeBeanList);
//		List<TreeNodeBean> list = tnu.exeCreateTreeNode();
//		System.out.println(list);
//		double d = 1.8601020302E10;
//		BigDecimal bigDecimal = new BigDecimal(d);
//		System.out.println(bigDecimal.toString());
	}
	
}
