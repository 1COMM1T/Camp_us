package com.commit.campus.service.impl;

import com.commit.campus.entity.Camping;
import com.commit.campus.repository.CampingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CampingServiceImplTest {

    @Mock
    private CampingRepository campingRepository;

    @InjectMocks
    private CampingServiceImpl campingService;

    private List<Camping> campings;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // 테스트 데이터를 생성.
        Camping camping1 = new Camping();
        camping1.setCampId(1L);
        camping1.setCampName("캠핑장 A");
        camping1.setCreatedDate(LocalDateTime.now().minusDays(1));

        Camping camping2 = new Camping();
        camping2.setCampId(2L);
        camping2.setCampName("캠핑장 B");
        camping2.setCreatedDate(LocalDateTime.now());

        Camping camping3 = new Camping();
        camping3.setCampId(3L);
        camping3.setCampName("캠핑장 C");
        camping3.setCreatedDate(LocalDateTime.now().minusDays(2));

        Camping camping4 = new Camping();
        camping4.setCampId(4L);
        camping4.setCampName("캠핑장 D");
        camping4.setCreatedDate(LocalDateTime.now().minusDays(3));

        Camping camping5 = new Camping();
        camping5.setCampId(5L);
        camping5.setCampName("캠핑장 E");
        camping5.setCreatedDate(LocalDateTime.now().minusDays(4));

        Camping camping6 = new Camping();
        camping6.setCampId(6L);
        camping6.setCampName("캠핑장 F");
        camping6.setCreatedDate(LocalDateTime.now().minusDays(5));

        Camping camping7 = new Camping();
        camping7.setCampId(7L);
        camping7.setCampName("캠핑장 G");
        camping7.setCreatedDate(LocalDateTime.now().minusDays(6));

        Camping camping8 = new Camping();
        camping8.setCampId(8L);
        camping8.setCampName("캠핑장 H");
        camping8.setCreatedDate(LocalDateTime.now().minusDays(7));

        Camping camping9 = new Camping();
        camping9.setCampId(9L);
        camping9.setCampName("캠핑장 I");
        camping9.setCreatedDate(LocalDateTime.now().minusDays(8));

        Camping camping10 = new Camping();
        camping10.setCampId(10L);
        camping10.setCampName("캠핑장 J");
        camping10.setCreatedDate(LocalDateTime.now().minusDays(9));

        campings = Arrays.asList(camping1, camping2, camping3, camping4, camping5, camping6, camping7, camping8, camping9, camping10);

        // 모의 메서드 호출 설정
        when(campingRepository.findCampings("경기도", "고양시", 0, 10)).thenReturn(campings);
    }

    @Test
    public void testGetCampingsSortedByNameAsc() {
        List<Camping> sortedCampings = campingService.getCampings("경기도", "고양시", 0, 10, "campName", "asc");

        assertEquals("캠핑장 A", sortedCampings.get(0).getCampName());
        assertEquals("캠핑장 B", sortedCampings.get(1).getCampName());
        assertEquals("캠핑장 C", sortedCampings.get(2).getCampName());
        assertEquals("캠핑장 D", sortedCampings.get(3).getCampName());
        assertEquals("캠핑장 E", sortedCampings.get(4).getCampName());
        assertEquals("캠핑장 F", sortedCampings.get(5).getCampName());
        assertEquals("캠핑장 G", sortedCampings.get(6).getCampName());
        assertEquals("캠핑장 H", sortedCampings.get(7).getCampName());
        assertEquals("캠핑장 I", sortedCampings.get(8).getCampName());
        assertEquals("캠핑장 J", sortedCampings.get(9).getCampName());
    }

    @Test
    public void testGetCampingsSortedByNameDesc() {
        List<Camping> sortedCampings = campingService.getCampings("경기도", "고양시", 0, 10, "campName", "desc");

        assertEquals("캠핑장 J", sortedCampings.get(0).getCampName());
        assertEquals("캠핑장 I", sortedCampings.get(1).getCampName());
        assertEquals("캠핑장 H", sortedCampings.get(2).getCampName());
        assertEquals("캠핑장 G", sortedCampings.get(3).getCampName());
        assertEquals("캠핑장 F", sortedCampings.get(4).getCampName());
        assertEquals("캠핑장 E", sortedCampings.get(5).getCampName());
        assertEquals("캠핑장 D", sortedCampings.get(6).getCampName());
        assertEquals("캠핑장 C", sortedCampings.get(7).getCampName());
        assertEquals("캠핑장 B", sortedCampings.get(8).getCampName());
        assertEquals("캠핑장 A", sortedCampings.get(9).getCampName());
    }

    @Test
    public void testGetCampingsSortedByCreatedDateAsc() {
        List<Camping> sortedCampings = campingService.getCampings("경기도", "고양시", 0, 10, "createdDate", "asc");

        assertEquals("캠핑장 J", sortedCampings.get(0).getCampName());
        assertEquals("캠핑장 I", sortedCampings.get(1).getCampName());
        assertEquals("캠핑장 H", sortedCampings.get(2).getCampName());
        assertEquals("캠핑장 G", sortedCampings.get(3).getCampName());
        assertEquals("캠핑장 F", sortedCampings.get(4).getCampName());
        assertEquals("캠핑장 E", sortedCampings.get(5).getCampName());
        assertEquals("캠핑장 D", sortedCampings.get(6).getCampName());
        assertEquals("캠핑장 C", sortedCampings.get(7).getCampName());
        assertEquals("캠핑장 A", sortedCampings.get(8).getCampName());
        assertEquals("캠핑장 B", sortedCampings.get(9).getCampName());
    }

    @Test
    public void testGetCampingsSortedByCreatedDateDesc() {
        List<Camping> sortedCampings = campingService.getCampings("경기도", "고양시", 0, 10, "createdDate", "desc");

        assertEquals("캠핑장 B", sortedCampings.get(0).getCampName());
        assertEquals("캠핑장 A", sortedCampings.get(1).getCampName());
        assertEquals("캠핑장 C", sortedCampings.get(2).getCampName());
        assertEquals("캠핑장 D", sortedCampings.get(3).getCampName());
        assertEquals("캠핑장 E", sortedCampings.get(4).getCampName());
        assertEquals("캠핑장 F", sortedCampings.get(5).getCampName());
        assertEquals("캠핑장 G", sortedCampings.get(6).getCampName());
        assertEquals("캠핑장 H", sortedCampings.get(7).getCampName());
        assertEquals("캠핑장 I", sortedCampings.get(8).getCampName());
        assertEquals("캠핑장 J", sortedCampings.get(9).getCampName());
    }
}
