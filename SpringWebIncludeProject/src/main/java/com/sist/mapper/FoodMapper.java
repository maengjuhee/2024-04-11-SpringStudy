package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT fno,poster,name,num "
		  +"FROM (SELECT fno,poster,name,rownum as num "
		  +"FROM (SELECT /*+INDEX_ASC(project_food_house fh_fno_pk)*/fno,poster,name "
		  +"FROM project_food_house)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodListData(Map map);
  
  @Select("SELECT COUNT(*) FROM project_food_house")
   public int foodRowCount();
   
   // 상세보기
   @Update("UPDATE project_food_house SET "
		  +"hit=hit+1 "
		  +"WHERE fno=#{fno}")
   public void foodHitIncrement(int fno);
   
   @Select("SELECT * FROM project_food_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   

   // 쿠키 정보 데이터 
   @Select("SELECT fno,name,poster "
		  +"FROM project_food_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodCookieInfoData(int fno);
}
