package com.commit.campus.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Camping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
