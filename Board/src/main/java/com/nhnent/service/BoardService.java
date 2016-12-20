package com.nhnent.service;

import java.util.List;

import com.nhnent.domain.BoardVO;

public interface BoardService {
	
	// 글 생성
	public void regist(BoardVO board) throws Exception;

	// 글 읽기
	public BoardVO read(Integer bno) throws Exception;

	// 글 수정
	public boolean modify(BoardVO board) throws Exception;

	// 글 삭제
	public void remove(Integer bno) throws Exception;

	// 전체 글 가져오기
	public List<BoardVO> listAll() throws Exception;

}
