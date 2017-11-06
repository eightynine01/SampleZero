package com.sample.chat.repository;

import com.sample.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TaeHwan
 * 2017. 11. 5. PM 5:54
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
}
