package com.embarkX.url_shortener.Jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data

@AllArgsConstructor
public class JwtAuthenticationResponse {

    private String token;
}
