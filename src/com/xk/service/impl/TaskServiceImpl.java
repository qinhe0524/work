
package com.xk.service.impl;

import com.xk.entity.Task;
import com.xk.dao.TaskDao;
import com.xk.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: TaskServiceImpl
* @Description: 任务
* @author 自动生成
* @date 2020-10-25 上午 12:00:35 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task,Integer> implements TaskService{

	@Autowired
	private TaskDao taskDao;

	@Autowired
	public void setBaseDao(TaskDao tDao) {
		super.setBaseDao(taskDao);
	}
}

