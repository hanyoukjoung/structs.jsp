package kr.or.ddit.free.board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FBoardVO;

import org.apache.commons.fileupload.FileItem;

public interface IFreeBoardService {
	public List<FBoardVO> freeboardList(Map<String, String> params);
	public FBoardVO freeboardInfo(Map<String, String> params);
	public int updatefreeboard(FBoardVO freeboardInfo);
	public void deletefreeboard(Map<String, String> params);
	public void insertFreeboard(FBoardVO freeboardInfo, List<File> files, List<String> fileNames, List<String> fileContentType);
	public void insertFboardReply(FBoardVO freeboardInfo);
	public String totalCount(Map<String, String> params);
}
