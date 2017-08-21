package edu.seedit.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.seedit.common.util.SeedController;
import edu.seedit.sample.service.SampleService;
import edu.seedit.sample.vo.SampleVO;

@Controller
public class SampleController extends SeedController  {
	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name="SampleService")
	private SampleService sampleService;

	@RequestMapping(value="/sample/openSampleList_pre.do")
	public ModelAndView openSample(@RequestParam Map<String,Object> requestParam) throws Exception {
		showParameter(requestParam);

		ModelAndView mv = new ModelAndView("/sample/sampleList_pre");

		List<SampleVO> list = sampleService.getSampleList(requestParam);
		mv.addObject("list", list);

		return mv;
	}


	@RequestMapping(value="/sample/openSampleList.do"/*, method = RequestMethod.POST*/)
	public ModelAndView openSampleList(@RequestParam Map<String,Object> requestParam) throws Exception {
		showParameter(requestParam);

		ModelAndView mv = new ModelAndView("/sample/sampleList");

		List<SampleVO> list = sampleService.getSampleList(requestParam);
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(value="/sample/sampleWrite.do")
	public ModelAndView writeSample(@RequestParam Map<String,Object> requestParam) throws Exception {
		showParameter(requestParam);

		ModelAndView mv = new ModelAndView("/sample/sampleWrite");

		if(getValue(requestParam, "mode") != null && getValue(requestParam, "mode").equals("result")) {

logger.debug("result before");
			Object result = sampleService.addSample(requestParam);
			logger.debug("result[" + result + "]:" + result.toString());
			mv.addObject("result", result);
			mv.addObject("mode", "result");
logger.debug("result after");
		}

		return mv;
	}

	@RequestMapping(value="/sample/sampleWriteResult.do")
	public ModelAndView writeSampleResult(@RequestParam Map<String,Object> requestParam) throws Exception {
		showParameter(requestParam);

		ModelAndView mv = new ModelAndView("/sample/sampleWriteResult");

		Object result = sampleService.addSample(requestParam);
		logger.debug("result[" + result + "]:" + result.toString());
		mv.addObject("result", result);

		return mv;
	}



	/**
	 * 입력 파라미터 값 확인 후 리턴한다.
	 * @return
	 */
	private String getValue(Map<String,Object> requestParam, Object key) {
		if (key == null || key.toString().length() == 0) return "";

		Object value = requestParam.get(key);
		if (value == null || value.toString().length() == 0) return "";

		logger.debug("param [" + key + "," + value + "]");
		return value.toString();
	}

}
