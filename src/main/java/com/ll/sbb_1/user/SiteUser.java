package com.ll.sbb_1.user;

import com.ll.sbb_1.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class SiteUser extends BaseEntity {

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
}