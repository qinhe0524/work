
package com.xk.service.impl;

import com.xk.entity.Agent;
import com.xk.dao.AgentDao;
import com.xk.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: AgentServiceImpl
* @Description: 代理表
* @author 自动生成
* @date 2020-10-08 下午 11:49:02 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class AgentServiceImpl extends BaseServiceImpl<Agent,Integer> implements AgentService{

	@Autowired
	private AgentDao agentDao;

	@Autowired
	public void setBaseDao(AgentDao aDao) {
		super.setBaseDao(agentDao);
	}
}

