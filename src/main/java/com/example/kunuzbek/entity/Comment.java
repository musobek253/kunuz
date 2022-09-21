package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Comment extends AbsEntity implements Serializable {

    @Column(nullable = false,columnDefinition = "text")
    private String text;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Post post;
}
