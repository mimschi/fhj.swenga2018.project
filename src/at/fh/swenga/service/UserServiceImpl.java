package at.fh.swenga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import at.fh.swenga.controller.UserDto;
import at.fh.swenga.dao.RoleDAO;
import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.User;

@Service
public class UserServiceImpl implements UserService 
{	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void save(UserDto userDto)
	{
		User user = new User();
		user.setName(userDto.getNickname());
		user.setPasswort(passwordEncoder.encode(userDto.getPasswort()));
		user.setVorname(userDto.getVorname());
		user.setNachname(userDto.getNachname());
		user.setAktiv(true);
		user.setRole(roleDao.getRole(1));
		userDao.persist(user);

	}

	public boolean exists(String nickname)
	{
		User user = userDao.getUser(nickname);
		if(user == null)
			return false;
		else
			return true;
	}

}
