package cn.lhj.csp.menu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;




public interface SpecialMapper {
	// 查询数据表列名
	@Select("SELECT column_name,column_comment,DATA_TYPE FROM information_schema.columns WHERE table_schema ='csp' AND table_name =#{tableName}")
	public List<Map> getColunmByTableName(String tableName) throws Exception;
	
	/*
	 * //查询数据条数
	 * 
	 * @Select("select count(*) from csp_admin_menu") int getCount();
	 * 
	 * //查询指定条数数据
	 * 
	 * @Select("select * from csp_admin_menu limit #{No},#{count}")
	 * List<CspAdminMenu> getMenuLimit(Integer No,Integer count);
	 */
	 
}
