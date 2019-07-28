package cn.lhj.csp.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssoSchoolDto implements Serializable {
	
	private Integer id;
	private String schoolNo;
	private String schoolName;
	private Integer schoolAddressProvinceId;
	private Integer schoolAddressCityId;
}
