package cn.lhj.csp.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssoManagemrntDto implements Serializable {
	private Integer id;
	private String assoId;
	private String assoName;
	private Integer assoStatus;
	private Integer assoExamined;
	private Integer assoGuiderId;
	private String assoLeader;
	private String assoAffiliateNo;
}
