package cn.lhj.csp.authority.config;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.lhj.csp.authority.po.Student;
import cn.lhj.csp.authority.po.SysPermission;
import cn.lhj.csp.authority.po.SysRole;
import cn.lhj.csp.authority.service.StudentService;

public class MyShiroRealm extends AuthorizingRealm {
	@Resource
	private StudentService studentService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Student student = (Student) principals.getPrimaryPrincipal();
		System.out.println("----->>>>"+student);
		for (SysRole role : student.getRoleList()) {
			authorizationInfo.addRole(role.getRole());
			for (SysPermission p : role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证配置-》MyShiroRealm.doGetAuthenticationInfo()");
		// 获取用户的输入的账号.
		String name = (String) token.getPrincipal();
		System.out.println(
				"String username = (String)token.getPrincipal()------------------------------------------" + name);
//		System.out.println(token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		Student student = studentService.findByName(name);
		System.out.println("----->>student=" + student);
		//没有使用密码的情况下，注解掉为空的情况
		if (student == null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(student, // 用户名
				student.getPassword(), // 密码
				ByteSource.Util.bytes(student.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}
