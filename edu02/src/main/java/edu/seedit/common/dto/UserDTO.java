package edu.seedit.common.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserDTO {


	private String userId         = null;// 사용자 아이디
	private String corpCode       = null;// 업체 코드
	private String userPw         = null;// 사용자 패스워드
	private String userName       = null;// 사용자 이름
	private String userPhone      = null;// 사용자 휴대폰 번호
	private String userEmail      = null;// 사용자 이메일주소
	private String userLevel      = null;// 사용자 레벨 (코드)
	private String token          = null;// 사용자 토큰
	private String userDepartment = null;// 사용자 부서 (코드)
	private String userPushid     = null;// 사용자 푸시아이디
	private String userRankcode   = null;// 사용자 랭크 코드 (미사용)
	private String userRole       = null;// 사용자 직급 코드
	private String userValue      = null;// 사용자 
	private String userStatus     = null;// 사용자 상태 (재직, 퇴직, 휴직)
	private String sessionId      = null;// 세션아이디
	private String profileName    = null;// 프로필 사진파일 이름


	/**
	 * toString 메소드를 대치한다.
	*/
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 *  사용자 아이디
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 *  사용자 아이디
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 *  사용자 패스워드
	 */
	public String getUserPw() {
		return userPw;
	}
	/**
	 *  사용자 패스워드
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	/**
	 *  사용자 이름
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 *  사용자 이름
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 *  사용자 휴대폰 번호
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 *  사용자 휴대폰 번호
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 *  사용자 이메일주소
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 *  사용자 이메일주소
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 *  사용자 레벨 (코드)
	 */
	public String getUserLevel() {
		return userLevel;
	}
	/**
	 *  사용자 레벨 (코드)
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	/**
	 *  사용자 토큰
	 */
	public String getToken() {
		return token;
	}
	/**
	 *  사용자 토큰
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 *  사용자 부서 (코드)
	 */
	public String getUserDepartment() {
		return userDepartment;
	}
	/**
	 *  사용자 부서 (코드)
	 */
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	/**
	 *  사용자 푸시아이디
	 */
	public String getUserPushid() {
		return userPushid;
	}
	/**
	 *  사용자 푸시아이디
	 */
	public void setUserPushid(String userPushid) {
		this.userPushid = userPushid;
	}
	/**
	 *  사용자 랭크 코드 (미사용)
	 */
	public String getUserRankcode() {
		return userRankcode;
	}
	/**
	 *  사용자 랭크 코드 (미사용)
	 */
	public void setUserRankcode(String userRankcode) {
		this.userRankcode = userRankcode;
	}
	/**
	 *  사용자 직급 코드
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 *  사용자 직급 코드
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 *  사용자 
	 */
	public String getUserValue() {
		return userValue;
	}
	/**
	 *  사용자 
	 */
	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}
	/**
	 *  사용자 상태 (재직, 퇴직, 휴직)
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 *  사용자 상태 (재직, 퇴직, 휴직)
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 *  세션아이디
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 *  세션아이디
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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

}