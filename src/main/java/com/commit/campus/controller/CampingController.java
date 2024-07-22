package com.commit.campus.controller;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/v1/campings")
public class CampingController {
    private final CampingService campingService;

    @Autowired
    public CampingController(CampingService campingService) {
        this.campingService = campingService;
    }

    @GetMapping
    public ResponseEntity<Page<CampingDTO>> getCampings(CampingDTO filter) {
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());

        Page<CampingDTO> campings = campingService.getCampingsWithQuery(filter, pageable);

        return ResponseEntity.ok(campings);
    }
}
