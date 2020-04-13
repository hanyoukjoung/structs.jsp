package kr.or.ddit.notify.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.ntc.board.service.NtcBoardService;
import kr.or.ddit.ntc.board.service.NtcBoardServiceImpl;
import kr.or.ddit.utiles.RolePageingUtile;
import kr.or.ddit.vo.NBoardVO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class NotifyListAction implements Action {
	private static final int blockCount = 10;
	private List<NBoardVO> nboardList;
	private String currentPage;
	private String search_keyword;
	private String search_keycode;
	private String paginationHTML;
	private Map<String, String> parameterMap;
	
	public static int getBlockcount() {
		return blockCount;
	}

	public List<NBoardVO> getNboardList() {
		return nboardList;
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
	public String execute() throws UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		
		if (currentPage == null) {
			currentPage = "1";
		}
		NtcBoardService service = NtcBoardServiceImpl.getInstance();
		
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
	      
	      this.paginationHTML = pagination.getPagingHtmls();
	      
	      this.nboardList = service.nboardList(params);

	      this.parameterMap = params;
	      
	      return SUCCESS;
	}
}
