package com.ll.sbb_1.answer;

import com.ll.sbb_1.comment.Comment;
import com.ll.sbb_1.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE) // answer가 지워지면 해당 comment도 같이 지워지도록 함
    private List<Comment> commentList;

    @ManyToOne
    private Question question;
}
