package cn.lhj.csp.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lhj.csp.admin.mapper.FontCssMapper;
import cn.lhj.csp.admin.po.FontCss;
import cn.lhj.csp.admin.service.FontCssService;


@Service
public class FontCssServiceImpl implements FontCssService {

	@Autowired
	private FontCssMapper fontCssMapper;
	@Override
	public FontCss getFontCssById(Integer id) throws Exception {
		return fontCssMapper.selectByPrimaryKey(id);
	}

}
