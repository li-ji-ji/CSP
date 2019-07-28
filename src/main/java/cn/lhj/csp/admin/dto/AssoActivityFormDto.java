package cn.lhj.csp.admin.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.lhj.csp.admin.po.asso.CspAssoManagement;
import cn.lhj.csp.admin.po.asso.CspAssoStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssoActivityFormDto implements Serializable {
	
    private Integer id;
    private String activityId;
    private String activityName;
    private Integer activityStatus;
    private String activityAssoId;
    private String activityAssoName;
    private String activityOrganizerId;
    private String activityOrganizerName;
    private Integer activityNum;
    private Integer activityPartNum;
    private Date activityStartTime;
    private Date activityFinishTime;
    private String activityIntro;
    
    private List<CspAssoStudent> assoStuList;
    private List<CspAssoManagement> assoList;
}
