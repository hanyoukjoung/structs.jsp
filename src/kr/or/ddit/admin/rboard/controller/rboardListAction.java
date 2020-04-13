package kr.or.ddit.admin.rboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.ref.board.service.REFBoardService;
import kr.or.ddit.ref.board.service.REFBoardServiceImpl;
import kr.or.ddit.utiles.RolePageingUtile;
import kr.or.ddit.vo.RBoardVO;

import com.opensymphony.xwork2.Action;

public class rboardListAction implements Action{
	private static final int blockCount =10;
	
	private List<RBoardVO> rboardList;
	private String currentPage;
	private String search_keycode;
	private String search_keyword;
	private String paginationHtmls;
	private Map<String, String> parameterMap;
	
	@Override
	public String execute() throws Exception {
		REFBoardService service = REFBoardServiceImpl.getInstance();
		
		this.currentPage = this.currentPage == null ? "1" : this.currentPage;
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("currentPage", currentPage);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		String totalCount = service.totalCount(params);
		
		RolePageingUtile pagination = new RolePageingUtile(
										ServletActionContext.getRequest(),
										Integer.parseInt(totalCount),
										Integer.parseInt(currentPage),
										blockCount,
										params);
		String startCount = String.valueOf(pagination.getStartCount());
		String endCount = String.valueOf(pagination.getEndCount());
		
		params.put("startCount", startCount);
		params.put("endCount", endCount);
		
		this.paginationHtmls = pagination.getPagingHtmls();
		
		this.rboardList = service.rboardList(params);
		
		this.parameterMap = params;
		
		
		return SUCCESS;
		
		
	}
	public List<RBoardVO> getRboardList() {
		return rboardList;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public void setSearch_keycode(String search_keycode) {
		this.search_keycode = search_keycode;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	public String getPaginationHtmls() {
		return paginationHtmls;
	}
	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

}
