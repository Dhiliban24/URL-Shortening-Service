package com.ctsproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctsproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	public User findUserByUserName(String name);
	public List<User> findByAuthStatusEquals(String auth);
}
