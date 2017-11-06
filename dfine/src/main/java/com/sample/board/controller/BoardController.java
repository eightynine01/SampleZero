package com.sample.board.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.sample.board.domain.BoardDto;
import com.sample.board.domain.BoardEntity;
import com.sample.board.domain.CategoryDto;
import com.sample.board.domain.CategoryEntity;
import com.sample.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 11:11
 */
@Controller
@RequestMapping("/board")
public class BoardController {
    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/add")
    public HttpEntity<?> createBoard(BoardDto newBoardDto){
        logger.info("새 게시물 DTO : {}", newBoardDto);
        boardService.createBoard(new BoardEntity(newBoardDto));
        newBoardDto.add(linkTo(methodOn(BoardController.class).createBoard(newBoardDto)).withSelfRel());
        return new ResponseEntity<>(newBoardDto, HttpStatus.OK);
    }

    private CategoryDto categoryDtoInstance(){
        return new CategoryDto();
    }

    @PostMapping("/addCategory")
    public HttpEntity<?> createCategory(CategoryEntity newCategoryEntity){
        logger.info("새 카테고리 DTO : {}", newCategoryEntity.getName());
        boardService.createCategory(newCategoryEntity);
        CategoryDto categoryDto = categoryDtoInstance();
        categoryDto.add(linkTo(methodOn(BoardController.class).createCategory(newCategoryEntity)).withSelfRel());
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping("/showCategory/{page}")
    public HttpEntity<?> showCategory(int page){
        logger.info("요청한 카테고리 Entity : {}", page);
        Page<CategoryEntity> categoryEntities = boardService.showCategoryPaging(page);
        for(CategoryEntity categoryEntity : categoryEntities)
            logger.info("카테고리 목록 : {}", categoryEntity.getName());
        CategoryDto categoryDto = categoryDtoInstance();
        categoryDto.add(linkTo(methodOn(BoardController.class).showCategory(page)).withSelfRel());
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
}
