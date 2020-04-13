package kr.or.ddit.user.rboard.controller;

import java.net.URL;
import java.net.URLEncoder;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;

import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class insertRBoardReplyAction implements Action, ModelDriven<RBoardVO>{
	private RBoardVO rboardInfo;
	private String message;
	

	@Override
	public String execute() throws Exception {
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		service.insertRBoardInfoReply(rboardInfo);
		
		this.message= URLEncoder.encode("댓글이 작성되었습니다.", "UTF-8");
		
		
		return SUCCESS;
	}

	@Override
	public RBoardVO getModel() {
		this.rboardInfo = new RBoardVO();
		return this.rboardInfo;
	}
	
	public RBoardVO getRboardInfo() {
		return rboardInfo;
	}

	public String getMessage() {
		return message;
	}

}
