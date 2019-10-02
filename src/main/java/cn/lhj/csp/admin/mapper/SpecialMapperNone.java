package cn.lhj.csp.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface SpecialMapperNone {
	// 查询数据表列名
	@Select("SELECT column_name,column_comment,DATA_TYPE FROM information_schema.columns WHERE table_schema ='csp' AND table_name =#{tableName}")
	public List<Map> getColunmByTableName(String tableName) throws Exception;
}
