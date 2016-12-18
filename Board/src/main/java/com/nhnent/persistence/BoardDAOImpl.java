package com.nhnent.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.nhnent.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.nhnent.mapper.BoardMapper";

	@Override
	/**
	 * 글 생성 
	 *
	 * @param	vo	생성할 board
	 * @return
	 */
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	/**
	 * bno 와 일치하는 글 가져오기 
	 *
	 * @param	bno	읽어올 board id 
	 * @return
	 */
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	/**
	 * 글 수정하기 
	 *
	 * @param	vo	갱신할 board 
	 * @return
	 */
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	/**
	 * bno 와 일치하는 글 삭제하기 
	 *
	 * @param	bno	삭제 board id 
	 * @return
	 */
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	/**
	 * 전체 글 가져오기 
	 *
	 * @param	 
	 * @return
	 */
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

}
