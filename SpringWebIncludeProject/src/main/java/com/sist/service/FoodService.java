package com.sist.service;

import java.util.*;


import com.sist.vo.*;


public interface FoodService {
	public List<FoodVO> foodListData(Map map);
	public int foodRowCount();
	public FoodVO foodCookieInfoData(int fno);
	public FoodVO foodDetailData(int fno);
}
