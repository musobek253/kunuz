package com.example.kunuzbek.pyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotNull(message = "fullname bo'sh bo'lmaydi")
    private String fullName;

    @NotNull(message = "username bo'sh bo'lmaydi")
    private String username;

    @NotNull(message = "parol bo'sh bo'lmaydi")
    private String password;

    @NotNull(message = "parol bo'sh bo'lmaydi")
    private String prePassword;

}
