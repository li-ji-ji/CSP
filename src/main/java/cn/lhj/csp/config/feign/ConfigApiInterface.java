package cn.lhj.csp.config.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.config.po.Config;
@RequestMapping("/api/config")
@CrossOrigin
@FeignClient(name= "csp-config")
public interface ConfigApiInterface {
	
	@RequestMapping("/getAll")
	public List<Config> getAll();
	
	@RequestMapping("/layuigetAll")
	public Map<String, Object> layuigetAll(@RequestParam(value = "name") int page,
			@RequestParam(value = "limit") int limit);
	
	@RequestMapping("/getById")
	public Config getById(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/edit")
	public void edit(@RequestParam(value = "operation")String operation,@RequestBody Config config, @RequestParam(value = "id") int id);
	
	@RequestMapping("/updateEnableById")
	public void updateEnableById(@RequestParam(value = "id")Integer id,@RequestParam(value = "enable") String enable);
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value = "id")Integer id);
	
	@RequestMapping("/selectByType")
	public List<Config> selectByType(@RequestParam(value = "type")String type);
	
	@RequestMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multfile)throws Exception;
}
