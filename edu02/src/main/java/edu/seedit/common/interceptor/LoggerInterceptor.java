package edu.seedit.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoggerInterceptor extends HandlerInterceptorAdapter {

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("===== preHandle() " + 
					(request == null ? "request is null. ":	(" requestURI[" + request.getRequestURI() + "]")) +
					(response == null ? "response is null. ": (" response[" + response.toString() + "]")));
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("===== postHandle() " + 
						(request == null ? "request is null. ":	(" requestURI[" + request.getRequestURI() + "]")) +
						(response == null ? "response is null. ": (" response[" + response.toString() + "]")) +
						(modelAndView == null ? "modelAndView is null. ": (" modelAndView[" + modelAndView.toString() + "]")));
		}
	}

	@Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		if (logger.isDebugEnabled()) {
			logger.debug("===== afterCompletion() " + 
					(request == null ? " request is null. ":	(" requestURI[" + request.getRequestURI() + "]")) +
					(response == null ? " response is null. ": (" response[" + response.toString() + "]")) +
					(ex == null ? " Exception is null. ": (" Exception[" + ex.toString() + "]")));
		}
	 }

}
