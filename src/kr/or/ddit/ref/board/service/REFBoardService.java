package kr.or.ddit.ref.board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.RBoardVO;

public interface REFBoardService {
	public List<RBoardVO> rboardList(Map<String, String> params);
	public RBoardVO rboardInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	public void insertBoardInfo(RBoardVO boardInfo, List<File> files, List<String> fileNames, List<String> fileContentType);
	public void insertRBoardInfoReply(RBoardVO rboardInfo);
	public void updateRBoardInfo(RBoardVO rboardInfo);
	public void deleteRBoardInfo(Map<String, String> params);
}
