package kr.or.ddit.admin.iboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.file.iboard.service.IIMGBoardFileService;
import kr.or.ddit.file.iboard.service.IIMGBoardFileServiceImpl;
import kr.or.ddit.utiles.FileDownloadView;
import kr.or.ddit.vo.BoardFileVO;

import com.opensymphony.xwork2.Action;

public class DownloadFileAction implements Action {
	private String fileSEQ ;
	private BoardFileVO fileItemInfo;
	
	public void setFileSEQ(String fileSEQ) {
		this.fileSEQ = fileSEQ;
	}

	public void setFileItemInfo(BoardFileVO fileItemInfo) {
		this.fileItemInfo = fileItemInfo;
	}

	@Override
	public String execute() throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("file_no", this.fileSEQ);
		
		IIMGBoardFileService service = IIMGBoardFileServiceImpl.getInstance();
		this.fileItemInfo = service.iboardFileInfo(params);
		
		FileDownloadView.fileDownload(fileItemInfo, ServletActionContext.getResponse());
		
		return null;
	}
	
}
