package cn.lhj.csp.assomanagement.po.student;

import java.util.List;


public class Student {
	private Integer id;

    private String sn;

    private String name;

    private String dormitoryAdd;

    private String phone;

    private String email;

    private String college;

    private String classes;

    private String grade;

    private String major;

    private String famillyAdd;

    private String wxopenid;

    private String hurl;

    private String wxname;

    private String sex;

    private String school;

    private String password;

    private String salt;

    private Byte state;
    
    private List<SysRole> roleList;// 一个用户具有多个角色

    

    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getSn() {
		return sn;
	}



	public void setSn(String sn) {
		this.sn = sn;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDormitoryAdd() {
		return dormitoryAdd;
	}



	public void setDormitoryAdd(String dormitoryAdd) {
		this.dormitoryAdd = dormitoryAdd;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCollege() {
		return college;
	}



	public void setCollege(String college) {
		this.college = college;
	}



	public String getClasses() {
		return classes;
	}



	public void setClasses(String classes) {
		this.classes = classes;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public String getFamillyAdd() {
		return famillyAdd;
	}



	public void setFamillyAdd(String famillyAdd) {
		this.famillyAdd = famillyAdd;
	}



	public String getWxopenid() {
		return wxopenid;
	}



	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}



	public String getHurl() {
		return hurl;
	}



	public void setHurl(String hurl) {
		this.hurl = hurl;
	}



	public String getWxname() {
		return wxname;
	}



	public void setWxname(String wxname) {
		this.wxname = wxname;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getSchool() {
		return school;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public Byte getState() {
		return state;
	}



	public void setState(Byte state) {
		this.state = state;
	}



	public List<SysRole> getRoleList() {
		return roleList;
	}



	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", sn=" + sn + ", name=" + name + ", dormitoryAdd=" + dormitoryAdd + ", phone="
				+ phone + ", email=" + email + ", college=" + college + ", classes=" + classes + ", grade=" + grade
				+ ", major=" + major + ", famillyAdd=" + famillyAdd + ", wxopenid=" + wxopenid + ", hurl=" + hurl
				+ ", wxname=" + wxname + ", sex=" + sex + ", school=" + school + ", password=" + password + ", salt="
				+ salt + ", state=" + state + ", roleList=" + roleList + "]";
	}



	/**
	 * 密码盐.
	 * 
	 * @return
	 */
    public String getCredentialsSalt() {
		return this.name + this.salt;
	}
   
}