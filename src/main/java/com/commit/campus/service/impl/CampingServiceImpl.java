package com.commit.campus.service.impl;

import com.commit.campus.entity.Camping;
import com.commit.campus.repository.CampingRepository;
import com.commit.campus.service.CampingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors; // Collectors import 추가

@Service
public class CampingServiceImpl implements CampingService {

    @Autowired
    private CampingRepository campingRepository;

    @Override
    public List<Camping> getAllCampings() {
        List<Camping> campings = campingRepository.findAll();
        return campings;
    }

    @Override
    public Camping createCamping(Camping camping) {
        return campingRepository.save(camping);
    }

    @Override
    public List<Camping> getCampings(String doName, String sigunguName, int page, int size, String sort, String order) {
        int offset = page * size;
        List<Camping> campings = campingRepository.findCampings(doName, sigunguName, offset, size);
        return campings.stream()
                .sorted(getComparator(sort, order))
                .collect(Collectors.toList());
    }

    private Comparator<Camping> getComparator(String sort, String order) {
        Comparator<Camping> comparator;
        if ("campName".equals(sort)) {
            comparator = Comparator.comparing(Camping::getCampName);
        } else {
            comparator = Comparator.comparing(Camping::getCreatedDate);
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return comparator;
    }
}
