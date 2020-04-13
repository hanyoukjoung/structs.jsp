package kr.or.ddit.admin.nboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.file.nboard.service.nBoardFileService;
import kr.or.ddit.file.nboard.service.nBoardFileServiceImpl;
import kr.or.ddit.utiles.FileDownloadView;
import kr.or.ddit.vo.BoardFileVO;

import com.opensymphony.xwork2.Action;

public class NotifyDownloadAction implements Action {
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
		params.put("fileSEQ", this.fileSEQ);
		nBoardFileService service = nBoardFileServiceImpl.getInstance();
		this.fileItemInfo = service.nboardfileitemInfo(params);
		
		FileDownloadView.fileDownload(fileItemInfo, ServletActionContext.getResponse());
		
		return null;
	}
	
}
