package com.example.kirikiri.mapper;

import com.example.kirikiri.domain.LikeVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    public Long selectSumOfCount(Long boardId);
    public LikeVO selectLikeVOByUserIdBoardId(LikeVO likeVO);
    public void insert(LikeVO likeVO);
    public void update(LikeVO likeVO);
    public void delete(Long likeId);
    public void deleteAll(Long boardId);
}
