package com.commit.campus.controller;

// import com.commit.campus.dto.CampingDTO;
import com.commit.campus.entity.Camping;
import com.commit.campus.service.CampingService;
import com.commit.campus.view.CampingViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CampingControllerTest {

    @Mock
    private CampingService campingService;

    @InjectMocks
    private CampingController campingController;

    private Camping camping;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        camping = new Camping();
        camping.setCampId(1L);
        camping.setCampName("Test Camp");
        // 필요한 다른 필드 초기화
    }

    @Test
    void testGetCampings() {
        when(campingService.getCampings(anyString(), anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyString(), anyString()))
                .thenReturn(Arrays.asList(camping));

        List<CampingViewModel> campings = campingController.getCampings("doName", "sigunguName", 1, 1, 0, 10, "campId", "desc");
        assertNotNull(campings);
        assertEquals(1, campings.size());
        verify(campingService, times(1)).getCampings("doName", "sigunguName", 1, 1, 0, 10, "campId", "desc");
    }

    @Test
    void testGetCampingById() {
        when(campingService.getCampingById(1L)).thenReturn(Optional.of(camping));

        ResponseEntity<CampingViewModel> response = campingController.getCampingById(1L);
        assertEquals(ResponseEntity.ok(new CampingViewModel(camping)), response);
        verify(campingService, times(1)).getCampingById(1L);
    }
}
