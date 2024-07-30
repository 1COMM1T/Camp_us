package com.commit.campus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CampingDTO {

    private Long campId;        // 캠핑 pk contentId를 가져와 사용예정
    private String campName;
    private String lineIntro;
    private String intro;
    private String doName;
    private String sigunguName;
    private String postCode;
    private String featureSummary;
    private String induty;
    private String addr;
    private String addrDetails;
    private Double mapX;
    private Double mapY;
    private String tel;
    private String homepage;
    private int staffCnt;
    private int generalSiteCnt;
    private int carSiteCnt;
    private int glampingSiteCnt;
    private int caravanSiteCnt;
    private int personalCaravanSiteCnt;
    private int contentId;

    // 추가된 필드
    private String supportFacilities; // 부대시설(편의시설)
    private String outdoorActivities; // 주변시설
    private String petAccess; // 반려동물 출입 여부
    private String rentalGearList; // 대여 장비 목록
    private String operationDay; // 운영일
    private String firstImageUrl; // 대표이미지

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}