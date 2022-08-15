package com.example.kunuzbek.entity.temp;

import com.example.kunuzbek.entity.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@MappedSuperclass
public abstract class  AbsEntity {

    @Id
    @GeneratedValue( strategy  = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateAt;

    @JoinColumn(updatable = false)
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdUser;


    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User updateUser;





}
