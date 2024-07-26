package com.commit.campus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "camping")
@Getter
@Setter
@ToString
public class Camping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campId")
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
    private int staffCnt;
    private int generalSiteCnt;
    private int carSiteCnt;
    private int glampingSiteCnt;
    private int caravanSiteCnt;
    private int personalCaravanSiteCnt;
    private int contentId;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    // 추가된 항목들
    private String supportFacilities; // 부대시설(편의시설)
    private String outdoorActivities; // 주변시설

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
