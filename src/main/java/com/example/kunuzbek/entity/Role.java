package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends AbsEntity {

    @Column(nullable = false,unique = true)
    private String name;
    /*  user ni roli ixtiyoriy admin kiritadi */
    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Huquq> huquqList;

}
