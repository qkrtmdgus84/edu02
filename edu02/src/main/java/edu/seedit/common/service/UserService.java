package edu.seedit.common.service;

import java.util.List;

import edu.seedit.common.dto.UserDTO;


public interface UserService {

	/**
	 * 명령어(실시간) 조회
	 * @param eDTO 조회 조건
	 * @return 결과 목록
	 */
	public List<UserDTO> getUserList(UserDTO eDTO);

	/**
	 * 명령어(실시간) 추가
	 * @param eDTO 생성할 데이터
	 * @return 입력 시 selectKey 를 사용하여 key 를 딴 경우 해당 key
	 * @throws Exception
	 */
	public Object addUser(UserDTO eDTO) throws Exception;

	/**
	 * 명령어(실시간) 수정
	 * @param eDTO 수정할 데이터
	 * @return 성공여부 (수정된 데이터 개수)
	 * @throws Exception
	 */
	public int chgUser(UserDTO eDTO) throws Exception;

	/**
	 * 명령어(실시간) 삭제
	 * @param eDTO 삭제할 데이터 키값
	 * @return 성공여부 (삭제된 데이터 개수)
	 * @throws Exception
	 */
	public int delUser(String keyId) throws Exception;

}
