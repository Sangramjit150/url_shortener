package com.embarkX.url_shortener.controllers;

import com.embarkX.url_shortener.dtos.UrlMappingDTO;
import com.embarkX.url_shortener.models.User;
import com.embarkX.url_shortener.services.UrlMappingService;
import com.embarkX.url_shortener.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/urls")
@AllArgsConstructor
public class UrlMappingController {

    private UrlMappingService urlMappingService;
    private UserService userService;

    @PostMapping("/shorten")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UrlMappingDTO>createShortUrl(@RequestBody Map<String,String>request, Principal principal){
        String originalUrl=request.get("originalUrl");
        User user= userService.findByUserName(principal.getName());
        System.out.println(principal.getName());

        UrlMappingDTO urlMappingDTO =urlMappingService.createShortUrl(originalUrl,user);
        return ResponseEntity.ok(urlMappingDTO);
    }

    @PostMapping("/myUrls")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UrlMappingDTO>>getUserUrls(Principal principal){
        User user=userService.findByUserName(principal.getName());
        List<UrlMappingDTO>urls=urlMappingService.getUrlsByUser(user);
        return ResponseEntity.ok(urls);
    }
}
