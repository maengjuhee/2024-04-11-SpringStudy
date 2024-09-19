package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
    @Autowired
    private FoodMapper mapper;
    
  
    public List<FoodVO> foodListData(Map map)
    {
    	return mapper.foodListData(map);
    }
    public int foodRowCount()
    {
    	return mapper.foodRowCount();
    }

    public FoodVO foodDetailData(int fno)
    {
    	return mapper.foodDetailData(fno);
    }
    public FoodVO foodCookieInfoData(int fno)
    {
    	return mapper.foodCookieInfoData(fno);
    }
}