package kr.or.ddit.admin.nboard.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import kr.or.ddit.ntc.board.service.NtcBoardService;
import kr.or.ddit.ntc.board.service.NtcBoardServiceImpl;
import kr.or.ddit.vo.NBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertNotifyAction implements Action, ModelDriven<NBoardVO>{
	private NBoardVO nboardInfo;
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String execute() throws Exception {
		
MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)ServletActionContext.getRequest();
		
		List<File> filesFile = this.nboardInfo.getFiles();
		List<String> filesFileNames = this.nboardInfo.getFilesFileName();
		List<String> filesContentTypes = this.nboardInfo.getFilesContentType();
		
		NtcBoardService service = NtcBoardServiceImpl.getInstance();
		
		service.insertnboard(nboardInfo, filesFile, filesFileNames, filesContentTypes);
		
		message = URLEncoder.encode("게시글 등록이 완료 되었습니다.","UTF-8");
		
		return SUCCESS;
	}

	@Override
	public NBoardVO getModel() {
		this.nboardInfo = new NBoardVO();
		return nboardInfo;
	}

}
