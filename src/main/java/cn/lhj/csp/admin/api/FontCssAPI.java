package cn.lhj.csp.admin.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.lhj.csp.admin.po.FontCss;
import cn.lhj.csp.admin.service.FontCssService;


@RestController
@RequestMapping("/csp/api/fontCss")
@CrossOrigin
public class FontCssAPI {
	
	@Autowired
	private FontCssService fontCssService;
	
	@RequestMapping("/getCssById")
	public FontCss getCssById(Integer id,HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		return fontCssService.getFontCssById(2);
	}
	
}
