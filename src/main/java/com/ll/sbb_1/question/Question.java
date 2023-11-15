package com.ll.sbb_1.question;

import com.ll.sbb_1.answer.Answer;
import com.ll.sbb_1.base.BaseEntity;
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
public class Question extends BaseEntity {

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // question이 지워지면 해당 answer도 같이 지워지도록 함.
    private List<Answer> answerList;

}
