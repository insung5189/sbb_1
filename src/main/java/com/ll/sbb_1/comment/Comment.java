package com.ll.sbb_1.comment;

import com.ll.sbb_1.answer.Answer;
import com.ll.sbb_1.base.BaseEntity;
import com.ll.sbb_1.user.SiteUser;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Comment extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    private Answer answer;

    @ManyToMany
    Set<SiteUser> voter;
}
