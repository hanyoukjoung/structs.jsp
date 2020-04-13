package kr.or.ddit.user.qboard.controller;

import java.net.URLEncoder;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.vo.QBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateQboardAction implements Action, ModelDriven<QBoardVO>{

	private QBoardVO qboardInfo = new QBoardVO();
	private String message;

	@Override
	public String execute() throws Exception {
		
		QNABoardService service = QNABoardServiceImpl.getInstance();
		
		service.updateQBoardInfo(qboardInfo);
		
		this.message = URLEncoder.encode("게시글 수정이 완료되었습니다.");
		
		return SUCCESS;
	}

	public QBoardVO getQboardInfo() {
		return qboardInfo;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public QBoardVO getModel() {
		this.qboardInfo = new QBoardVO();
		return this.qboardInfo;
	}
}
