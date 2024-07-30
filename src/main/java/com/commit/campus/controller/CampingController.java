package com.commit.campus.controller;

import com.commit.campus.entity.Camping;
import com.commit.campus.service.CampingService;
import com.commit.campus.view.CampingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Camping API", description = "캠핑장 관련 엔드포인트")
public class CampingController {

    @Autowired
    private CampingService campingService;

    @GetMapping("/v1/campings")
    @Operation(summary = "캠핑장 리스트 조회", description = "특정 도와 시군구의 캠핑장 리스트를 페이지네이션과 정렬을 적용하여 조회합니다.")
    public List<CampingViewModel> getCampings(
            @RequestParam(required = false) @Parameter(description = "도의 이름") String doName,
            @RequestParam(required = false) @Parameter(description = "시군구의 이름") String sigunguName,
            @RequestParam(defaultValue = "0") @Parameter(description = "페이지 번호", example = "0") int page,
            @RequestParam(defaultValue = "10") @Parameter(description = "페이지 크기", example = "10") int size,
            @RequestParam(defaultValue = "campId") @Parameter(description = "정렬 필드", example = "campId") String sort,
            @RequestParam(defaultValue = "desc") @Parameter(description = "정렬 순서", example = "desc") String order) {

        List<Camping> campings = campingService.getCampings(doName, sigunguName, page, size, sort, order);
        return campings.stream()
                .map(CampingViewModel::new) // 엔티티를 ViewModel로 변환
                .collect(Collectors.toList());
    }
}
