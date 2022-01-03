package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity // User 클래스가 MySQL에 테이블이 생성됨
// @DynamicInsert insert시 null인 필드를 제외시켜준다
public class User {

	@Id	//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의  넘버링 전략을 따라감.
	private int id;	// 시퀀스, auto_increment
	
	@Column(nullable = false, length = 20)
	private String username; // 아이디
	 
	@Column(nullable = false, length = 100) // 12345 => 해쉬(비밀번호 암호화)
	private String password; // 비밀번호
	
	@Column(nullable = false, length = 50)
	private String email;	// 이메일
	
	// @ColumnDefault("user")
	// DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. // ADMIN, USER, manager
	
	@CreationTimestamp // 시간이자동 입력 ex) 오라클 SYSDATE
	private Timestamp createDate;	// 작성일
	
	
	
	
	
	
}
