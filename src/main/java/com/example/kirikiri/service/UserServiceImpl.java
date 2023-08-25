package com.example.kirikiri.service;

import com.example.kirikiri.domain.UserVO;
import com.example.kirikiri.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("user") @Primary
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void signup(UserVO userVO) {
        userDAO.setUserVO(userVO);
    }

    @Override
    public boolean login(UserVO userVO) {
        return (userDAO.getUserVO(userVO) != null) ? true : false;
    }

    @Override
    public UserVO getUserVOById(String userId) {
        return userDAO.getUserVOById(userId);
    }
    @Override
    public UserVO getInfo(String userId){return userDAO.userInfoById(userId);}

    @Override
    public Boolean duplicateCheckId(String userId) {
        return (userDAO.getUserVOById(userId) != null) ? true : false;
    }
    @Override
    public Boolean duplicateCheckNickname(String userNickname) {
        return (userDAO.getUserVOByNickname(userNickname) != null) ? true : false;
    }


    @Override
    public void updateInfo(UserVO userVO){userDAO.updateUserInfo(userVO);}

    @Override
    public void deleteInfo(String userId){userDAO.deleteUser(userId);}

    @Override
    public UserVO findById(String userEmail) {
        return userDAO.findById(userEmail);
    }

    @Override
    public UserVO getUser(String userId){
        return userDAO.findId(userId);
    }

    @Override
    public void updatePw(UserVO userVO) {
        userDAO.setUserPw(userVO);
    }

    @Override
    public String getProfileByUserId(String userId) {
        return userDAO.getUserProfileByUserId(userId);
    }
}
