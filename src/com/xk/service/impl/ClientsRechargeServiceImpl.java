
package com.xk.service.impl;

import com.xk.entity.ClientsRecharge;
import com.xk.dao.ClientsRechargeDao;
import com.xk.service.ClientsRechargeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: ClientsRechargeServiceImpl
* @Description: 客户充值记录
* @author 自动生成
* @date 2020-10-23 上午 01:00:52 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class ClientsRechargeServiceImpl extends BaseServiceImpl<ClientsRecharge,Integer> implements ClientsRechargeService{

	@Autowired
	private ClientsRechargeDao clientsRechargeDao;

	@Autowired
	public void setBaseDao(ClientsRechargeDao cDao) {
		super.setBaseDao(clientsRechargeDao);
	}
}

