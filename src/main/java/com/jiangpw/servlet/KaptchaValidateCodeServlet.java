package com.jiangpw.servlet;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import com.jiangpw.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@SuppressWarnings("serial")
public class KaptchaValidateCodeServlet extends HttpServlet implements Servlet {

	static final String VALIDATE_CODE_SERIAL = "validate_code_serial";
    Logger logger = LoggerFactory.getLogger(KaptchaValidateCodeServlet.class);
	private Properties props = new Properties();

	private Producer kaptchaProducer = null;

	@Override
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);

		// Switch off disk based caching.
		ImageIO.setUseCache(false);

		Enumeration<?> initParams = conf.getInitParameterNames();
		while (initParams.hasMoreElements()) {
			String key = (String) initParams.nextElement();
			String value = conf.getInitParameter(key);
			this.props.put(key, value);
		}

		Config config = new Config(this.props);
		this.kaptchaProducer = config.getProducerImpl();
	}

	/**
	 * @throws IOException
	 *             *
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");

		ServletOutputStream out = null;
		// 创建含有文字的图片
		try {
			String sessionId = getSessionIdFromCookie(request, response);
			String capText = this.kaptchaProducer.createText();
			BufferedImage bi = this.kaptchaProducer.createImage(capText);
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);

//			MemCachedUtil.setCache(sessionId, capText, CacheTimes.TEN_MINUTES);
			SessionUtil.setSessionAttribute(request, Constants.SESSION_KEY_VAL,capText);
		} catch (Exception e) {
            logger.error("异常", e);
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
                    logger.error("异常", e);
				}
			}
		}

	}

	/**
	 * 获取cookie name 为 session_id 的 对应的 value，并且向cookie 中设置
	 * 
	 * @return String
	 */
	private static String getSessionIdFromCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cks = request.getCookies();
		String sessionId = CookieUtils.getCooKieValue(VALIDATE_CODE_SERIAL, cks);
		if (sessionId == null) {
			sessionId = request.getSession().getId();
		}
		CookieUtils.setSessionCookie(VALIDATE_CODE_SERIAL, sessionId, null, response);
		return sessionId;
	}

	/**
	 * 只是获取sessionId
	 * 
	 * @param request
	 * @return
	 */
	public static String getSessionId(HttpServletRequest request) {
		Cookie[] cks = request.getCookies();
		return CookieUtils.getCooKieValue(VALIDATE_CODE_SERIAL, cks);
	}

	/**
	 * 清除验证码
	 * 
	 * @param key
	 */
	public static void cleanValidateCode(String key) {
		MemCachedUtil.cleanCache(key);
	}
}
