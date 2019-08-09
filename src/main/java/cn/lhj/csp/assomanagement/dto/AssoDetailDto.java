package cn.lhj.csp.assomanagement.dto;

import java.io.Serializable;
import java.util.List;

import cn.lhj.csp.assomanagement.po.CspAssoStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssoDetailDto implements Serializable {
	
	private Integer id;
	private String assoId;
	private String assoName;
	private Integer assoStatus;
	private Integer assoExamined;
	private Integer assoGuiderId;
	private String assoLeader;
	private String assoAffiliateNo;
	private String assoAffiliateName;
	
	private Integer memberNum; //社团人数
	private List<CspAssoStudent> memberList; //社团成员
	
}
