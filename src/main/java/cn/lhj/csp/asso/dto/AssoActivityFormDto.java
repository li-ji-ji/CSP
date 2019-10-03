package cn.lhj.csp.asso.dto;

import java.io.Serializable;
import java.util.List;

import cn.lhj.csp.asso.po.CspAssoActivity;
import cn.lhj.csp.asso.po.CspAssoManagement;
import cn.lhj.csp.asso.po.CspAssoStudent;
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
