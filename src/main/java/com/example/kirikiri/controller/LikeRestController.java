package com.example.kirikiri.controller;

import com.example.kirikiri.domain.LikeVO;
import com.example.kirikiri.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class LikeRestController {
    private final LikeService likeService;

    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = null;
        userId = (String) session.getAttribute("userId");
        return userId;
    }

    @GetMapping("/like/add")
    public Boolean addLike(LikeVO likeVO, HttpServletRequest request) {
        if(getSession(request) != null) likeService.addLike(likeVO);
        else return false;

        return true;
    }
    @GetMapping("/like/update")
    public Boolean updateLike(LikeVO likeVO, HttpServletRequest request) {
        if(getSession(request) != null) likeService.setLike(likeVO);
        else return false;

        return true;
    }
    @GetMapping("/like/delete")
    public Boolean deleteLike(LikeVO likeVO, HttpServletRequest request) {
        likeVO = likeService.getLikeVO(likeVO);
        if(getSession(request) != null) likeService.deleteByLikeId(likeVO.getLikeId());
        else return false;

        return true;
    }
}
