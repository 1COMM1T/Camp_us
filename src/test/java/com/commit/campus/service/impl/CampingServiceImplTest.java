package com.commit.campus.service.impl;

import com.commit.campus.entity.Camping;
import com.commit.campus.repository.CampingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CampingServiceTest {

    @InjectMocks
    private CampingServiceImpl campingService;

    @Mock
    private CampingRepository campingRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCampings() {
        // given
        Camping camping1 = new Camping();
        camping1.setCampName("Camping1");
        camping1.setGlampingSiteCnt(5);
        camping1.setCaravanSiteCnt(2);

        Camping camping2 = new Camping();
        camping2.setCampName("Camping2");
        camping2.setGlampingSiteCnt(0);
        camping2.setCaravanSiteCnt(3);

        List<Camping> expectedCampings = Arrays.asList(camping1, camping2);

        when(campingRepository.findCampings(anyString(), anyString(), anyInt(), anyInt(), anyInt(), anyInt()))
                .thenReturn(expectedCampings);

        // when
        List<Camping> actualCampings = campingService.getCampings("Seoul", "Gangnam", 1, 1, 0, 10, "campId", "desc");

        // then
        assertEquals(expectedCampings, actualCampings);
    }

    @Test
    void testGetAllCampings() {
        // given
        Camping camping1 = new Camping();
        camping1.setCampName("Camping1");

        Camping camping2 = new Camping();
        camping2.setCampName("Camping2");

        List<Camping> expectedCampings = Arrays.asList(camping1, camping2);

        when(campingRepository.findAll()).thenReturn(expectedCampings);

        // when
        List<Camping> actualCampings = campingService.getAllCampings();

        // then
        assertEquals(expectedCampings, actualCampings);
    }
}
