package kr.or.ddit.admin.qboard.controller;

import java.net.URLEncoder;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.vo.QBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertQBoardReplyAction implements Action, ModelDriven<QBoardVO> {
	
	private String bo_no;
	private QBoardVO boardInfo;
	private String message;
	
	@Override
	public String execute() throws Exception {
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		service.insertQBoardReply(boardInfo);
		
		this.message = URLEncoder.encode("게시글이 등록되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	@Override
	public QBoardVO getModel() {
		this.boardInfo = new QBoardVO();
		return this.boardInfo;
	}
	
	public String getMessage(){
		return this.message;
	}
}
