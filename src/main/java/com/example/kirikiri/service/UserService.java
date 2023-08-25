package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;

public interface UserService {
    public void signup(UserVO userVO);

    public boolean login(UserVO userVO);

    public UserVO getUserVOById(String userId);
    // 회원정보 출력
    public UserVO getInfo(String userId);

    public Boolean duplicateCheckId(String userId);
    public Boolean duplicateCheckNickname(String userNickname);

    // 회원정보 수정
    public void updateInfo(UserVO userVO);

    // 회원정보 삭제
    public void deleteInfo(String userId);

    // Email로 데이터 가져오기
    public UserVO findById(String userEmail);

    // ID로 데이터 가져오기
    public UserVO getUser(String userId);

    // 비밀번호 재설정
    public void updatePw(UserVO userVO);

    // 유저 아이디로 프로필 찾기
    public String getProfileByUserId(String userId);
}

