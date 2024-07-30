package com.commit.campus.controller;

import com.commit.campus.entity.Camping;
import com.commit.campus.service.CampingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CampingControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CampingController campingController;

    @Mock
    private CampingService campingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(campingController).build();
    }

    @Test
    void testGetCampings() throws Exception {
        // given
        Camping camping1 = Camping.builder()
                .campName("Camping1")
                .glampingSiteCnt(5)
                .caravanSiteCnt(2)
                .build();

        Camping camping2 = Camping.builder()
                .campName("Camping2")
                .glampingSiteCnt(0)
                .caravanSiteCnt(3)
                .build();

        List<Camping> campings = Arrays.asList(camping1, camping2);

        when(campingService.getCampings(anyString(), anyString(), anyInt(), anyInt(), anyInt(), anyInt(), anyString(), anyString()))
                .thenReturn(campings);

        // when, then
        mockMvc.perform(get("/v1/campings")
                        .param("doName", "Seoul")
                        .param("sigunguName", "Gangnam")
                        .param("glampingSiteCnt", "1")
                        .param("caravanSiteCnt", "1")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "campId")
                        .param("order", "desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].campName").value("Camping1"))
                .andExpect(jsonPath("$[1].campName").value("Camping2"));
    }

    @Test
    void testGetAllCampings() throws Exception {
        // given
        Camping camping1 = Camping.builder()
                .campName("Camping1")
                .build();

        Camping camping2 = Camping.builder()
                .campName("Camping2")
                .build();

        List<Camping> campings = Arrays.asList(camping1, camping2);

        when(campingService.getAllCampings()).thenReturn(campings);

        // when, then
        mockMvc.perform(get("/v1/campings/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].campName").value("Camping1"))
                .andExpect(jsonPath("$[1].campName").value("Camping2"));
    }
}
