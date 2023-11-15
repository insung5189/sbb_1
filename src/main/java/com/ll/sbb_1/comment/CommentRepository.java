package com.ll.sbb_1.comment;

import com.ll.sbb_1.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}