package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.jni.FileInfo;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.BoardFileVO;

public class AttachFileMapper {
	public static List<BoardFileVO> mapper(List<File> items, List<String> filesFileName, List<String> filesContentType, String bo_no){
		List<BoardFileVO> fileItemList = new ArrayList<>();
		if(items != null) {
			BoardFileVO fileItemInfo = null;
			
			for(int i=0; i<items.size(); i++){
				fileItemInfo = new BoardFileVO();
				
				fileItemInfo.setBo_no(bo_no);
				
				String fileName = filesFileName.get(i);
				fileItemInfo.setFile_name(fileName);
				
				String extensionName = FilenameUtils.getExtension(fileName);
				
				String genID = UUID.randomUUID().toString().replace("-", "");			
				
				StringBuilder sb = new StringBuilder();
				sb.append(genID);
				sb.append(".");
				sb.append(extensionName);
				
				String saveFileName = sb.toString();
				
				fileItemInfo.setFile_save_name(saveFileName);
				
				fileItemInfo.setFile_cont_type(filesContentType.get(i));
				fileItemInfo.setFile_size(String.valueOf(items.get(i).length()));
				
				fileItemList.add(fileItemInfo);
				
				saveFile(saveFileName, items.get(i));
				
			}
		}
		return fileItemList;
	}
	
	public static void saveFile(String saveFileName, File item){
		File saveFile = new File(GlobalConstant.FILE_PATH + "/" + saveFileName);
		try {
			FileUtils.copyFile(item, saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
