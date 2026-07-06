package com.embarkX.url_shortener.repositories;

import com.embarkX.url_shortener.models.click_event;
import com.embarkX.url_shortener.models.url_mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<click_event,Long> {
    List<click_event>findByUrlMappingAndClickDateBetween(url_mapping urlMapping,
                                                         LocalDateTime start,
                                                         LocalDateTime end);
    List<click_event>findByUrlMappingInAndClickDateBetween(List<url_mapping> urlMappings,
                                                         LocalDate start,
                                                         LocalDate end);



}
