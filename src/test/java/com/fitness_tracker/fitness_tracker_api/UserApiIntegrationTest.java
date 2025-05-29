package com.fitness_tracker.fitness_tracker_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness_tracker.fitness_tracker_api.dto.UserDto;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Integration tests for the User API endpoints.
 * Verifies the functionality of user-related operations through HTTP requests.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserApiIntegrationTest {

    private static final String BASE_URL = "/api/users";
    private static final String TEST_EMAIL = "test.user@example.com";
    private static final String TEST_NAME = "Mariusz";
    private static final String TEST_LAST_NAME = "Kowalski";
    private static final LocalDate TEST_BIRTH_DATE = LocalDate.of(1990, 1, 1);
    private static final int TEST_AGE = 20;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * Tests successful user creation.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void A_givenValidUserRequest_whenCreateUser_thenUserIsCreated() throws Exception {
        UserDto userDto = createValidUserDto();
        String requestBody = this.objectMapper.writeValueAsString(userDto);

        mvc.perform(post(BASE_URL+"/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

    /**
     * Tests retrieval of all users.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void B_givenEmptyRequest_whenReceiveUser_thenUserIsReturned() throws Exception {
        MvcResult result = mvc.perform(get(BASE_URL+"/"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        List<UserDto> articles = objectMapper.readValue(responseBody, new TypeReference<>(){});

        assertNotNull(articles);
    }

    /**
     * Tests retrieval of a user by ID.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void C_givenValidId_whenReceiveUser_thenUserIsReturned() throws Exception {
        mvc.perform(get(BASE_URL+"/1"))
                .andExpect(status().isOk());
    }

    /**
     * Tests successful user update.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void D_givenValidIdAndBody_whenUpdateUser_thenUserIsUpdated() throws Exception {
        UserDto user = createValidUserDto();
        String json = objectMapper.writeValueAsString(user);

        mvc.perform(put(BASE_URL+"/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    /**
     * Tests retrieval of specific user information.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void E_givenValidIdParamAndInfoParam_whenReceiveParticularInfo_thenParticularInfoIsReturned() throws Exception {
        mvc.perform(get(BASE_URL + "/get-info?id=1&infoType=email"))
                .andExpect(status().isOk());
    }

    /**
     * Tests retrieval of basic user information.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void F_givenValidEmptyRequest_whenReceiveBasicInfo_thenUserIsReturned() throws Exception {
        mvc.perform(get(BASE_URL+"/basic-info"))
                .andExpect(status().isOk());
    }

    /**
     * Tests retrieval of user by email.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void G_givenValidNameOrEmail_whenReceiveUser_thenUserIsReturned() throws Exception {
        mvc.perform(get(BASE_URL+"/basic-info-email/"+TEST_EMAIL))
                .andExpect(status().isOk());
    }

    /**
     * Tests retrieval of users by age threshold.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void H_givenValidAge_whenReceiveUser_thenUserIsReturned() throws Exception {
        mvc.perform(get(BASE_URL+"/all_users_by_age/"+TEST_AGE))
                .andExpect(status().isOk());
    }

    /**
     * Tests successful user deletion.
     *
     * @throws Exception if the test fails
     */
    @Test
    public void I_givenValidId_whenDeleteUser_thenUserIsDeleted() throws Exception {
        mvc.perform(delete(BASE_URL+"/delete/1"))
                .andExpect(status().isOk());
    }

    /**
     * Creates a valid UserDto with test constants.
     * Used for consistent test data across test cases.
     * @return new UserDto with test values (null ID, TEST_NAME, TEST_LAST_NAME etc.)
     */
    private UserDto createValidUserDto() {
        return new UserDto(
                null,
                TEST_NAME,
                TEST_LAST_NAME,
                TEST_BIRTH_DATE,
                TEST_EMAIL,
                TEST_AGE
        );
    }
}