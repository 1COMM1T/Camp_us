package com.commit.campus.controller;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation; // Swagger 어노테이션을 사용하기 위한 import
import io.swagger.v3.oas.annotations.Parameter; // Swagger 어노테이션을 사용하기 위한 import
import io.swagger.v3.oas.annotations.tags.Tag;  // Swagger 어노테이션을 사용하기 위한 import

import java.util.List;

@RestController
@Tag(name = "Camping API", description = "캠핑장 관련 엔드포인트") // API 엔드포인트에 대한 설명 제공
public class CampingController {
    @Autowired
    private CampingService campingService;

    @GetMapping("/v1/campings")
    @Operation(summary = "캠핑장 리스트 조회", description = "특정 도와 시군구의 캠핑장 리스트를 페이지네이션과 정렬을 적용하여 조회합니다.") // API 메서드에 대한 설명 제공
    public List<CampingDTO> getCampings(
            @RequestParam @Parameter(description = "도의 이름", required = true) String doName,  // 파라미터에 대한 설명 제공
            @RequestParam(required = false) @Parameter(description = "시군구의 이름") String sigunguName,
            @RequestParam(defaultValue = "0") @Parameter(description = "페이지 번호", example = "0") int page,
            @RequestParam(defaultValue = "10") @Parameter(description = "페이지 크기", example = "10") int size,
            @RequestParam(defaultValue = "createdDate") @Parameter(description = "정렬 필드", example = "createdDate") String sort,
            @RequestParam(defaultValue = "desc") @Parameter(description = "정렬 순서", example = "desc") String order) {
        return campingService.getCampings(doName, sigunguName, page, size, sort, order);
    }
}

