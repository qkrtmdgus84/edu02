package edu.seedit.sample.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleRequestController {
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value="/sample/request.do")
	public ModelAndView sampleRequest(@RequestParam HashMap<String, Object> requestParam, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 입력값 수신방법
		// case1. @RequestParam HashMap<String, Object>
		// case2. HttpServletRequest
		// case2. HttpServletRequest (local declare)
		// case3. HandlerMethodArgumentResolver 이용 (신규 구조체 등록)

		String output = "";
		{
			// case1. @RequestParam HashMap<String, Object>
			String tempOut = null;
			Iterator<String> iterator = requestParam.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				logger.debug("@RequestParam [" + key + "," + requestParam.get(key) + "]");
				tempOut = (tempOut==null?"@RequestParam {":tempOut+" , ") + "{" + key + "," + requestParam.get(key) + "}";
			}
			tempOut += "}";
			logger.debug(tempOut);

			output = output + "<br>" + tempOut;
		}
		{
			// case2. HttpServletRequest
			String tempOut = null;
			@SuppressWarnings("unchecked")
			Iterator<String> iterator = request.getParameterMap().keySet().iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				logger.debug("HttpServletRequest [" + key + "," + request.getParameter(key) + "]");
				tempOut = (tempOut==null?"request {":tempOut+" , ") + "{" + key + "," + request.getParameter(key) + "}";
			}
			tempOut += "}";
			logger.debug(tempOut);

			output = output + "<br>" + tempOut;
		}
		logger.debug("HttpServletRequest:" + response==null?"null":response.toString());

		{
			// case2. HttpServletRequest (local declare)
			String tempOut = null;
			HttpServletRequest requestLocal = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			@SuppressWarnings("rawtypes")
			Iterator iterator = requestLocal.getParameterMap().keySet().iterator();
			while(iterator.hasNext()) {
				String key = (String)iterator.next();
				logger.debug("HttpServletRequest (local declare)[" + key + "," + requestLocal.getParameter(key) + "]");
				tempOut = (tempOut==null?"HttpServletRequest (local declare) {":tempOut+" , ") + "{" + key + "," + requestLocal.getParameter(key) + "}";
			}
			tempOut += "}";
			logger.debug(tempOut);

			output = output + "<br>" + tempOut;
		}

		ModelAndView mv = new ModelAndView("/sample/request");
		mv.addObject("output",output);

		return mv;
	}

	@RequestMapping(value="/sample/request1.do"/*, method = RequestMethod.GET*/)
	public ModelAndView sampleRequest1(@RequestParam Map<String,Object> commandMap) throws Exception {

		// 입력값 수신방법
		// case1. @RequestParam HashMap<String, Object>
		// case2. HttpServletRequest
		// case3. HandlerMethodArgumentResolver 이용 (신규 구조체 등록)

		String output = "";
		/*{
			// case1. @RequestParam HashMap<String, Object>

			String tempOut = null;
			Iterator<String> iterator = commandMap.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				logger.debug("@RequestParam [" + key + "," + commandMap.get(key) + "]");
				tempOut = (tempOut==null?"@RequestParam {":tempOut+" , ") + "{" + key + "," + commandMap.get(key) + "}";
			}
			tempOut += "}";
			logger.debug(tempOut);
			output = output + "<br>" + tempOut;
		}*/

		ModelAndView mv = new ModelAndView("/sample/request");
		mv.addObject("output",output);

		return mv;
	}


}
