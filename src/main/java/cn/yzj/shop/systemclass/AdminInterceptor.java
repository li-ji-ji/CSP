package cn.yzj.shop.systemclass;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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
		        if(redisTemplate.getExpire("admin_sesion",TimeUnit.MILLISECONDS)>0) {
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
