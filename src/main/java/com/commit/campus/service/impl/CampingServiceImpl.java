package com.commit.campus.service.impl;

import com.commit.campus.dto.CampingDTO;
import com.commit.campus.entity.Camping;
import com.commit.campus.repository.CampingRepository;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampingServiceImpl implements CampingService {

    @Autowired
    private CampingRepository campingRepository;

    // 모든 캠핑장 정보를 조회하는 메서드.
    @Override
    public List<CampingDTO> getAllCampings() {
        List<Camping> campings = campingRepository.findAll();
        return campings.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // 새로운 캠핑장을 생성하는 메서드
    @Override
    public CampingDTO createCamping(CampingDTO campingDTO) {
        Camping camping = convertToEntity(campingDTO);
        Camping savedCamping = campingRepository.save(camping);
        return convertToDTO(savedCamping);
    }

    // 캠핑장 정보를 페이지네이션과 정렬을 적용하여 조회하는 메서드
    @Override
    public List<CampingDTO> getCampings(String doName, String sigunguName, int page, int size, String sort, String order) {
        // 오프셋 계산
        int offset = page * size;

        // 캠핑 목록을 가져오는 쿼리 호출
        List<Camping> campings = campingRepository.findCampings(doName, sigunguName, offset, size);
        long total = campingRepository.countCampings(doName, sigunguName);

        // 캠핑 목록을 DTO로 변환하고 정렬 적용
        List<CampingDTO> campingDtos = campings.stream()
                .map(this::convertToDTO)
                .sorted(getComparator(sort, order)) // 정렬 적용
                .collect(Collectors.toList());

        return campingDtos;
    }

    // 정렬 기준에 따른 Comparator 생성
    private Comparator<CampingDTO> getComparator(String sort, String order) {
        Comparator<CampingDTO> comparator;
        if ("campName".equals(sort)) {
            comparator = Comparator.comparing(CampingDTO::getCampName);
        } else {
            comparator = Comparator.comparing(CampingDTO::getCreatedDate);
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return comparator;
    }

    // Entity를 DTO로 변환하는 메서드
    private CampingDTO convertToDTO(Camping camping) {
        CampingDTO dto = new CampingDTO();
        dto.setCampId(camping.getCampId());
        dto.setCampName(camping.getCampName());
        dto.setLineIntro(camping.getLineIntro());
        dto.setIntro(camping.getIntro());
        dto.setDoName(camping.getDoName());
        dto.setSigunguName(camping.getSigunguName());
        dto.setPostCode(camping.getPostCode());
        dto.setFeatureSummary(camping.getFeatureSummary());
        dto.setInduty(camping.getInduty());
        dto.setAddr(camping.getAddr());
        dto.setAddrDetails(camping.getAddrDetails());
        dto.setMapX(camping.getMapX());
        dto.setMapY(camping.getMapY());
        dto.setTel(camping.getTel());
        dto.setHomepage(camping.getHomepage());
        dto.setStaffCnt(camping.getStaffCnt());
        dto.setGeneralSiteCnt(camping.getGeneralSiteCnt());
        dto.setCarSiteCnt(camping.getCarSiteCnt());
        dto.setGlampingSiteCnt(camping.getGlampingSiteCnt());
        dto.setCaravanSiteCnt(camping.getCaravanSiteCnt());
        dto.setPersonalCaravanSiteCnt(camping.getPersonalCaravanSiteCnt());
        dto.setCreatedDate(camping.getCreatedDate());
        dto.setModifiedDate(camping.getModifiedDate());
        return dto;
    }

    // DTO를 Entity로 변환하는 메서드
    private Camping convertToEntity(CampingDTO dto) {
        Camping camping = new Camping();
        camping.setCampId(dto.getCampId());
        camping.setCampName(dto.getCampName());
        camping.setLineIntro(dto.getLineIntro());
        camping.setIntro(dto.getIntro());
        camping.setDoName(dto.getDoName());
        camping.setSigunguName(dto.getSigunguName());
        camping.setPostCode(dto.getPostCode());
        camping.setFeatureSummary(dto.getFeatureSummary());
        camping.setInduty(dto.getInduty());
        camping.setAddr(dto.getAddr());
        camping.setAddrDetails(dto.getAddrDetails());
        camping.setMapX(dto.getMapX());
        camping.setMapY(dto.getMapY());
        camping.setTel(dto.getTel());
        camping.setHomepage(dto.getHomepage());
        camping.setStaffCnt(dto.getStaffCnt());
        camping.setGeneralSiteCnt(dto.getGeneralSiteCnt());
        camping.setCarSiteCnt(dto.getCarSiteCnt());
        camping.setGlampingSiteCnt(dto.getGlampingSiteCnt());
        camping.setCaravanSiteCnt(dto.getCaravanSiteCnt());
        camping.setPersonalCaravanSiteCnt(dto.getPersonalCaravanSiteCnt());
        camping.setCreatedDate(dto.getCreatedDate());
        camping.setModifiedDate(dto.getModifiedDate());
        return camping;
    }
}

