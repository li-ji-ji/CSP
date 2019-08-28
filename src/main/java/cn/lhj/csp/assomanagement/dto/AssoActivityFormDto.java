package cn.lhj.csp.assomanagement.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.lhj.csp.assomanagement.po.CspAssoActivity;
import cn.lhj.csp.assomanagement.po.CspAssoManagement;
import cn.lhj.csp.assomanagement.po.CspAssoStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssoActivityFormDto extends CspAssoActivity implements Serializable  {
	
   
    
    private List<CspAssoStudent> assoStuList;
    private List<CspAssoManagement> assoList;
}
