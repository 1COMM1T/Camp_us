package com.commit.campus.service;

import com.commit.campus.dto.CampingDTO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CampingService {
    Optional<CampingDTO> findById(Long campId);
    Page<CampingDTO> getCampingsWithQuery(CampingDTO filter, Pageable pageable);
}
