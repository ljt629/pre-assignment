package com.nhnent.persistence;

import java.util.List;

import com.nhnent.domain.BoardVO;

public interface BoardDAO {

	// 글 생성 
	public void create(BoardVO vo) throws Exception;

	// 글 읽기 
	public BoardVO read(Integer bno) throws Exception;

	// 글 수정 
	public void update(BoardVO vo) throws Exception;

	// 글 삭제 
	public void delete(Integer bno) throws Exception;

	//전체 글 가져오기 
	public List<BoardVO> listAll() throws Exception;

}
