package com.nhnent.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nhnent.domain.BoardVO;
import com.nhnent.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Override
	/**
	 * 글 생성하 기
	 *
	 * @param board
	 *            생성할 글
	 * @return
	 */
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	/**
	 * bna와 일치하는 글가져오기
	 *
	 * @param bno
	 *            읽어올 board id
	 * @return
	 */
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	/**
	 * 글 수정하기
	 *
	 * @param board
	 *            수정할 글
	 * @return
	 */
	public void modify(BoardVO board) throws Exception {
		
		// 수정 날짜를 현재 시간으로 설정 
		board.setUpdated_at(new Date());
		
		// DAO - Update
		dao.update(board);
	}

	@Override
	/**
	 * bno 와 일치하는 글 삭제하기
	 *
	 * @param bno
	 *            삭제할 board id
	 * @return
	 */
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

}
