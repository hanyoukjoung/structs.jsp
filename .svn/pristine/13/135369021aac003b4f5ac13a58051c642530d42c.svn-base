package kr.or.ddit.user.freeboard.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;
import kr.or.ddit.vo.FBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertFreeboardReplyAction implements Action, ModelDriven<FBoardVO> {
	
	private FBoardVO boardInfo;
	private String message;
	
	@Override
	public String execute() throws Exception {
		
		IFreeBoardService service = IFreeBoardServiceImpl.getInstance();
		
		service.insertFboardReply(boardInfo);
		
		this.message = URLEncoder.encode("댓글이 작성되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	@Override
	public FBoardVO getModel() {
		this.boardInfo = new FBoardVO();
		return this.boardInfo;
	}

	public FBoardVO getBoardInfo() {
		return boardInfo;
	}
	
	public String getMessage() {
		return message;
	}
}
