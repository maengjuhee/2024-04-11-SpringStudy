package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
	private FoodDAO dao;
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return dao.foodListData(map);
	}

	@Override
	public int foodRowCount() {
		// TODO Auto-generated method stub
		return dao.foodRowCount();
	}

	@Override
	public FoodVO foodCookieInfoData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodCookieInfoData(fno);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}

}
