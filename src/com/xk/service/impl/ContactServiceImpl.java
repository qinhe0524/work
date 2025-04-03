
package com.xk.service.impl;

import com.xk.entity.Contact;
import com.xk.dao.ContactDao;
import com.xk.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ********************************************************
* @ClassName: ContactServiceImpl
* @Description: 联系人
* @author 自动生成
* @date 2020-10-18 下午 09:43:39 
*******************************************************
*/
@SuppressWarnings("all")
@Service
public class ContactServiceImpl extends BaseServiceImpl<Contact,Integer> implements ContactService{

	@Autowired
	private ContactDao contactDao;

	@Autowired
	public void setBaseDao(ContactDao cDao) {
		super.setBaseDao(contactDao);
	}
}

