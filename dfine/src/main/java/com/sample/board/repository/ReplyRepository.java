package com.sample.board.repository;

import com.sample.board.domain.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TaeHwan
 * 2017. 11. 6. AM 10:13
 */
@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long>{
}
