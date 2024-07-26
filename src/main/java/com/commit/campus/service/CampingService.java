package com.commit.campus.service;

import com.commit.campus.dto.CampingDTO;

import java.util.List;

public interface CampingService {
    List<CampingDTO> getAllCampings();  // 모든 캠핑장 정보를 조회하는 메서드
    CampingDTO createCamping(CampingDTO campingDTO);  // 새로운 캠핑장을 생성하는 메서드

    // 오프셋 기반 페이지네이션을 사용하여 캠핑 정보를 가져오는 메서드.
    List<CampingDTO> getCampings(String doName, String sigunguName, int page, int size, String sort, String order);
}
