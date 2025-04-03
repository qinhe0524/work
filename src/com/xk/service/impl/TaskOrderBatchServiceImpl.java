
package com.xk.service.impl;

import com.xk.entity.TaskOrderBatch;
import com.xk.dao.TaskOrderBatchDao;
import com.xk.service.TaskOrderBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: TaskOrderBatchServiceImpl
* @Description: 任务单批次
* @author 自动生成
* @date 2020-10-26 下午 10:44:14 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class TaskOrderBatchServiceImpl extends BaseServiceImpl<TaskOrderBatch,Integer> implements TaskOrderBatchService{

	@Autowired
	private TaskOrderBatchDao taskOrderBatchDao;

	@Autowired
	public void setBaseDao(TaskOrderBatchDao tDao) {
		super.setBaseDao(taskOrderBatchDao);
	}
}

