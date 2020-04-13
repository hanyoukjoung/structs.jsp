package kr.or.ddit.user.rboard.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;
import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertrboardAction implements Action, ModelDriven<RBoardVO>{
	private RBoardVO rboardInfo;
	private String message;

	@Override
	public String execute() throws Exception {
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)ServletActionContext.getRequest();
		
		List<File> filesFile = this.rboardInfo.getFiles();
		List<String> filesFileNames = this.rboardInfo.getFilesFileName();
		List<String> filesContentTypes = this.rboardInfo.getFilesContentType();
		
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		service.insertBoardInfo(rboardInfo, filesFile, filesFileNames, filesContentTypes);
		
		message = URLEncoder.encode("게시글 등록이 완료되었습니다.", "UTF-8");
		
		return SUCCESS;
	}
	
	@Override
	public RBoardVO getModel() {
		this.rboardInfo = new RBoardVO();
		return this.rboardInfo;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	
}
