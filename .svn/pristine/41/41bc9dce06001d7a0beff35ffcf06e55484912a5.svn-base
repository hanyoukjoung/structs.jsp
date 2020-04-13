package kr.or.ddit.image.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;
import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.FBoardVO;
import kr.or.ddit.vo.IBoardVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertImageAction implements Action,ModelDriven<IBoardVO>{
	private IBoardVO iboardInfo;
	private String message;
	
	@Override
	public String execute() throws Exception {
		
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)ServletActionContext.getRequest();
		
		List<File> filesFile = this.iboardInfo.getFiles();
		List<String> filesFileNames = this.iboardInfo.getFilesFileName();
		List<String> filesContentTypes = this.iboardInfo.getFilesContentType();
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		service.insertBoard(iboardInfo, filesFile, filesFileNames, filesContentTypes);
		
		message = URLEncoder.encode("게시글 등록이 완료되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	@Override
	public IBoardVO getModel() {
		this.iboardInfo = new IBoardVO();
		return this.iboardInfo;
	}

	public String getMessage() {
		return message;
	}

}
