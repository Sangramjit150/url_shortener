package com.embarkX.url_shortener.services;

import com.embarkX.url_shortener.dtos.UrlMappingDTO;
import com.embarkX.url_shortener.models.User;
import com.embarkX.url_shortener.models.url_mapping;
import com.embarkX.url_shortener.repositories.UrlMappingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UrlMappingService {
    private UrlMappingRepository urlMappingRepository;
    public UrlMappingDTO createShortUrl(String originalUrl, User user) {
        String shortUrl=generateShortUrl();
        url_mapping urlMapping=new url_mapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setUser(user);
        urlMapping.setCreatedDate(LocalDateTime.now());

        url_mapping savedUrl=urlMappingRepository.save(urlMapping);
        return convertToDto(savedUrl);

    }

    private UrlMappingDTO convertToDto(url_mapping urlMapping){
        UrlMappingDTO urlMappingDTO=new UrlMappingDTO();
        urlMappingDTO.setId(urlMapping.getId());
        urlMappingDTO.setOriginalUrl(urlMapping.getOriginalUrl());
        urlMappingDTO.setShortUrl(urlMapping.getShortUrl());
        urlMappingDTO.setClickCount(urlMapping.getClickCount());
        urlMappingDTO.setCreatedDate(urlMapping.getCreatedDate());
        urlMappingDTO.setUsername(urlMapping.getUser().getUsername());
        System.out.println("Current User"+urlMapping.getUser().getUsername());
        return urlMappingDTO;
    }
    private String generateShortUrl() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder shortUrl=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<8;i++){
            shortUrl.append(str.charAt(random.nextInt(str.length())));
        }
        return shortUrl.toString();
    }

    public List<UrlMappingDTO> getUrlsByUser(User user) {
        return urlMappingRepository.findByUser(user).stream()
                .map(this::convertToDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
