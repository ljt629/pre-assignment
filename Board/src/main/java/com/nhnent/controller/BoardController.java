package com.nhnent.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nhnent.domain.BoardVO;
import com.nhnent.service.BoardService;
import com.nhnent.util.StringUtil;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	// 상수
	private final String PASSWORD_NOT_EQUAL		=	"PASSWORD_NOT_EQUAL";
	private final String SUCCESS				=	"SUCCESS";
	private final String INVALID_EMAIL 			=	"INVALID_EMAIL";

	// Logger
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {

		logger.info("register get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("regist post ...........");
		logger.info(board.toString());
		
		// 이메일 유효성 체크 
		boolean isValidEmail = StringUtil.isValidEmail(board.getWriter());
		
		// 이메일이 유효하다면 
		if(isValidEmail) {
			
			service.regist(board);
			rttr.addFlashAttribute("msg", SUCCESS);
			return "redirect:/board/listAll";
		}
		// 유효하지 않다면
		else {
			
			model.addAttribute("msg", INVALID_EMAIL);
			return "/board/register";
		}
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		logger.info("show all list......................");
		model.addAttribute("list", service.listAll());
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

		service.remove(bno);

		rttr.addFlashAttribute("msg", SUCCESS);

		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {

		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("mod post............");
		
		// 글 수정 성공
		if(service.modify(board)) {
			
			rttr.addFlashAttribute("msg", SUCCESS);
			return "redirect:/board/listAll";
		}
		
		// 글 수정 실패 
		else {
			
			model.addAttribute("msg", PASSWORD_NOT_EQUAL);
			return "/board/modify";
		}
	}

}
