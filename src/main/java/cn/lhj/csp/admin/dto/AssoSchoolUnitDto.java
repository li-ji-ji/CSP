package cn.lhj.csp.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssoSchoolUnitDto implements Serializable {
	
	private int id;
	private String unitNo;
	private String unitName;
	private String pUnitNo;
}
