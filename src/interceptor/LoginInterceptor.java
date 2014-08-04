package interceptor;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String handlerMethod = ((HandlerMethod)handler).getMethod().getName();
		logger.info(handlerMethod + " 開始執行... " + request.getRequestURI());
		
		if("login".equals(handlerMethod)) return true;  // 執行登入
		
		HttpSession session = request.getSession();		
		// 尚未登入
		if(null == session.getAttribute("user")) {
			request.setAttribute("message", "請登入!");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return false;
		}
		
		return true;
		
		
	}
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		Method handlerMethod = ((HandlerMethod)handler).getMethod();
//
//		logger.info(handlerMethod + " 開始執行... " + request.getRequestURI());
//		final String LOGIN = "login";
//		
//		String handlerMethodName = handlerMethod.getName();
//		if(request.getRequestURI().equals(LOGIN)) {
//			return true;
//		}
//		
////		if("login".equals(handlerMethodName) || "welcome".equals(handlerMethodName) || "logout".equals(handlerMethodName)) return true;
//		
//		if(request.getSession().getAttribute("user") == null) {
//			logger.info("尚未登入!!");
//			request.setAttribute("message", "請登入!");
////			response.sendRedirect("/welcome.do");
////			response.sendRedirect(response.encodeRedirectURL("/" + LOGIN + ".do"));
////			request.getRequestDispatcher("/welcome.do").forward(request, response);
//			return false;
//		}		
//		
//		return true;
//	}
}
