package com.example.kirikiri.repository;

import com.example.kirikiri.domain.BoardDTO;
import com.example.kirikiri.domain.BoardVO;
import com.example.kirikiri.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    public Integer getCountAll() {
        return boardMapper.countAll();
    }
    public Integer getCountCategory(BoardVO boardVO) {
        return boardMapper.countCategory(boardVO);
    }
    public Integer getCountDetailCategory(BoardVO boardVO) {
        return boardMapper.countDetailCategory(boardVO);
    }
    public Integer getCountSearchResult(String keyword) {
        return boardMapper.countSearch(keyword);
    }
    public Integer getCountCategorySearchResult(BoardDTO boardDTO){
        return boardMapper.countCategorySearch(boardDTO);
    }
    public Integer getCountByUser(String boardId){
        return boardMapper.countByUser(boardId);
    }

    public List<BoardDTO> getListAll(Integer page){
        return boardMapper.selectAll(page);
    }
    public List<BoardVO> getListAllOrderByLikes(Integer page){
        return boardMapper.selectAllByLikes(page);
    }
    public List<BoardVO> getListAllOrderByViews(Integer page){
        return boardMapper.selectAllByViews(page);
    }

    public List<BoardVO> getListByCategory(BoardDTO boardDTO){
        return boardMapper.selectCategory(boardDTO);
    }
    public List<BoardVO> getListByCategoryOrderByLikes(BoardDTO boardDTO){
        return boardMapper.selectCategoryByLikes(boardDTO);
    }
    public List<BoardVO> getListByCategoryOrderByViews(BoardDTO boardDTO){
        return boardMapper.selectCategoryByViews(boardDTO);
    }

    public List<BoardVO> getListByDetailCategory(BoardDTO boardDTO){
        return boardMapper.selectDetailCategory(boardDTO);
    }
    public List<BoardVO> getListByDetailCategoryOrderByLikes(BoardDTO boardDTO){
        return boardMapper.selectDetailCategoryByLikes(boardDTO);
    }
    public List<BoardVO> getListByDetailCategoryOrderByViews(BoardDTO boardDTO){
        return boardMapper.selectDetailCategoryByViews(boardDTO);
    }

    public void add(BoardVO boardVO){
        boardMapper.insert(boardVO);
    }

    public void delete(Long boardId){
        boardMapper.delete(boardId);
    }

    public void setBoardVO(BoardVO boardVO){
        boardMapper.update(boardVO);
    }

    public void updateBoardView(Long boardId) {
        boardMapper.updateView(boardId);
    }

    public List<BoardVO> getFivePosts(String categoryName) {
        return boardMapper.selectFivePosts(categoryName);
    }
    public List<BoardVO> getFivePopularPosts() {
        List<BoardVO> list = boardMapper.selectPopularPosts();
        List<BoardVO> addList = new ArrayList<BoardVO>();
        for(BoardVO boardVO : list) {
            String newBoardTitle = "";
            if(boardVO.getBoardTitle().length() > 10) {
                newBoardTitle = boardVO.getBoardTitle().substring(0, 10) + "...";
                boardVO.setBoardTitle(newBoardTitle);
            }
            addList.add(boardVO);
        }
        return addList;
    }
    public List<BoardDTO> getFivePopularWriters() {
        List<BoardDTO> list = boardMapper.selectPopularWriters();
        List<BoardDTO> addList = new ArrayList<BoardDTO>();
        int size = 5;
        if(list.size() < 5) {
            size = list.size();
        }
        for(int i = 0; i < size; i++) {
            addList.add(boardMapper.selectPopularWriters().get(i));
        }
        return addList;
    }

    public BoardVO findById(Long boardId){
        return boardMapper.select(boardId);
    }

    public List<BoardVO> writtenBoard(String userId, Integer page){
        return boardMapper.selectWritten(userId, page);
    }
    public List<BoardVO> searchByTitle(BoardDTO boardDTO) {
        return boardMapper.search(boardDTO);
    }
    public List<BoardVO> searchByTitleByCategory(BoardDTO boardDTO) {
        return boardMapper.searchByCategory(boardDTO);
    }
}
