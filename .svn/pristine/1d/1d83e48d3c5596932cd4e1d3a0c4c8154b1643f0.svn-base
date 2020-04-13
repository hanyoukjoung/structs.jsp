package kr.or.ddit.admin.join.controller;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.utiles.CryptoGenerator;

import com.opensymphony.xwork2.Action;

public class LoginFormAction implements Action {
	
	private Map<String, String> publicKeyMap;
	
	@Override
	public String execute() throws Exception {
		
		publicKeyMap = CryptoGenerator.getGeneratePairKey(ServletActionContext.getRequest().getSession());
		
		return SUCCESS;
	}

	public Map<String, String> getPublicKeyMap() {
		return publicKeyMap;
	}
}
