package com.commit.campus.service.impl;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.entity.Camping;
import com.commit.campus.repository.CampingRepository;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampingServiceImpl implements CampingService {

    private final CampingRepository campingRepository;

    @Autowired
    public CampingServiceImpl(CampingRepository campingRepository) {
        this.campingRepository = campingRepository;
    }

    @Override
    public Optional<CampingDTO> findById(Long campId) {
        return campingRepository.findById(campId).map(this::toDTO);
    }

    @Override
    public Page<CampingDTO> getCampingsWithQuery(CampingDTO filter, Pageable pageable) {
        Page<Camping> campings = campingRepository.findByFilters(
                filter.getDoName(),
                filter.getSigunguName(),
                filter.getInduty(),
                pageable);

        return campings.map(this::toDTO);
    }

    private CampingDTO toDTO(Camping camping) {
        return CampingDTO.builder()
                .campId(camping.getCampId())
                .campName(camping.getCampName())
                .lineIntro(camping.getLineIntro())
                .intro(camping.getIntro())
                .doName(camping.getDoName())
                .sigunguName(camping.getSigunguName())
                .postCode(camping.getPostCode())
                .featureSummary(camping.getFeatureSummary())
                .induty(camping.getInduty())
                .addr(camping.getAddr())
                .addrDetails(camping.getAddrDetails())
                .mapX(camping.getMapX())
                .mapY(camping.getMapY())
                .tel(camping.getTel())
                .homepage(camping.getHomepage())
                .staffCnt(camping.getStaffCnt())
                .createdDate(camping.getCreatedDate())
                .modifiedDate(camping.getModifiedDate())
                .build();
    }
}

