package kr.or.ddit.user.iboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.file.iboard.service.IIMGBoardFileService;
import kr.or.ddit.file.iboard.service.IIMGBoardFileServiceImpl;
import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.IBoardVO;

import com.opensymphony.xwork2.Action;

public class ImageBoardViewAction implements Action{

	private String bo_no;
	private BoardFileVO fileitem;
	private IBoardVO boardInfo;
	
	@Override
	public String execute() throws Exception {
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		this.boardInfo = service.boardInfo(params);
		
		IIMGBoardFileService fileService = IIMGBoardFileServiceImpl.getInstance();
		
		this.fileitem = fileService.iboardFileInfoForThumb(params);
		
		return SUCCESS;
		
	}

	public BoardFileVO getFileitem() {
		return fileitem;
	}

	public IBoardVO getBoardInfo() {
		return boardInfo;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

}
