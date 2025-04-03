
package com.xk.service.impl;

import com.xk.entity.AgentAgent;
import com.xk.dao.AgentAgentDao;
import com.xk.service.AgentAgentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: AgentAgentServiceImpl
* @Description: 代理关系表
* @author 自动生成
* @date 2020-12-16 下午 01:48:41 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class AgentAgentServiceImpl extends BaseServiceImpl<AgentAgent,Integer> implements AgentAgentService{

	@Autowired
	private AgentAgentDao agentAgentDao;

	@Autowired
	public void setBaseDao(AgentAgentDao aDao) {
		super.setBaseDao(agentAgentDao);
	}
}

