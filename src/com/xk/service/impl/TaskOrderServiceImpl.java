
package com.xk.service.impl;

import com.xk.entity.TaskOrder;
import com.xk.dao.TaskOrderDao;
import com.xk.service.TaskOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: TaskOrderServiceImpl
* @Description: 任务接单
* @author 自动生成
* @date 2020-10-26 下午 10:44:39 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class TaskOrderServiceImpl extends BaseServiceImpl<TaskOrder,Integer> implements TaskOrderService{

	@Autowired
	private TaskOrderDao taskOrderDao;

	@Autowired
	public void setBaseDao(TaskOrderDao tDao) {
		super.setBaseDao(taskOrderDao);
	}
}

