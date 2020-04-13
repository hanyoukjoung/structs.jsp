package kr.or.ddit.image.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.image.board.service.IIMGBoardService;
import kr.or.ddit.image.board.service.IIMGBoardServiceImpl;
import kr.or.ddit.utiles.RolePageingUtile;
import kr.or.ddit.vo.IBoardVO;

import com.opensymphony.xwork2.Action;

public class ImageBoardListAction implements Action{
	private static final int blockCount = 10;
	private List<IBoardVO> iboardList;
	private String currentPage;
	private String search_keyword;
	private String search_keycode;
	private String paginationHTML;
	private Map<String, String> parameterMap;
	
	public static int getBlockcount() {
		return blockCount;
	}

	public List<IBoardVO> getIboardList() {
		return iboardList;
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

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		IIMGBoardService service = IIMGBoardServiceImpl.getInstance();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("currentPage", currentPage);
		params.put("search_keycode", request.getParameter("search_keycode"));
		params.put("search_keyword", request.getParameter("search_keyword"));
		
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
	      
	      this.paginationHTML = pagination.getPagingHtmls();
	      this.iboardList = service.boardList(params);
	      this.parameterMap = params;
	      
		return SUCCESS;
	}

}
