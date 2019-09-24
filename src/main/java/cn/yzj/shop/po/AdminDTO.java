package cn.yzj.shop.po;
/*
 *yzj
 *2019
 *2019年9月24日
 */
public class AdminDTO extends AdminWithBLOBs {

	/*
	 *yzj
	 *2019
	 *2019年9月24日
	 */
	private static final long serialVersionUID = 1L;
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
