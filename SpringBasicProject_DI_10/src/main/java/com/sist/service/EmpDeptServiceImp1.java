package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DeptDAO;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Service("eds") // 클래스가 길어지면 이름을 부여해줘
public class EmpDeptServiceImp1 implements EmpDeptService{
	@Autowired
    private EmpDAO edao;
	
    @Autowired
    private DeptDAO ddao;
	@Override
	public List<EmpVO> empListData() {
		// TODO Auto-generated method stub
		return edao.empListData();
	}

	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return ddao.deptListData();
	}

}
