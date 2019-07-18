package cn.lhj.csp.admin.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssoManagemrntDto implements Serializable{
	private Integer id;
	private String assoName;
	private Integer assoStatus;
	private Integer assoExamined;
	private Integer assoGuiderId;
	private String assoLeader;
}
