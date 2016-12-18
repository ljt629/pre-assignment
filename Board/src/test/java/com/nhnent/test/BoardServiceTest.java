package com.nhnent.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhnent.domain.BoardVO;
import com.nhnent.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class BoardServiceTest {

	@Inject
	private BoardService service;

	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("신입사원 이준택입니다.");
		board.setContent("앞으로 잘부탁드립니다.");
		board.setWriter("juntaek.lee@nhnent.com");
		board.setPassword("qwer");
		service.regist(board);
	}

	@Test
	public void testRead() throws Exception {

		logger.info(service.read(1).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 제목");
		board.setContent("수정 테스트");
		service.modify(board);
	}

	@Test
	public void testDelete() throws Exception {

		service.remove(1);
	}

	@Test
	public void testListAll() throws Exception {

		logger.info(service.listAll().toString());

	}

}
