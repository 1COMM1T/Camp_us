package com.commit.campus.view;

import com.commit.campus.entity.Camping;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "캠핑 뷰 모델")
public class CampingViewModel {

    @Schema(description = "캠핑장의 고유 ID")
    private Long campId;

    @Schema(description = "캠핑장 이름")
    private String campName;

    @Schema(description = "한줄 소개")
    private String lineIntro;

    @Schema(description = "캠핑장 특징")
    private String featureSummary;

    @Schema(description = "주소")
    private String addr;

    @Schema(description = "전화번호")
    private String tel;

    @Schema(description = "홈페이지")
    private String homepage;

    @Schema(description = "대표 이미지 URL")
    private String firstImageUrl;

    public CampingViewModel(Camping entity) {
        this.campId = entity.getCampId();
        this.campName = entity.getCampName();
        this.lineIntro = entity.getLineIntro();
        this.featureSummary = entity.getFeatureSummary();
        this.addr = entity.getAddr();
        this.tel = entity.getTel();
        this.homepage = entity.getHomepage();
        this.firstImageUrl = entity.getFirstImageUrl();
    }
}
