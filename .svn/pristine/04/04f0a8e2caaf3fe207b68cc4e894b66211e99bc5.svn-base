package kr.or.ddit.user.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.MemberVO;

import org.apache.struts2.ServletActionContext;

public class LoginCheckAction {

	private String mem_id;
	private String mem_pass;
	
	private String message;
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		PrivateKey privateKey = (PrivateKey)session.getAttribute("privateKey");
		
		mem_id = CryptoGenerator.decryptRSA(privateKey, mem_id);
		mem_pass = CryptoGenerator.decryptRSA(privateKey, mem_pass);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		params.put("mem_pass", this.mem_pass);
		
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		if(memberInfo == null){
			// type="redirectAction"의 경우 스트럿츠 인코딩 설정 적용
//			this.message = "회원이 아닙니다.";
			// type="redirect"
			try {
				this.message = URLEncoder.encode("회원이 아닙니다.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "loginForm";
		}else{
			session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
			return "success";
		}
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMessage() {
		return message;
	}
}








