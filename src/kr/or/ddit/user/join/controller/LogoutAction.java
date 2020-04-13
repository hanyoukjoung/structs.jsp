package kr.or.ddit.user.join.controller;

import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action {
	private String message;
	



	@Override
	public String execute() throws Exception {
		
		ServletActionContext.getRequest().getSession().invalidate();
		//ServletActionContext.getRequest().getSession().removeAttribute("LOGIN_MEMBERINFO");
		
		this.message =URLEncoder.encode("로그아웃되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}
}
