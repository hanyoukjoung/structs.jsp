package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SUCCESSFUL;

import kr.or.ddit.file.freeboard.service.IFreeBoardFileService;
import kr.or.ddit.file.freeboard.service.IFreeBoardFileServiceImpl;
import kr.or.ddit.utiles.FileDownloadView;
import kr.or.ddit.vo.BoardFileVO;

import com.opensymphony.xwork2.Action;

public class DownloadFileAction implements Action {
	
	private String bo_no;
	private String file_no;
	
	@Override
	public String execute() throws Exception {
		
		IFreeBoardFileService service = IFreeBoardFileServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("file_no", file_no);
		
		BoardFileVO fileInfo = service.fboardfileitemInfo(params);
		
		FileDownloadView.fileDownload(fileInfo, ServletActionContext.getResponse());
		
		return null;
	}
	
	public String getBo_no() {
		return bo_no;
	}


	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}


	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
}
