package com.ll.sbb_1.comment;

import com.ll.sbb_1.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    private Answer answer;

}
