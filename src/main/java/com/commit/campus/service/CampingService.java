package com.commit.campus.service;

import com.commit.campus.entity.Camping;

import java.util.List;

public interface CampingService {
    List<Camping> getAllCampings();  // 모든 캠핑장 정보를 조회
    Camping createCamping(Camping camping);  // 새로운 캠핑장을 생성

    // 페이지네이션과 정렬을 적용하여 캠핑장 정보를 조회하는 메서드
    List<Camping> getCampings(String doName, String sigunguName, int page, int size, String sort, String order);
}
