package com.pinoSoft.pino.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @AUTHOR JIN CHANGHWI
 * 해당 파일은 컨트롤 파일로 URI를 통해 자동으로 매핑되어 return 으로 JSP 파일을 호출한다
 */

@Controller
public class PinoController {

	//메인페이지로 이동하는 컨트롤
	@RequestMapping("/")
	public String test() {
		//index.jsp로 이동
		return "index";
	}
}
