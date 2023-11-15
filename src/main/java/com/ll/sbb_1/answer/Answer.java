package com.ll.sbb_1.answer;

import com.ll.sbb_1.base.BaseEntity;
import com.ll.sbb_1.comment.Comment;
import com.ll.sbb_1.question.Question;
import com.ll.sbb_1.user.SiteUser;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Answer extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.REMOVE) // answer가 지워지면 해당 comment도 같이 지워지도록 함
    private List<Comment> commentList;

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;
}
