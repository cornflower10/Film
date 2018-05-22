package com.jiangpw.filter;


import com.jiangpw.utils.Constants;
import com.jiangpw.utils.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

public class AuthFilter implements Filter {
	
	private static String[] LOGIN_WHITE_LIST;

	static {
		try {
//			Properties props = PropertiesLoaderUtils.loadAllProperties("config-common.properties");

			Properties pcProps = PropertiesLoaderUtils.loadAllProperties("pc-conf.properties");
			String logiWhiteList = pcProps.getProperty("login.white.list");
			if (StringUtils.isNotBlank(logiWhiteList)) {
				LOGIN_WHITE_LIST = logiWhiteList.split(",");
			}
		} catch (IOException e) {

		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String serverName = httpRequest.getServerName();
		// 获取domain
//		String domain = ServerDomainUtils.getDomainByServerName(serverName);
////		ServerDomainUtils.setDomain(domain);
//				String currentURL = httpRequest.getRequestURI();
//				String targetURL = currentURL.substring(httpRequest.getContextPath().length(),
//				currentURL.length());

		if (!isInWhiteList(httpRequest.getRequestURI())
				 ) {
			if(null==httpRequest.getSession(false)
					||null== SessionUtil.getSessionAttribute(httpRequest,Constants.SESSION_KEY)){
				httpResponse.sendRedirect("/user/login");
			}else {
				chain.doFilter(request, response);
			}

		}else {

			chain.doFilter(request, response);
		}


//		String currentURL = httpRequest.getRequestURI(); // 取得根目录所对应的绝对路径:
//
//		//String targetURL = currentURL.substring(currentURL.indexOf("/", 1),
////		currentURL.length()); // 截取到当前文件名用于比较
//		String targetURL = currentURL.substring(httpRequest.getContextPath().length(),
//				currentURL.length()); // 截取到当前文件名用于比较
//
////		HttpSession session = httpRequest.getSession(false);
//
//		if (!"/user/login".equals(targetURL)
//				&&!"/user/doLogin".equals(targetURL)
//				&&!"/validateCode".equals(targetURL)) {
//
//			if (null==httpRequest.getSession(false)||null==SessionUtil.getSessionAttribute(httpRequest,Constants.SESSION_KEY)) {
//			// 放行。让其走到下个链或目标资源中
////				httpRequest.getRequestDispatcher("/user/login").forward(request, response);
//				httpResponse.sendRedirect("/user/login");
//				return; }
//		}
//		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// WebApplicationContext webApplicationContext =
		// WebApplicationContextUtils
		// .getRequiredWebApplicationContext(filterConfig.getServletContext());
		// loginManage = (LoginManager)
		// webApplicationContext.getBean("loginManager");
	}

	@Override
	public void destroy() {

	}

	private boolean isInWhiteList(String uri) {
		if (StringUtils.isBlank(uri) || null == LOGIN_WHITE_LIST || LOGIN_WHITE_LIST.length <= 0)
			return false;

		uri += Constants.URI_APPEND;
		for (String whiteList : LOGIN_WHITE_LIST) {
			if (uri.contains(whiteList))
				return true;
		}

		return false;
	}

}
