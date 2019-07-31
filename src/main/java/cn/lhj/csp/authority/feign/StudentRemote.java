package cn.lhj.csp.authority.feign;


import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysRole;
import cn.lhj.csp.authority.po.SysRolePermission;
import cn.lhj.csp.authority.po.SysStudentRole;

@FeignClient(name="csp-authority")
public interface StudentRemote {
	
	/**
	 * 学生表
	 */
	@RequestMapping("/bg/studentapi/all")
	public Map<String, Object> all(@RequestParam("page") int page,
			@RequestParam("limit") int limit) throws Exception;
	
	@RequestMapping("/bg/studentapi/toedit")
	public Student toEdit(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/studentapi/onedit")
	public Integer edit(@RequestBody Student student) throws Exception;
	
	@RequestMapping("/bg/studentapi/batchdelete")
	public Integer batchDelete(@RequestParam("jsonStr") String jsonStr);
	
	@RequestMapping("/bg/studentapi/delete")
	public Integer delete(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping(value = "/bg/studentapi/excelimport", method = RequestMethod.POST)
	public Integer excelImport(@RequestParam("file") MultipartFile file) throws Exception ;
	
	/**
	 * 学生角色中间表
	 */
	@RequestMapping("/bg/studentroleapi/all")
	public Map<String, Object> getStudentRoleAll(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception ;
	
	@RequestMapping("/bg/studentroleapi/toedit")
	public SysStudentRole studentRoleToEdit(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/studentroleapi/onedit")
	public Integer studentRoleEdit(@RequestBody SysStudentRole sysStudentRole) throws Exception;
	
	@RequestMapping("/bg/studentroleapi/delete")
	public Integer studentRoleDelete(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/studentroleapi/batchdelete")
	public Integer studentRoleBatchDelete(@RequestParam("jsonStr") String jsonStr);
	
	/**
	 * 角色remote
	 */
	@RequestMapping("/bg/roleapi/all")
	public Map<String, Object> getRoleAll(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception;
	
	@RequestMapping("/bg/roleapi/toedit")
	public SysRole roleToEdit(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/roleapi/onedit")
	public Integer roleEdit(@RequestBody SysRole sysRole) throws Exception;
	
	@RequestMapping("/bg/roleapi/delete")
	public Integer roleDelete(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/roleapi/batchdelete")
	public Integer roleBatchDelete(@RequestParam("jsonStr") String jsonStr);
	
	/**
	 * 角色权限remote
	 */
	@RequestMapping("/bg/rolepermissionapi/all")
	public Map<String, Object> getRolePermissionAll(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception;
	
	@RequestMapping("/bg/rolepermissionapi/toedit")
	public SysRolePermission rolePermissionToEdit(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/rolepermissionapi/onedit")
	public Integer rolePermissionEdit(@RequestBody SysRolePermission sysRolePermission) throws Exception;
	
	@RequestMapping("/bg/rolepermissionapi/delete")
	public Integer rolePermissionDelete(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/rolepermissionapi/batchdelete")
	public Integer rolePermissionBatchDelete(@RequestParam("jsonStr") String jsonStr);
	
	/**
	 * 权限remote
	 */
	@RequestMapping("/bg/permissionapi/all")
	public Map<String, Object> getPermissionAll(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int limit) throws Exception;
	
	@RequestMapping("/bg/permissionapi/toedit")
	public SysPermission permissionToEdit(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/permissionapi/onedit")
	public Integer permissionEdit(@RequestBody SysPermission sysPermission) throws Exception;
	
	@RequestMapping("/bg/permissionapi/delete")
	public Integer permissionDelete(@RequestParam("id") Integer id) throws Exception;
	
	@RequestMapping("/bg/permissionapi/batchdelete")
	public Integer permissionBatchDelete(@RequestParam("jsonStr") String jsonStr);
	
}
