package com.sample.board.repository;

import com.sample.board.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 11:10
 */
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
}
