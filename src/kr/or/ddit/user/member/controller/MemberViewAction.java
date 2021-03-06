package kr.or.ddit.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.file.member.service.IMemberFileService;
import kr.or.ddit.file.member.service.IMemberFileServiceImpl;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;

public class MemberViewAction implements Action{
	private String mem_id;
	private MemberVO memberInfo;
	 private BoardFileVO fileInfo;

	@Override
	public String execute() throws Exception {
		Map<String, String> params= new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		IMemberFileService servicefile = IMemberFileServiceImpl.getInstance();
		this.memberInfo = service.memberInfo(params);
		this.fileInfo = servicefile.memberFileInfo(params);	
		return SUCCESS;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public MemberVO getMemberInfo() {
		return memberInfo;
	}
	public BoardFileVO getFileInfo() {
		return fileInfo;
	}

	

}
