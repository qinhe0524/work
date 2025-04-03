
package com.xk.service.impl;

import com.xk.entity.ClientsAccount;
import com.xk.dao.ClientsAccountDao;
import com.xk.service.ClientsAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: ClientsAccountServiceImpl
* @Description: 客户账户
* @author 自动生成
* @date 2020-10-22 下午 11:28:07 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class ClientsAccountServiceImpl extends BaseServiceImpl<ClientsAccount,Integer> implements ClientsAccountService{

	@Autowired
	private ClientsAccountDao clientsAccountDao;

	@Autowired
	public void setBaseDao(ClientsAccountDao cDao) {
		super.setBaseDao(clientsAccountDao);
	}
}

