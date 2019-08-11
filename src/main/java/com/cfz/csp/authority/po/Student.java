package com.cfz.csp.authority.po;

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



	public String getSn() {
		return sn;
	}



	public String getName() {
		return name;
	}



	public String getDormitoryAdd() {
		return dormitoryAdd;
	}



	public String getPhone() {
		return phone;
	}



	public String getEmail() {
		return email;
	}



	public String getCollege() {
		return college;
	}



	public String getClasses() {
		return classes;
	}



	public String getGrade() {
		return grade;
	}



	public String getMajor() {
		return major;
	}



	public String getFamillyAdd() {
		return famillyAdd;
	}



	public String getWxopenid() {
		return wxopenid;
	}



	public String getHurl() {
		return hurl;
	}



	public String getWxname() {
		return wxname;
	}



	public String getSex() {
		return sex;
	}



	public String getSchool() {
		return school;
	}



	public String getPassword() {
		return password;
	}



	public String getSalt() {
		return salt;
	}



	public Byte getState() {
		return state;
	}



	public List<SysRole> getRoleList() {
		return roleList;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setSn(String sn) {
		this.sn = sn;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setDormitoryAdd(String dormitoryAdd) {
		this.dormitoryAdd = dormitoryAdd;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setCollege(String college) {
		this.college = college;
	}



	public void setClasses(String classes) {
		this.classes = classes;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public void setFamillyAdd(String famillyAdd) {
		this.famillyAdd = famillyAdd;
	}



	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}



	public void setHurl(String hurl) {
		this.hurl = hurl;
	}



	public void setWxname(String wxname) {
		this.wxname = wxname;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public void setSchool(String school) {
		this.school = school;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public void setState(Byte state) {
		this.state = state;
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