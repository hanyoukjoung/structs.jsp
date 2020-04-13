package kr.or.ddit.user.freeboard.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.codehaus.jackson.map.ser.std.StdJdkSerializers.FileSerializer;

import kr.or.ddit.free.board.service.IFreeBoardService;
import kr.or.ddit.free.board.service.IFreeBoardServiceImpl;
import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.utiles.AttachFileMapper;
import kr.or.ddit.vo.BoardFileVO;
import kr.or.ddit.vo.FBoardVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class InsertFreeboardAction implements Action, ModelDriven<FBoardVO> {
	private FBoardVO boardInfo;
	private String message;
	
	@Override
	public String execute() throws Exception {
		
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)ServletActionContext.getRequest();
		
		List<File> filesFile = this.boardInfo.getFiles();
		List<String> filesFileNames = this.boardInfo.getFilesFileName();
		List<String> filesContentTypes = this.boardInfo.getFilesContentType();
		
		IFreeBoardService service = IFreeBoardServiceImpl.getInstance();
		
		service.insertFreeboard(boardInfo, filesFile, filesFileNames, filesContentTypes);
		
		message = URLEncoder.encode("게시글 등록이 완료되었습니다.", "UTF-8");
		
		return SUCCESS;
	}

	@Override
	public FBoardVO getModel() {
		this.boardInfo = new FBoardVO();
		return this.boardInfo;
	}

	public String getMessage() {
		return message;
	}
}
