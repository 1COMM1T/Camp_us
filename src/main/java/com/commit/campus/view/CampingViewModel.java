package com.commit.campus.view;

import com.commit.campus.entity.Camping;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Camping view model")
public class CampingViewModel {

    @Schema(description = "The unique ID of the camping site")
    private Long campId;

    @Schema(description = "The name of the camping site")
    private String campName;

    @Schema(description = "The location of the camping site")
    private String location;

    // 캠핑 엔티티에서 필요에 따라 필드를 더 추가

    public CampingViewModel(Camping entity) {
        this.campId = entity.getCampId();
        this.campName = entity.getCampName();
        this.location = entity.getAddr();
    }
}
