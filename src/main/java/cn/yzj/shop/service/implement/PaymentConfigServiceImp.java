package cn.yzj.shop.service.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.yzj.shop.mapper.PaymentMapper;
import cn.yzj.shop.po.LayUIJSON;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.PaymentExample;
import cn.yzj.shop.po.PaymentWithBLOBs;
import cn.yzj.shop.service.PaymentConfigService;
import cn.yzj.shop.systemclass.Code;
import cn.yzj.shop.util.WXPayUtil;

/*
 *yzj
 *2019
 *2019年9月23日
 */
@Service
public class PaymentConfigServiceImp implements PaymentConfigService{

	@Autowired
	private PaymentMapper paymentMapper;
	@Override
	public Msg add(Serializable id) throws Exception {
		Msg msg=new Msg();
		PaymentWithBLOBs paymentWithBLOBs=(PaymentWithBLOBs) id;
		paymentWithBLOBs.setPayCode(WXPayUtil.generateNonceStr());
		if(paymentMapper.insertSelective(paymentWithBLOBs)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg delete(Serializable id) throws Exception {
		Msg msg=new Msg();
		JSONArray array=JSONArray.parseArray((String) id);
		List<Byte> ids=new ArrayList<Byte>();
		for (Object item : array) {
			ids.add(Byte.valueOf((String)item));
		}
		PaymentExample example=new PaymentExample();
		example.createCriteria().andPayIdIn(ids);
		if(paymentMapper.deleteByExample(example)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
			
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Msg updata(Serializable id) throws Exception {
		Msg msg=new Msg();
		if(paymentMapper.updateByPrimaryKeySelective((PaymentWithBLOBs) id)>0) {
			msg.setCode(Code.SUCCESS.getCode());
			msg.setMsg(Code.SUCCESS.getMsg());
		}
		return msg;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find(Serializable id) throws Exception {
		return id;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable find() throws Exception {
		return null;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable dataPage(int limit, int page, Serializable id) throws Exception {
		return id;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}

	@Override
	public Serializable dataPage(int limit, int page) throws Exception {
		PageHelper.startPage(page, limit);
		List<PaymentWithBLOBs> paymentWithBLOBs=paymentMapper.selectByExampleWithBLOBs(null);
		PageInfo<PaymentWithBLOBs> pageInfo=new PageInfo<PaymentWithBLOBs>(paymentWithBLOBs);
		LayUIJSON uijson=new LayUIJSON(pageInfo.getTotal(), paymentWithBLOBs);
		return uijson;
		/*
		 *yzj
		 *2019
		 *2019年9月23日
		 */
		//自动生成的方法存根
		
	}
	/*
	 *yzj
	 *2019
	 *2019年9月23日
	 */
}
