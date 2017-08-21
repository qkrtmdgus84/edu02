package edu.seedit.sample.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SampleVO {

	private String userId         = null;// 사용자ID
	private String userName       = null;// 사용자이름
	private String userPhone      = null;// 휴대폰번호
	private String userEmail      = null;// 이메일주소
	private String corpCode       = null;// 업체 코드
	private String userLevel      = null;// 사용자등급
	private String userDepartment = null;// 부서
	private String corpName       = null;// 업체명
	private String corpLevel      = null;// 업체등급
	private String profileName    = null;// 프로필 사진파일 이름
	private String departmentName = null;// 부서명
	private String userRankname   = null;// 사용자등급명

	/**
	 * toString 메소드를 대치한다.
	*/
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	/**
	 *  사용자ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 *  사용자ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 *  사용자이름
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 *  사용자이름
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 *  휴대폰번호
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 *  휴대폰번호
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 *  이메일주소
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 *  이메일주소
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 *  업체 코드
	 */
	public String getCorpCode() {
		return corpCode;
	}
	/**
	 *  업체 코드
	 */
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	/**
	 *  사용자등급
	 */
	public String getUserLevel() {
		return userLevel;
	}
	/**
	 *  사용자등급
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	/**
	 *  부서
	 */
	public String getUserDepartment() {
		return userDepartment;
	}
	/**
	 *  부서
	 */
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	/**
	 *  업체명
	 */
	public String getCorpName() {
		return corpName;
	}
	/**
	 *  업체명
	 */
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	/**
	 *  업체등급
	 */
	public String getCorpLevel() {
		return corpLevel;
	}
	/**
	 *  업체등급
	 */
	public void setCorpLevel(String corpLevel) {
		this.corpLevel = corpLevel;
	}
	/**
	 *  프로필 사진파일 이름
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 *  프로필 사진파일 이름
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 *  부서명
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 *  부서명
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 *  사용자등급명
	 */
	public String getUserRankname() {
		return userRankname;
	}
	/**
	 *  사용자등급명
	 */
	public void setUserRankname(String userRankname) {
		this.userRankname = userRankname;
	}

}
