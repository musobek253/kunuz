package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment extends AbsEntity {

    @Column(nullable = false,columnDefinition = "text")
    private String text;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Post post;
}
