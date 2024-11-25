package edu.miu.cse.vsms.controller;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private EmployeeService employeeService;

    @Test
    void addEmployee() {

        EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto("tonny","tonnyk@mail.com",
                "164123378989", LocalDate.of(2022,9,5));
        EmployeeResponseDto employeeResponseDto= new EmployeeResponseDto(1.0,"tonny","tonny@mail.com","165433u3u3",LocalDate.of(2023,8,9));




    }
}