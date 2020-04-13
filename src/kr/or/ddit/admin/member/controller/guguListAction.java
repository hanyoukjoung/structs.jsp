package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ZiptbVO;
import kr.or.ddit.zipcode.service.IZipcodeService;
import kr.or.ddit.zipcode.service.IZipcodeServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class guguListAction implements Action{
	private List<String> gugunList;
	private String sido;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8"); 
		System.out.println("나와랏 11111111111111111111111111111");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		IZipcodeService service = IZipcodeServiceImpl.getInstance();
		
		this.gugunList = service.gugunList(this.sido);		
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonData;
		try {
			jsonData = mapper.writeValueAsString(gugunList);
			response.getWriter().println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<String> getGugunList() {
		return gugunList;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSido() {
		return sido;
	}


	
}
