package cn.yzj.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.yzj.shop.systemclass.AdminInterceptor;

/*
 *yzj
 *2019
 *2019年9月26日
 */
@Configuration
public class InterceptorAdapter implements WebMvcConfigurer {
	@Autowired
	private AdminInterceptor InterceptorAdapter;
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/admin/index");
		registry.addRedirectViewController("/admin", "/admin/index");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(InterceptorAdapter).addPathPatterns("/**").excludePathPatterns( "/admin/login","/api/verification",
				"/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/fonts/*",
				"/**/*.svg");
	}

}
