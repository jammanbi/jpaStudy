package com.jpaStudy.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 회원 엔티티
 */
@Entity
@Data
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    /** 비밀번호 **/
    @Column(name="password", nullable = false)
    private String pwd;

    /** 이름 **/
    @Column(name="name")
    private String name;

    /** 성별 **/
    @Column(name="gender")
    private String gender;

    /** 생년월일 **/
    @Column(name="birth_day", length = 8)
    private String birthDay;

    /** 휴대폰번호 **/
    @Column(name="phone_number", length = 13)
    private String phoneNumber;

    /** 프로필이미지 **/
    @Column(name="profile_image", length = 100)
    private String profileImage;

    /** 가입일 **/
    @Column(name="create_date")
    private LocalDateTime createDate;
}
