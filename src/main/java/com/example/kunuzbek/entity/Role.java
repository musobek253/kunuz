package com.example.kunuzbek.entity;

import com.example.kunuzbek.entity.enam.Huquq;
import com.example.kunuzbek.entity.temp.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Role extends AbsEntity  implements Serializable {

    @Column(nullable = false,unique = true)
    private String name;

    /*  user ni roli ixtiyoriy admin kiritadi */
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Huquq> huquqList;

}
