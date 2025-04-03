
package com.xk.service.impl;

import com.xk.entity.Clients;
import com.xk.dao.ClientsDao;
import com.xk.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: ClientsServiceImpl
* @Description: 客户主表
* @author 自动生成
* @date 2020-10-20 上午 01:04:05 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class ClientsServiceImpl extends BaseServiceImpl<Clients,Integer> implements ClientsService{

	@Autowired
	private ClientsDao clientsDao;

	@Autowired
	public void setBaseDao(ClientsDao cDao) {
		super.setBaseDao(clientsDao);
	}
}

