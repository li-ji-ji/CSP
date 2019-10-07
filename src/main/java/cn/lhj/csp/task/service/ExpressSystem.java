package cn.lhj.csp.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yzj.csp.task.mapper.ExpressMapper;
import cn.yzj.csp.task.po.Express;
import cn.yzj.csp.task.service.Interface.ExpressInterface;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class ExpressSystem implements ExpressInterface {

	@Autowired
	private ExpressMapper expressMapper;

	@Override
	public int insertExpress(Express express) throws Exception {
		int isok = 0;

		isok = expressMapper.insertSelective(express);

		return isok;
	}

	@Override
	public int insertExpressList(String expresses) throws Exception {
		int isok = 0;
		List<Express> expressList=new ArrayList<Express>();
		JSONObject jsonObject=JSONObject.fromObject(expresses);
	    JSONArray jsonArray= jsonObject.getJSONArray("expresses");
	    
	    for (Object object : jsonArray) {
	    	JSONObject exp=JSONObject.fromObject(object);
	    	Express express=(Express) JSONObject.toBean(exp,Express.class);
			expressList.add(express);
			System.out.println(expressList);
			System.out.println(express.getTakeaddress());
		}
		isok=expressMapper.insertExpressList(expressList);
		return isok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<List<Express>> selectBySuperiortaskId(String ids) throws Exception {
		List<Express> expresses=new ArrayList<Express>();
		List<Integer> is=new ArrayList<Integer>();
		JSONArray array=JSONArray.fromObject(ids);
		for (Object object : array) {
			is.add((Integer) object);
		}
		expresses=expressMapper.selectBySuperiortaskId(array);
       List<List<Express>> exList =new ArrayList<List<Express>>();	
		for (int intg : is) {
			List<Express> item=new ArrayList<Express>();
			for (Express express : expresses) {
				if(express.getSuperiortaskId()==intg) {
					item.add(express);
				}
			}
			exList.add(item);
		}
		return exList;
	}

	@Override
	public List<Express> findExpressAll() throws Exception {
		List<Express> expresses=new ArrayList<Express>();
		expresses=expressMapper.findExpressAll();
		return expresses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Express> findExpressByPid(String pId) throws Exception {
		List<Express> expresses=new ArrayList<Express>();
		JSONArray array=JSONArray.fromObject(pId);
		expresses=expressMapper.selectBySuperiortaskId(array);
		return expresses;
	}

	

}
