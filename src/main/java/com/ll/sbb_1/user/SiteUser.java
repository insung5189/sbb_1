package com.ll.sbb_1.user;

import com.ll.sbb_1.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class SiteUser extends BaseEntity {

    @Column(unique = true)
    private String username; // 유저아이디

    @Column(name = "password")
    private String password;

    @Column(unique = false)
    private String email;

    @Column(name = "role", columnDefinition = "ENUM('ADMIN','AUTHOR','MEMBER','SUPERADMIN','USER')")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @LastModifiedDate
    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "nick_name")
    private String nickName; // 사용자 닉네임

    @Column(name = "first_name")
    private String firstName; // 사용자 본명 중 이름

    @Column(name = "last_name")
    private String lastName; // 사용자 본명 중 성

    @Column(name = "phone")
    private String phone; // 사용자 연락처

    @Column(name = "birth_date")
    private LocalDate birthDate; // 사용자 생년월일

    @Column(name = "img_file_path")
    private String imgFilePath; // 사용자 프로필 이미지 파일 경로

    @Column(name = "img_file_name")
    private String imgFileName; // 사용자 프로필 이미지 파일 이름

    @Column(name = "gender")
    private Boolean gender; // 사용자 성별 (true : 남자 / false : 여자)

    // 소셜로그인 기능을 위한 프로바이더와 프로바이더_id 칼럼 추가
    @Column(name = "provider")
    private String provider;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "is_active")
    private Boolean isActive = true; // 회원 활성 여부를 나타내는 속성

    public void deactivate() {
        this.isActive = false;
    }

    public boolean isActive() {
        return this.isActive != null && this.isActive; // null 체크 후 isActive가 true인지 확인하여 반환
    }
}