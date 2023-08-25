package com.example.kirikiri.service;

import com.example.kirikiri.domain.LikeVO;

public interface LikeService {
    public Long getLikes(Long boardId);
    public LikeVO getLikeVO(LikeVO likeVO);
    public void addLike(LikeVO likeVO);
    public void setLike(LikeVO likeVO);
    public void deleteByLikeId(Long likeId);
    public void deleteByBoardId(Long boardId);
}
