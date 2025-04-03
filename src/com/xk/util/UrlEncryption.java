
package com.xk.util;

import java.util.List;

import com.xk.Encryption.EncryptionDES;
import com.xk.controller.BaseController;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

@SuppressWarnings("all")
public class UrlEncryption implements TemplateMethodModel{

	public Object exec(List arg0) throws TemplateModelException {
		String encryptionData = "";
		try {
			String user_name = BaseController.getUserCode();
			String data = arg0.get(0).toString();
			String key = (String) MemCached.getInstance().get("encryKey_"+user_name);
			encryptionData = new EncryptionDES(key).encrypt(data);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return encryptionData;
	}
	
}
 
	