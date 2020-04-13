package kr.or.ddit.user.member.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertMemberAction implements ModelDriven<MemberVO>{
	private MemberVO memberInfo;
	private String message;

	public String execute() throws Exception{
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)ServletActionContext.getRequest();
		
		List<File> filesFile = this.memberInfo.getFiles();
		List<String> filesFileNames = this.memberInfo.getFilesFileName();
		List<String> filesContentTypes = this.memberInfo.getFilesContentType();
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.insertMember(memberInfo, filesFile, filesFileNames, filesContentTypes);
		
		this.message = URLEncoder.encode("회원가입이 완료되었습니다.", "UTF-8");
		return "success";
		
	}
	
	@Override
	public MemberVO getModel() {
		this.memberInfo=new MemberVO();
		return memberInfo;
	}
	
	public String getMessage() {
		return message;
	}
	
}
