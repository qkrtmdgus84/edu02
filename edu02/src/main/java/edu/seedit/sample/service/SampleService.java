package edu.seedit.sample.service;

import java.util.List;
import java.util.Map;

import edu.seedit.sample.vo.SampleVO;

public interface SampleService {

	List<SampleVO> getSampleList(Map<String,Object> in) throws Exception;

	Object addSample(Map<String,Object> in) throws Exception;

}
