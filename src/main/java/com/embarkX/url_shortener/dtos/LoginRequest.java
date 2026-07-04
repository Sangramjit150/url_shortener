package com.embarkX.url_shortener.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class LoginRequest {
    private String username;
    private String password;
}
