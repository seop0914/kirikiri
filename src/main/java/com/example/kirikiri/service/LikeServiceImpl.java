package com.example.kirikiri.service;

import com.example.kirikiri.domain.LikeVO;
import com.example.kirikiri.repository.LikeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("like") @Primary
public class LikeServiceImpl implements LikeService {
    private final LikeDAO likeDAO;

    @Override
    public Long getLikes(Long boardId) {
        return likeDAO.getLikes(boardId);
    }

    @Override
    public LikeVO getLikeVO(LikeVO likeVO) {
        return likeDAO.getLikeVO(likeVO);
    }

    @Override
    public void addLike(LikeVO likeVO) {
        likeDAO.addLike(likeVO);
    }

    @Override
    public void setLike(LikeVO likeVO) {
        likeDAO.setLike(likeVO);
    }

    @Override
    public void deleteByLikeId(Long likeId) {
        likeDAO.deleteByLikeId(likeId);
    }

    @Override
    public void deleteByBoardId(Long boardId) {
        likeDAO.deleteByBoardId(boardId);
    }
}
