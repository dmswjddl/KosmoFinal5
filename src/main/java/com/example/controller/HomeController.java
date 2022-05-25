package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.UserVO;
import com.example.service.signUpService.SignUpService;

@Controller
@RequestMapping("/include")
public class HomeController {

	@Autowired
	private SignUpService signUp;

	@RequestMapping("Header")
	public void HeaderPage() {
	}

	@RequestMapping("/Footer")
	public void FooterPage() {
	}

	@RequestMapping("/Main")
	public void MainPage(UserVO vo) {
		if (vo.getAddr3() != null) {
			vo.setUser_address(vo.getAddr2() + vo.getAddr3());
			vo.setUser_black("N");
			vo.setUser_admin("N");

			signUp.insertUser(vo);
		}
	}

	@RequestMapping("/signUp")
	public void signUpPage() {
	}

	@RequestMapping(value = "/nicknameCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String nicknameCheck(UserVO vo) {
		UserVO result = signUp.nicknameCheck(vo); // 사용가능한 닉네임이면 null값이 넘어옴
		String message = ""; // 닉네임 사용 가능 여부를 담을 변수

		if (result == null) { // 검색되는 레코드가 없으면 닉네임 사용 가능
			message = "Y";
		} // end of if
		return message;
	}

	@RequestMapping(value = "/emailCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String emailCheck(UserVO vo) {
		UserVO result = signUp.emailCheck(vo); // 사용가능한 이메일이면 null값이 넘어옴
		String message = ""; // 이메일 사용 가능 여부를 담을 변수

		if (result == null) { // 검색되는 레코드가 없으면 이메일 사용 가능
			message = "Y";
		} // end of if
		return message;
	}

	@RequestMapping("/findPassword")
	public void findPass() {
	}

	@RequestMapping("/myPage/myPageProfile")
	public void myPageProfile() {
	}

	@RequestMapping("/myPage/myPageDogList")
	public void myDogList() {
	}

	@RequestMapping("/myPage/myPageDogDetail")
	public void myDogDetail() {
	}
}
