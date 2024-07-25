package com.commit.campus.controller;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampingController {
    @Autowired
    private CampingService campingService;

    // API 요청을 받아 서비스 메서드를 호출하고 결과를 반환
    @GetMapping("/v1/campings")
    public CampingDTO getCampings(
            @RequestParam String doName,
            @RequestParam(required = false) String sigunguName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdDate") String sort,  // 정렬 필드 기본값을 등록순으로 설정
            @RequestParam(defaultValue = "desc") String order) {      // 정렬 순서 기본값을 내림차순으로 설정
        return campingService.getCampings(doName, sigunguName, page, size, sort, order);
    }
}

