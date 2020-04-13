package kr.or.ddit.user.member.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;





import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;

public class DeleteMemberAction implements Action{
	private String mem_id;
	private String message;
	
	

	@Override
	public String execute() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		IMemberService service = IMemberServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", ((MemberVO)request.getSession().getAttribute("LOGIN_MEMBERINFO")).getMem_id());
		
		if(service.deleteMember(params) > 0){
			request.getSession().removeAttribute("LOGIN_MEMBERINFO");
			return "deleteMember";
		} else {
			return "success";
		}
	}




	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}




	public String getMessage() {
		return message;
	}


	

}
