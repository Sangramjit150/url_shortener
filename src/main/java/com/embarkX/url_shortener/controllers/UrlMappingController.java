package com.embarkX.url_shortener.controllers;

import com.embarkX.url_shortener.dtos.ClickEventDTO;
import com.embarkX.url_shortener.dtos.UrlMappingDTO;
import com.embarkX.url_shortener.models.User;
import com.embarkX.url_shortener.services.UrlMappingService;
import com.embarkX.url_shortener.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @GetMapping ("/myUrls")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UrlMappingDTO>>getUserUrls(Principal principal){
        User user=userService.findByUserName(principal.getName());
        List<UrlMappingDTO>urls=urlMappingService.getUrlsByUser(user);
        return ResponseEntity.ok(urls);
    }

    @GetMapping("/analytics/{shortUrl}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ClickEventDTO>>getUrlAnalytics(@PathVariable String shortUrl,
                                                              @RequestParam("startDate") String startDate,
                                                              @RequestParam("endDate") String endDate){
        DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime start=LocalDateTime.parse(startDate,formatter);
        LocalDateTime end=LocalDateTime.parse(endDate,formatter);
        List<ClickEventDTO>clickEventDTOS =urlMappingService.getClickEventsByDate(shortUrl,start,end);

        return ResponseEntity.ok(clickEventDTOS);
    }

    @GetMapping("/totalClicks")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<LocalDate,Long>>getTotalClicksByDate(Principal principal,
                                                                   @RequestParam("startDate") String startDate,
                                                                   @RequestParam("endDate") String endDate){
        DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE;
        User user=userService.findByUserName(principal.getName());
        LocalDate start=LocalDate.parse(startDate,formatter);
        LocalDate end=LocalDate.parse(endDate,formatter);
        Map<LocalDate,Long>totalClicks =urlMappingService.getTotalClicksByUserAndDate(user,start,end);

        return ResponseEntity.ok(totalClicks);
    }
}
