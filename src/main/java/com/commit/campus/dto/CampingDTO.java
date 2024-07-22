package com.commit.campus.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
public class CampingDTO {
    private Long campId;
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
    private Integer staffCnt;

    private Integer bookmarkCount; // 찜 횟수
    private Double totalRating; // 총 평점
    private Integer countRating; // 평점 개수
    private LocalDateTime createdDate; // 등록일
    private LocalDateTime modifiedDate; // 수정일

    // 필터링 및 정렬 파라미터
    private String sortBy;
    private int page = 0;
    private int size = 10;
}
