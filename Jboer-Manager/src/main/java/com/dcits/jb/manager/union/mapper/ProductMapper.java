package com.dcits.jb.manager.union.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
	
	public int getCountProListByConQuery(@Param("proname") String proname,@Param("protype") String protype,@Param("isself") String isself,@Param("resouce") String resouce,@Param("issale") String issale);
	
	public List<HashMap<String,Object>> getProListByConQuery(@Param("proname") String proname,@Param("protype") String protype,@Param("isself") String isself,@Param("resouce") String resouce,@Param("issale") String issale,@Param("rows") int rows, @Param("page") int page);

}
