package edu.miu.cse.vsms.repository;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
     List<EmployeeResponseDto> getAllEmployee();
     Employee findEmployeeById(Long id);
     Optional<EmployeeResponseDto>updateEmployeePartially(EmployeeRequestDto employeeRequestDto);

}
