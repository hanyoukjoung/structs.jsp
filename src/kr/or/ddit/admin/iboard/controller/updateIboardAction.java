package kr.or.ddit.admin.iboard.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.IBoardVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class updateIboardAction implements Action, ModelDriven<IBoardVO>{
	
	private IBoardVO iboardInfo;
	private String message; 
	public String getMessage() {
		return message;
	}

	@Override
	public String execute() throws Exception {
		
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
		
		List<File> filesFile = this.iboardInfo.getFiles();
		List<String> filesFileNames = this.iboardInfo.getFilesFileName();
		List<String> filesContentTypes = this.iboardInfo.getFilesContentType();
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		if(service.updateBoard(iboardInfo,filesFile, filesFileNames, filesContentTypes) > 0){
			this.message = URLEncoder.encode("게시글이 수정되었습니다.", "UTF-8");
		} else {
			this.message = URLEncoder.encode("게시글 수정에 실패하였습니다. 관리자에게 문의 바랍니다.", "UTF-8");
		}
		
		return SUCCESS;
	}

	@Override
	public IBoardVO getModel() {
		this.iboardInfo = new IBoardVO();
		return iboardInfo;
	}

	public IBoardVO getIboardInfo() {
		return iboardInfo;
	}

}
