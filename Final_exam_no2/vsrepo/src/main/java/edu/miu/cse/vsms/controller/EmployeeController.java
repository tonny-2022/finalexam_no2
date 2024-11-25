package edu.miu.cse.vsms.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Add a new employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(@RequestBody EmployeeRequestDto request) {
        // Write your code here
        EmployeeResponseDto employeeResponseDto=employeeService.addEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseDto);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        // Write your code here
        List<EmployeeResponseDto> employeeResponseDtos=employeeService.getAllEmployees();
        return  ResponseEntity.status(HttpStatus.OK).body(employeeResponseDtos);
    }

    // Get a specific employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        // Write your code here
         EmployeeResponseDto employeeResponseDto=employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
    }

    // Update partially an existing employee
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> partiallyUpdateEmployee(@PathVariable Long id, @RequestBody Map<String, Object> updates
    ) {
        // Write your code here

         EmployeeResponseDto employeeResponseDto=employeeService.getEmployeeById(id);
         if(employeeResponseDto!=null){
             EmployeeResponseDto employeeResponseDto1=employeeResponseDto;


         }
       for(Map.Entry<String,Object> emp:updates.entrySet()){

           String filedname=emp.getKey();
           Object value=emp.getValue();

       }

        return null;
    }
}
