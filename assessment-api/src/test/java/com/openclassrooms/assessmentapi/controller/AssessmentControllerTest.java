package com.openclassrooms.assessmentapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
public class AssessmentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeAll
    static void setUp() {
        log.info("@BeforeAll");
    }

    @BeforeEach
    public void setUpBeforeEach() {
        log.info("@BeforeEach");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test_getPatientAssessment_forNone() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/assessment/1"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("None");

    }

    @Test
    public void test_getPatientAssessment_forBorderline() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/assessment/2"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("Borderline");

    }

    @Test
    public void test_getPatientAssessment_forInDanger() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/assessment/3"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("InDanger");

    }

    @Test
    public void test_getPatientAssessment_forEarlyOnSet() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/assessment/4"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("EarlyOnset");

    }

    @Test
    public void test_getFamilyAssessmentList() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/assessment/familyName?value=ferguson"))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content).contains("Lucas");
        assertThat(content).contains("Dude");

    }

}
