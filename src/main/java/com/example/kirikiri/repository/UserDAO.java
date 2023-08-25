package com.example.kirikiri.repository;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public void setUserVO(UserVO userVO) {
        userMapper.insert(userVO);
    }

    public UserVO getUserVO(UserVO userVO) {
        return userMapper.select(userVO);
    }

    public UserVO getUserVOById(String userId) {
        return userMapper.selectById(userId);
    }

    public UserVO getUserVOByNickname(String userNickname) {
        return userMapper.selectById(userNickname);
    }

    public UserVO userInfoById(String userId){
        return userMapper.selectUser(userId);
    }

    public void updateUserInfo(UserVO userVO){userMapper.updateUser(userVO);}

    public void deleteUser(String userId){userMapper.deleteUser(userId);}

    // Email로 데이터 가져오기
    public UserVO findById(String userEmail){
        return userMapper.selectUserEmail(userEmail);
    }

    // ID로 데이터 가져오기(id넣기)
    public UserVO findId(String userId) { return userMapper.selectUserId(userId);}

    // 비밀번호 재설정
    public void setUserPw(UserVO userVO){
        userMapper.updatePw(userVO);
    }
    
    // 유저 아이디로 프로필 찾기
    public String getUserProfileByUserId(String userId) {
        return userMapper.selectProfileByUserId(userId);
    }
}
