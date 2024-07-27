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

    @Schema(description = "캠핑장 위치")
    private String location;

    // 캠핑 엔티티에서 필요에 따라 필드를 더 추가

    public CampingViewModel(Camping entity) {
        this.campId = entity.getCampId();
        this.campName = entity.getCampName();
        this.location = entity.getAddr();
    }
}
