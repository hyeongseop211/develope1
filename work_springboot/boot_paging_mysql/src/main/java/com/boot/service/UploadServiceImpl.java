package com.boot.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.BoardAttachDAO;
import com.boot.dto.BoardAttachDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("UploadService")
public class UploadServiceImpl implements UploadService{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardAttachDTO> getFileList(int boardNo) {
		log.info("@# UploadServiceImpl boardNo=>"+boardNo);
		
		BoardAttachDAO dao=sqlSession.getMapper(BoardAttachDAO.class);
		
		return dao.getFileList(boardNo);
	}

	@Override
	public void deleteFile(List<BoardAttachDTO> FileList) {
		log.info("@# UploadServiceImpl deleteFile");
	
		if(FileList==null || FileList.size()==0) {
			return;
		}

		FileList.forEach(attach -> {
			try {
				Path file = Paths.get("C:\\develop\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()
				+"_"+attach.getFileName());

				Files.deleteIfExists(file);

				// 썸네일 삭제(이미지인 경우)
				if (Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\develop\\upload\\"+attach.getUploadPath()+"\\s_"
					+attach.getUuid()
					+"_"+attach.getFileName());
					Files.delete(thumbNail);
				}
			} catch (Exception e) {
				log.error("@# deleteFile error=>"+e.getMessage());
			}
		});
	}
}




