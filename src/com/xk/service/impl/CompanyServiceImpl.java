
package com.xk.service.impl;

import com.xk.entity.Company;
import com.xk.dao.CompanyDao;
import com.xk.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: CompanyServiceImpl
* @Description: 客户公司信息
* @author 自动生成
* @date 2020-10-18 下午 11:54:13 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company,Integer> implements CompanyService{

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	public void setBaseDao(CompanyDao cDao) {
		super.setBaseDao(companyDao);
	}
}

