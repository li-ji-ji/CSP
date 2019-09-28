package cn.yzj.shop.systemclass;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.yzj.shop.util.WXPayUtil;

/*
 *yzj
 *2019
 *2019年9月26日
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		    boolean isOk=false;
		    Cookie[] cookies=request.getCookies();
		    String uuid="";
		    if(cookies!=null) {
		    	for (Cookie cookie : cookies) {
					if(cookie.getName().equals("token")) {
						uuid=cookie.getValue();
					}
				}
		    }
		    Long time=redisTemplate.getExpire(uuid,TimeUnit.MILLISECONDS);
		        if(time>0) {
		        	if(time<1000*60*4) {
		        		redisTemplate.expire(uuid,1000*60*8,TimeUnit.MILLISECONDS);
		        	}
		        	isOk=true;
		        }else {
					response.sendRedirect("/admin/login");
				}
				return isOk;
	}
	@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
		}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		/*
		 *yzj
		 *2019
		 *2019年9月26日
		 */
		//自动生成的方法存根
		
	}
}
