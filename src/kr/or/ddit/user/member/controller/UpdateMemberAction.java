package kr.or.ddit.user.member.controller;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateMemberAction implements ModelDriven<MemberVO>{
	private MemberVO memberInfo;
	
	public String execute(){
		IMemberService service = IMemberServiceImpl.getInstance();
		service.updateMember(memberInfo);
		return "success";
		
	}
	
	
	@Override
	public MemberVO getModel() {
		this.memberInfo= new MemberVO();
		return memberInfo;
	}
	

}
