package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value = "/phone")
public class PhonebookController {

	// 필드
	@Autowired
	private PhonebookService phonebookService;

	// 수정폼
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("/phone/modifyForm.jsp");

		PersonVo personVo = phonebookService.exeModifyForm(no);

		model.addAttribute("pVo", personVo);
		return "/modifyForm";
	}

	// 수정폼2
	// localhost:8080/phonebook5/phone/modifyform
	@RequestMapping(value = "/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@RequestParam(value = "no") int no, Model model) {
		System.out.println("phonebookController.modifyform2()");
		System.out.println(no);
		
		Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
		model.addAttribute("pMap", pMap);
		
		return "/modifyForm2";
		
	}

	// 등록폼
	// localhost:8080/phonebook5/phone/writeform
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("/phone/writeForm.jsp");
		return "/writeForm";
	}

	// 등록
	// localhost:8080/phonebook5/phone/write?name=유영수&hp=010&company=02
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("phonebookController.write2()");

		System.out.println(personVo.toString());

		// 서비스를 메모리에 올리고
		// 서비스의 메소드 사용
		phonebookService.exeWrite(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";

	}

	// 등록2
	// localhost:8080/phonebook5/phone/write?name=유영수&hp=010&company=02
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "name") String name, @RequestParam(value = "hp") String hp,
			@RequestParam(value = "company") String company) {
		System.out.println("phonebookController.write2()");

		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);

		// vo 묶는다
		// PersonVo personVo = new PersonVo(name, hp, company);

		phonebookService.exeWrite2(name, hp, company);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("phonebookController.list()");

		// 자동연결
		List<PersonVo> personList = phonebookService.exeList();

		model.addAttribute("pList", personList);

		return "/list";

	}

	// 수정
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {

		System.out.println("phonebookController.modify()");

		// System.out.println(personVo);

		phonebookService.exeModify(personVo);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";
	}

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {

		System.out.println("phonebookController.delete()");

		// System.out.println(personId);

		phonebookService.exeDelete(no);

		// 리스트로 리다이렉트
		return "redirect:/phone/list";

	}

}
