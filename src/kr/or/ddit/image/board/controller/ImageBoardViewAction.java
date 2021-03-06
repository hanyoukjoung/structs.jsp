package kr.or.ddit.image.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;
import kr.or.ddit.vo.IBoardVO;

import com.opensymphony.xwork2.Action;

public class ImageBoardViewAction implements Action{

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Map<String, String> params = new HashMap<>();
		params.put("bo_no", request.getParameter("bo_no"));
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		IBoardVO boardInfo = service.boardInfo(params);
		
		request.setAttribute("boardInfo", boardInfo);
		return SUCCESS;
	}

}
