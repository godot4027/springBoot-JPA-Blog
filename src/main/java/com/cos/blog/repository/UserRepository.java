package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

// DAO
// 자동으로 빈 등록됨
public interface UserRepository extends JpaRepository<User, Integer>{

}
