package cn.yzj.shop.api;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import cn.yzj.shop.po.EmailTemplate;
import cn.yzj.shop.po.Msg;
import cn.yzj.shop.po.SelectTreeDTO;
import cn.yzj.shop.po.SystemModule;
import cn.yzj.shop.service.implement.SystemsModuleImp;
import cn.yzj.shop.util.EmailUtil;
/*
 * 
 *yzj
 *2019
 *2019年9月12日
 */
@RestController
@RequestMapping("/api")
public class AdminMenuApi {
	@Autowired
	private SystemsModuleImp systemsModule;
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired EmailUtil emailUtil;
	/**
	 * 数据表分页查询
	 */
	@RequestMapping("/getSystemModuleByPid")
	public Object getSystemModuleAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "pid", defaultValue = "0") short pid) throws Exception {
		return systemsModule.dataPage(limit, page, pid);
	}

	/**
	 * 添加菜单
	 * 
	 * @param systemModule
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addSystemModule")
	public Msg addSystemModule(SystemModule module) throws Exception {
		return systemsModule.add(module);
	}
	/**
	 *   获取下拉树模型有url
	* @return
	* @throws Exception
	*/
	@RequestMapping("/getSelectTree")
	public List<SelectTreeDTO> getSelectTree() throws Exception {
		return systemsModule.getSelectTree();
	}
	/**
	 *   获取下拉树模型没有url
	* @return
	* @throws Exception
	*/
	@RequestMapping("/getSelectTreeNo")
	public List<SelectTreeDTO> getSelectTreeNo() throws Exception {
		return systemsModule.getSelectTreeNo();
	}
	/**
	 * 删除菜单
	 * param String
	 * return msg
	 * @throws Exception 
	 */
	@RequestMapping("/deleteMenu")
	public Msg deleteMenu(@RequestParam("ids")String ids) throws Exception {
		return systemsModule.delete(ids);
	}
	@RequestMapping("/updataMenu")
	public Msg updataMenu(SystemModule systemModules) throws Exception {
		return systemsModule.updata(systemModules);
	}
	public static ExecutorService FIXED_THREAD_POOL=Executors.newFixedThreadPool(30);
	@RequestMapping("/test")
	public DeferredResult<String> test() throws Exception{
		int i=1/0;
		System.out.println("外部线程:"+Thread.currentThread().getName());
		DeferredResult<String> deferredResult=new DeferredResult<String>(10*1000L);//设置超时时间
		deferredResult.onTimeout(new Runnable() {
			
			@Override
			public void run() {
				/*
				 *yzj
				 *2019
				 *2019年9月19日
				 */
				//自动生成的方法存根
				System.out.println("超时了");
				deferredResult.setResult("超时了");
			}
		});
		deferredResult.onCompletion(new Runnable() {
			
			@Override
			public void run() {
				/*
				 *yzj
				 *2019
				 *2019年9月19日
				 */
				//自动生成的方法存根
				System.out.println(Thread.currentThread().getName()+"调用完成!");
			}
		});
		FIXED_THREAD_POOL.execute(new Runnable() {
			
			@Override
			public void run() {
				/*
				 *yzj
				 *2019
				 *2019年9月19日
				 */
				//自动生成的方法存根
				try {
					Thread.sleep(20*1000L);
				} catch (InterruptedException e) {
					/*
					 *yzj
					 *2019
					 *2019年9月19日
					 */
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println("内部线程:"+Thread.currentThread().getName());
				deferredResult.setResult("线程执行");
			}
		});
		return deferredResult;

	}
    @RequestMapping("/getUser")
    public Serializable getUser() throws Exception {
        return systemsModule.find();
    }
	
}
