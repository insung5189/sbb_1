package com.ll.sbb_1.comment;

import com.ll.sbb_1.DataNotFoundException;
import com.ll.sbb_1.answer.Answer;
import com.ll.sbb_1.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getList() {
        return this.commentRepository.findAll();
    }

    public Comment getComment(Integer id) {// Integer 로 타입이 들어오면 null 값도 허용해줄 수 있음
        Optional<Comment> comment = this.commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        } else {
            throw new DataNotFoundException("comment not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    public Comment create(Answer answer, String comment, SiteUser author) {
        Comment c1 = new Comment();
        c1.setComment(comment);
        c1.setCreateDate(LocalDateTime.now());
        c1.setAnswer(answer);
        c1.setAuthor(author);
        this.commentRepository.save(c1);
        return c1;
    }
    public void modify(Comment comment, String content) {
        comment.setComment(content);
        comment.setModifyDate(LocalDateTime.now());
        this.commentRepository.save(comment);
    }
    public void delete(Comment comment) {
        this.commentRepository.delete(comment);
    }
    public void vote(Comment comment, SiteUser siteUser) {
        comment.getVoter().add(siteUser);
        this.commentRepository.save(comment);
    }

}
