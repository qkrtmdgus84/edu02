package edu.seedit.common.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value="/sample/openSample.do", method = RequestMethod.GET)
	public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception {

		ModelAndView mv = new ModelAndView("jsp-pageName");
		logger.debug(">> interceptorTest");

		return mv;
    }

}
