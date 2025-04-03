
package com.xk.service.impl;

import com.xk.entity.CheckPerson;
import com.xk.dao.CheckPersonDao;
import com.xk.service.CheckPersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: CheckPersonServiceImpl
* @Description: 身份验证记录
* @author 自动生成
* @date 2020-11-01 下午 06:18:18 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class CheckPersonServiceImpl extends BaseServiceImpl<CheckPerson,Integer> implements CheckPersonService{

	@Autowired
	private CheckPersonDao checkPersonDao;

	@Autowired
	public void setBaseDao(CheckPersonDao cDao) {
		super.setBaseDao(checkPersonDao);
	}
}

