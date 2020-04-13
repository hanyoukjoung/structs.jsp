package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.zipcode.service.IZipcodeService;
import kr.or.ddit.zipcode.service.IZipcodeServiceImpl;

import com.opensymphony.xwork2.Action;

public class MemberListAction implements Action{
	private List<String> sidoList;
	private List<MemberVO> memberList;
	private String search_base_keycode;
	private String search_base_keyword;
	private String search_sido;
	private String search_gugun;
	private String mem_hp1;
	private String mem_hp2;
	private String mem_hp3;
	private String mem_bir;
	

	

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		IZipcodeService zipcodeService = IZipcodeServiceImpl.getInstance();
		IMemberService memberService = IMemberServiceImpl.getInstance();
		
		 this.sidoList = zipcodeService.sidoList();
		
		
		Map<String, String> params = new HashMap<>();
		
		params.put("search_base_keycode", request.getParameter("search_base_keycode"));
		params.put("search_base_keyword", request.getParameter("search_base_keyword"));
		params.put("search_sido", request.getParameter("search_sido"));
		params.put("search_gugun", request.getParameter("search_gugun"));
		params.put("mem_hp1", request.getParameter("mem_hp1"));
		params.put("mem_hp2", request.getParameter("mem_hp2"));
		params.put("mem_hp3", request.getParameter("mem_hp3"));
		params.put("mem_bir", request.getParameter("mem_bir"));
		
		this.memberList = memberService.memberListForAdmin(params);
		return SUCCESS;
	}
	
	public List<String> getSidoList() {
		return sidoList;
	}


	public void setSidoList(List<String> sidoList) {
		this.sidoList = sidoList;
	}

	public List<MemberVO> getMemberList() {
		return memberList;
	}


	public void setSearch_base_keycode(String search_base_keycode) {
		this.search_base_keycode = search_base_keycode;
	}


	public void setSearch_base_keyword(String search_base_keyword) {
		this.search_base_keyword = search_base_keyword;
	}


	public void setSearch_sido(String search_sido) {
		this.search_sido = search_sido;
	}


	public void setSearch_gugun(String search_gugun) {
		this.search_gugun = search_gugun;
	}


	public void setMem_hp1(String mem_hp1) {
		this.mem_hp1 = mem_hp1;
	}


	public void setMem_hp2(String mem_hp2) {
		this.mem_hp2 = mem_hp2;
	}


	public void setMem_hp3(String mem_hp3) {
		this.mem_hp3 = mem_hp3;
	}


	public void setMem_bir(String mem_bir) {
		this.mem_bir = mem_bir;
	}

	public String getSearch_sido() {
		return search_sido;
	}

	public String getSearch_gugun() {
		return search_gugun;
	}


}
