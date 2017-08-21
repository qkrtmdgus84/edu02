package edu.seedit.study.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.seedit.study.junit.Calculator;

@Controller
public class StudyController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value="/study/extendsStudy.do", method = RequestMethod.GET)
	public void extendsStudy() throws Exception {
		
	}
	
	@RequestMapping(value="/study/junitAdd.do", method = RequestMethod.GET)
	public void junitAdd() throws Exception {
		Calculator calculator = new Calculator();
		System.out.println(calculator.fibo(10));
	}
	
	@RequestMapping(value="/study/junitFibo.do", method = RequestMethod.GET)
	public void junitFibo() throws Exception {
		Calculator calculator = new Calculator();
		System.out.println(calculator.sum(5, 20));
	}
	
	@RequestMapping(value="/study/mock.do", method = RequestMethod.GET)
	public void mock() throws Exception {
		
	}
}
