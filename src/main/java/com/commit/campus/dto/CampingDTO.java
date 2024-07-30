package com.commit.campus.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

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



    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
