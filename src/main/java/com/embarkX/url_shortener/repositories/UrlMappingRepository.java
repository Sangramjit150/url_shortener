package com.embarkX.url_shortener.repositories;

import com.embarkX.url_shortener.models.User;
import com.embarkX.url_shortener.models.url_mapping;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UrlMappingRepository extends JpaRepository <url_mapping,Long>{
    url_mapping findByShortUrl(String shortUrl);
    List<url_mapping>findByUser(User user);

}
