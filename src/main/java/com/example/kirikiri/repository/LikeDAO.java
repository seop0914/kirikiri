package com.example.kirikiri.repository;

import com.example.kirikiri.domain.LikeVO;
import com.example.kirikiri.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;

    public Long getLikes(Long boardId) {
        return likeMapper.selectSumOfCount(boardId);
    }
    public LikeVO getLikeVO(LikeVO likeVO) {
        return likeMapper.selectLikeVOByUserIdBoardId(likeVO);
    }
    public void addLike(LikeVO likeVO) {
        likeMapper.insert(likeVO);
    }
    public void setLike(LikeVO likeVO) {
        likeMapper.update(likeVO);
    }
    public void deleteByLikeId(Long likeId) {
        likeMapper.delete(likeId);
    }
    public void deleteByBoardId(Long boardId) {
        likeMapper.deleteAll(boardId);
    }
}
