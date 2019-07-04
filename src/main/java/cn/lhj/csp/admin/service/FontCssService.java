package cn.lhj.csp.admin.service;


import org.springframework.stereotype.Service;

import cn.lhj.csp.admin.po.FontCss;


@Service
public interface FontCssService {
	
	//根据ID查询字体
	public FontCss getFontCssById(Integer id) throws Exception;
	
}
