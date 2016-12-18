package com.nhnent.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhnent.domain.BoardVO;
import com.nhnent.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		board.setTitle("신입사원 이준택입니다.");
		board.setContent("앞으로 잘부탁드립니다.");
		board.setWriter("juntaek.lee@nhnent.com");
		board.setPassword("qwer");
		dao.create(board);
	}

	@Test
	public void testRead() throws Exception {

		logger.info("읽어온 글 : " + dao.read(2).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 제목");
		board.setContent("수정 테스트");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info("전체 글 : " + dao.listAll().toString());

	}

}
