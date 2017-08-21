package edu.seedit.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.seedit.common.dto.UserDTO;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {


	/**
	 * 명령어(실시간) 조회
	 * @param eDTO 조회조건
	 * @return 결과 목록
	 */
	@SuppressWarnings("unchecked")
	public List<UserDTO> selectUserList(UserDTO eDTO) {
		return (List<UserDTO>)list("selectUser", eDTO);
	};

	/**
	 * 명령어(실시간) 생성
	 * @param eDTO 생성할 데이터
	 * @return 입력 시 selectKey 를 사용하여 key 를 딴 경우 해당 key
	 * @throws Exception
	 */
	public Object insertUser(UserDTO eDTO) throws Exception {
		Object selectKey = update("insertUser", eDTO);
		return selectKey;
	};

	/**
	 * 명령어(실시간) 수정
	 * @param eDTO 수정할 데이터
	 * @return 성공여부 (수정된 데이터 개수)
	 * @throws Exception
	 */
	public int updateUser(UserDTO eDTO) throws Exception {
		int result = update("updateUser", eDTO);
		return result;
	};

	/**
	 * 명령어(실시간) 삭제
	 * @param eDTO 삭제할 데이터 키값
	 * @return 성공여부 (삭제된 데이터 개수)
	 * @throws Exception
	 */
	public int deleteUser(String keyId) throws Exception {
		int result = delete("deleteUser", keyId);
		return result;
	};

}