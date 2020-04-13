package kr.or.ddit.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.utiles.JSONDataConvertView;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;

public class idCheckAction{
	private String mem_id;

	public void execute() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		ObjectMapper mapper = new ObjectMapper();
		String memberInfoJsonData = mapper.writeValueAsString(mem_id);
		
		Map<String,String> jsonMap = new HashMap<String,String>();
		if(memberInfo==null){
			jsonMap.put("flag", "true");
		}else{
			jsonMap.put("flag","false");
		}
		
		new JSONDataConvertView().object2JSONConvert(jsonMap, ServletActionContext.getResponse());
		
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	

}
