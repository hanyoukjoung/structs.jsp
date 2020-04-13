package kr.or.ddit.user.qboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.qna.board.service.QNABoardService;
import kr.or.ddit.qna.board.service.QNABoardServiceImpl;
import kr.or.ddit.utiles.RolePageingUtile;
import kr.or.ddit.vo.QBoardVO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class QboardListAction implements Action {
	private static final int blockCount = 10;
	private List<QBoardVO> qboardList;
	private String currentPage;
	private String search_keyword;
	private String search_keycode;
	private String paginationHTML;

	public List<QBoardVO> getQboardList() {
		return qboardList;
	}

	public static int getBlockcount() {
		return blockCount;
	}

	public String getPaginationHTML() {
		return paginationHTML;
	}

	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	public void setSearch_keycode(String search_keycode) {
		this.search_keycode = search_keycode;
	}

	private Map<String, String> parameterMap;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");

		if (currentPage == null) {
			currentPage = "1";
		}

		QNABoardService service = QNABoardServiceImpl.getInstance();

		Map<String, String> params = new HashMap<String, String>();

		params.put("currentPage", currentPage);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);

		String totalCount = service.totalCount(params);

		RolePageingUtile pagination = new RolePageingUtile(
				ServletActionContext.getRequest(),
				Integer.parseInt(totalCount), Integer.parseInt(currentPage),
				blockCount, params);
		String startCount = String.valueOf(pagination.getStartCount());
		String endCount = String.valueOf(pagination.getEndCount());

		params.put("startCount", startCount);
		params.put("endCount", endCount);

		this.paginationHTML = pagination.getPagingHtmls();
		this.qboardList = service.qboardList(params);
		this.parameterMap = params;

		return SUCCESS;
	}

}
