package com.commit.campus.controller;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CampingController {
    @Autowired
    private CampingService campingService;

    @GetMapping("/v1/campings")
    public List<CampingDTO> getCampings(
            @RequestParam String doName,
            @RequestParam(required = false) String sigunguName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sort,
            @RequestParam(defaultValue = "desc") String order) {
        return campingService.getCampings(doName, sigunguName, page, size, sort, order);
    }
}
