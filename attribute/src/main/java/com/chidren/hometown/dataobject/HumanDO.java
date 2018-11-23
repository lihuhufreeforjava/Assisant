package com.chidren.hometown.dataobject;

import com.children.annotation.DateTimeDesc;
import com.children.annotation.IntegerDesc;
import com.children.annotation.StringDesc;
import com.children.gernater.DataSource;
import com.children.gernater.Strategy;

/**
 * Description: []
 */
public class HumanDO {

	/** 主键 */
	private Integer id;
	/**  */
	private java.util.Date gmtCreate;
	/**  */
	private java.util.Date gmtModified;
	/** 中文名称 */
	@StringDesc(fixLength = 10,canNull = false,strategy = Strategy.String_Fix_Length,maxLength = 20,minLength = 5,prefix = {"赵","钱","孙","李","周","吴","证","王","往","汪","因","银","虎","胡","锚","土","田","商","家","刘","往","的","方","若","山","地方","上","东方","浩","好","的","到","电费","高"})
	private String fullname;
	/** 英文全名 */
	@StringDesc(fixLength = 10,canNull = false,strategy = Strategy.String_Fix_Length,maxLength = 10,minLength = 5,prefix = {"赵","钱","孙","李","周","吴","证","王","往","汪","因","银","虎","胡","锚","土","田","商","家","刘","往","的","方","若","山","地方","上","东方","浩","好","的","到","电费","高"})
	private String englishName;
	/** 户口所在地 */
	@StringDesc(fixLength = 10,canNull = false,dataSource = DataSource.article,strategy = Strategy.String_Fix_Length,maxLength = 20)
	private String registerReside;
	/** 身份证 */
	@StringDesc(strategy = Strategy.String_Fill_Fix_Length,fixLength = 15,randomChar = {'1','2','3','4','5','6','7','8','9','0'})
	private String identification;
	/** 民族 */
	@StringDesc(fixLength = 10,canNull = false,strategy = Strategy.String_Fix_Length,maxLength = 10,minLength = 5,prefix = {"赵族","钱族","孙族","李族","周族","吴族","证族","王族","往族","汪族","因族","银族","虎族"})
	private String nation;
	/** 性别 */
	@IntegerDesc(valueEnum = {1, 2}, strategy = Strategy.Integer_Enum)
	private Integer sex;
	/** 生日 */
	@DateTimeDesc(maxDate = "2018-11-11",minDate = "1990-11-05",strategy = Strategy.Date_Random_Between)
	private java.util.Date birthday;
	/** 头像地址 */
	@StringDesc(dataSource = DataSource.article,strategy = Strategy.String_Random_Length,maxLength = 100,ranLength=100)
	private String headImage;
	/** 政治面貌 */
	@StringDesc(dataSource = DataSource.article,strategy = Strategy.String_Random_Length,maxLength = 10)
	private String politicalOutlook;
	/** 血型 */
	@StringDesc(dataSource = DataSource.article,strategy = Strategy.String_Random_Length,maxLength = 5)
	private String bloodType;
	/** 身高 */
	@IntegerDesc(maxValue=200,minValue = 0,canNull =false,strategy=Strategy.Integer_Auto_Increment_Repeat)
	private Integer height;
	/** 概述 */
	@StringDesc(dataSource = DataSource.article,strategy = Strategy.String_Random_Length,maxLength = 100)
	private String summary;
	/** 邮箱 */
	@StringDesc(dataSource = DataSource.article,strategy = Strategy.String_Random_Length,maxLength = 20)
	private String email;
	/** 电话 */
	@StringDesc(dataSource = DataSource.article,prefix = {"177","158","133"},strategy = Strategy.String_Fill_Fix_Length,maxLength = 11,fixLength = 11,randomChar = {'1','2','3','4','5','6','7','8','9','0'})
	private String mobile;
	/** 是否结婚 */
	@IntegerDesc(valueEnum = {1, 2}, strategy = Strategy.Integer_Enum)
	private Integer marryed;
	/** 加入工作时间 */
	@DateTimeDesc(maxDate = "2018-11-11",minDate = "1990-11-05",strategy = Strategy.Date_Random_Between)
	private java.util.Date joinworkTime;
	/** 教育 */
	@IntegerDesc(valueEnum = {10, 20}, strategy = Strategy.Integer_Enum)
	private Integer education;
	/** 人状态 */
	@IntegerDesc(valueEnum = {10,20,30,40,50,60}, strategy = Strategy.Integer_Enum)
	private Integer humanStatus;
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	public java.util.Date getGmtCreate(){
		return gmtCreate;
	}
	
	public void setGmtCreate(java.util.Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}
	public java.util.Date getGmtModified(){
		return gmtModified;
	}
	
	public void setGmtModified(java.util.Date gmtModified){
		this.gmtModified = gmtModified;
	}
	public String getFullname(){
		return fullname;
	}
	
	public void setFullname(String fullname){
		this.fullname = fullname;
	}
	public String getEnglishName(){
		return englishName;
	}
	
	public void setEnglishName(String englishName){
		this.englishName = englishName;
	}
	public String getRegisterReside(){
		return registerReside;
	}
	
	public void setRegisterReside(String registerReside){
		this.registerReside = registerReside;
	}
	public String getIdentification(){
		return identification;
	}
	
	public void setIdentification(String identification){
		this.identification = identification;
	}
	public String getNation(){
		return nation;
	}
	
	public void setNation(String nation){
		this.nation = nation;
	}
	public Integer getSex(){
		return sex;
	}
	
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public java.util.Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}
	public String getHeadImage(){
		return headImage;
	}
	
	public void setHeadImage(String headImage){
		this.headImage = headImage;
	}
	public String getPoliticalOutlook(){
		return politicalOutlook;
	}
	
	public void setPoliticalOutlook(String politicalOutlook){
		this.politicalOutlook = politicalOutlook;
	}
	public String getBloodType(){
		return bloodType;
	}
	
	public void setBloodType(String bloodType){
		this.bloodType = bloodType;
	}
	public Integer getHeight(){
		return height;
	}
	
	public void setHeight(Integer height){
		this.height = height;
	}
	public String getSummary(){
		return summary;
	}
	
	public void setSummary(String summary){
		this.summary = summary;
	}
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getMobile(){
		return mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public Integer getMarryed(){
		return marryed;
	}
	
	public void setMarryed(Integer marryed){
		this.marryed = marryed;
	}
	public java.util.Date getJoinworkTime(){
		return joinworkTime;
	}
	
	public void setJoinworkTime(java.util.Date joinworkTime){
		this.joinworkTime = joinworkTime;
	}
	public Integer getEducation(){
		return education;
	}
	
	public void setEducation(Integer education){
		this.education = education;
	}
	public Integer getHumanStatus(){
		return humanStatus;
	}
	
	public void setHumanStatus(Integer humanStatus){
		this.humanStatus = humanStatus;
	}
}
