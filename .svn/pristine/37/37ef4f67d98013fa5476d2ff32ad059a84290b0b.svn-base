package kr.or.ddit.image.board.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.IBoardVO;


public interface IIMGBoardService {
	public String totalCount(Map<String, String> params);

	public List<IBoardVO> boardList(Map<String, String> params);

	public IBoardVO boardInfo(Map<String, String> params);

	public void insertBoard(IBoardVO boardInfo, List<File> files, List<String> fileNames, List<String> fileContentType);

	public int updateBoard(IBoardVO boardInfo, List<File> files, List<String> fileNames, List<String> fileContentType);

	public void deleteBoard(Map<String, String> params);

	public int updateBoardForAdmin(IBoardVO boardInfo);
}
