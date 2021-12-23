package com.pinosoft.jinch;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pinosoft.jinch.insa.InsaDao;
import com.pinosoft.jinch.insa.InsaServiceImpl;
import com.pinosoft.jinch.insa.InsaVo;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyTest{

	@Autowired
	InsaServiceImpl insaService;
	InsaDao insaDao;

	
	@Test
	void test() {
		for(int i=0;i<=10;i++) {
			Thread t = new Count(i);

			t.start();

		}

	}

}
