package edu.seedit.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.seedit.common.dao.UserDAO;
import edu.seedit.common.dto.UserDTO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired UserDAO dao;

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public List<UserDTO> getUserList(UserDTO eDTO) {
		return dao.selectUserList(eDTO);
	};

	public Object addUser(UserDTO eDTO) throws Exception {
		return dao.insertUser(eDTO);
	};

	public int chgUser(UserDTO eDTO) throws Exception {
		return dao.updateUser(eDTO);
	};

	public int delUser(String keyId) throws Exception {
		return dao.deleteUser(keyId);
	};

}
