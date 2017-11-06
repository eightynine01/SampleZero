package com.sample.board.service;

import com.sample.board.domain.BoardEntity;
import com.sample.board.domain.CategoryEntity;
import com.sample.board.repository.BoardRepository;
import com.sample.board.repository.CategoryRepository;
import com.sample.board.repository.ReplyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 11:10
 */
@Service
@Transactional
public class BoardService{
    private final Logger logger = LoggerFactory.getLogger(BoardService.class);

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final ReplyRepository replyRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, CategoryRepository categoryRepository, ReplyRepository replyRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
        this.replyRepository = replyRepository;
    }

    public void createBoard(BoardEntity newBoardEntity){
        logger.info("게시물 생성 : {}", newBoardEntity);
        boardRepository.save(newBoardEntity);
    }

    public void createCategory(CategoryEntity newCategoryEntity){

        logger.info("카테고리 생성 : {}", newCategoryEntity.getName());
        categoryRepository.save(newCategoryEntity);
    }

    public Page<CategoryEntity> showCategoryPaging(int page){
        return categoryRepository.findAllByOrderByIdDesc(new PageRequest(page, 5));
    }
}
