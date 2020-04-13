package kr.or.ddit.admin.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.admin.admin.service.IAdminService;
import kr.or.ddit.admin.admin.service.IAdminServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.AdminVO;

import org.apache.struts2.ServletActionContext;

public class loginCheckAction {
	
	private String admin_id;
	private String admin_pass;
	
	private String message;
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		
		PrivateKey privateKey = (PrivateKey)session.getAttribute("privateKey");
		
		admin_id = CryptoGenerator.decryptRSA(privateKey, admin_id);
		admin_pass = CryptoGenerator.decryptRSA(privateKey, admin_pass);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("admin_id", this.admin_id);
		params.put("admin_pass",this.admin_pass );
		
		IAdminService service = IAdminServiceImpl.getInstance();
		AdminVO adminInfo = service.adminInfo(params);
		
		if(adminInfo==null){
			try {
				this.message = URLEncoder.encode("관리자가 아닙니다.", "UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "loginForm";
			
		}else{
			
			try {
				this.message = URLEncoder.encode(adminInfo.getAdmin_name() + "님 환영합니다.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			session.setAttribute("LOGIN_ADMININFO", adminInfo);
			return "success";
		}
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getMessage() {
		return message;
	}
}
