
package com.xk.service.impl;

import com.xk.entity.FreeWorker;
import com.xk.dao.FreeWorkerDao;
import com.xk.service.FreeWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: FreeWorkerServiceImpl
* @Description: 自由职业者
* @author 自动生成
* @date 2020-10-15 下午 02:51:38 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class FreeWorkerServiceImpl extends BaseServiceImpl<FreeWorker,Integer> implements FreeWorkerService{

	@Autowired
	private FreeWorkerDao freeWorkerDao;

	@Autowired
	public void setBaseDao(FreeWorkerDao fDao) {
		super.setBaseDao(freeWorkerDao);
	}
}

