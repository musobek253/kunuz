package com.example.kunuzbek.pyload;

import com.example.kunuzbek.entity.enam.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank(message = "Nomi bo'sh bo'lmasligi kerak")
    private String name;

    @NotEmpty(message = "list bo'sh bo'lmasligi kerak")
    private List<Huquq> huquqList;


}
