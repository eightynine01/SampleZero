package com.sample.board.repository;

import com.sample.board.domain.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TaeHwan
 * 2017. 11. 6. AM 10:12
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    Page<CategoryEntity> findAllByOrderByIdDesc(Pageable pageable);
}
