package com.embarkX.url_shortener.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class click_event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate clickDate;

    @ManyToOne
    @JoinColumn(name = "url_mapping_id")
    private url_mapping urlMapping;

}
