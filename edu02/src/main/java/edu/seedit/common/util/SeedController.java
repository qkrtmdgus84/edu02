package edu.seedit.common.util;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public class SeedController {

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 입력 파라미터 디버그 출력용
	 */
	@SuppressWarnings("unused")
	protected void showParameter(Map<String,Object> requestParam) {
		if(logger.isDebugEnabled() == false) return;

		try {
			String tempOut = null;
			Iterator<String> iterator = requestParam.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				//logger.debug(" @RequestParam [" + key + "," + requestParam.get(key) + "]");
				tempOut = (tempOut==null?" @RequestParam {":tempOut+" , ") + "{" + key + "," + requestParam.get(key) + "}";
			}
			if(tempOut != null) {
				logger.debug(tempOut + "}");
			}
		} catch (Exception e) {
			logger.debug("Exception:" + e.toString());
		}
	}

}
