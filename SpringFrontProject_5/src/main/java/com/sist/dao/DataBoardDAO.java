package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
	@Autowired
    private DataBoardMapper mapper;
	
	/*
	 * @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			   +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			   +"FROM (SELECT no,subject,name,regdate,hit "
			   +"FROM vue_databoard ORDER BY no DESC)) "
			   +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<DataBoardVO> databoardListDate(@Param("start") int start,@Param("end") int end);
	   
	   @Select("SELECT CEIL(COUNT(*)/10.0) FROM vue_databoard")
	   public int databoardTotalPage();
	 */
	public List<DataBoardVO> databoardListDate(int start,int end)
	{
		return mapper.databoardListDate(start, end);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
}
