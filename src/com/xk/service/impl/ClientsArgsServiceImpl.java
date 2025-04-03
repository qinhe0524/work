
package com.xk.service.impl;

import com.xk.entity.ClientsArgs;
import com.xk.dao.ClientsArgsDao;
import com.xk.service.ClientsArgsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: ClientsArgsServiceImpl
* @Description: 客户参数
* @author 自动生成
* @date 2020-10-22 下午 04:53:27 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class ClientsArgsServiceImpl extends BaseServiceImpl<ClientsArgs,Integer> implements ClientsArgsService{

	@Autowired
	private ClientsArgsDao clientsArgsDao;

	@Autowired
	public void setBaseDao(ClientsArgsDao cDao) {
		super.setBaseDao(clientsArgsDao);
	}
}

