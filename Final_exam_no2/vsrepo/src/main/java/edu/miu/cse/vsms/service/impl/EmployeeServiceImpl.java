package edu.miu.cse.vsms.service.impl;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.model.VService;
import edu.miu.cse.vsms.repository.EmployeeRepository;
import edu.miu.cse.vsms.repository.VehicleServiceRepository;
import edu.miu.cse.vsms.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final VehicleServiceRepository vehicleServiceRepository;

    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto request) {
     Employee employee= new Employee();
     employee.setName(request.name());
     employee.setPhone(request.phone());
     employee.setEmail(request.email());
     employee.setHireDate(request.hireDate());
     employee.setVServices(employee.getVServices());

     EmployeeResponseDto employeeResponseDto= new EmployeeResponseDto(
            employee.getId(),
             employee.getName(),
             employee.getEmail(),
             employee.getPhone(),
             employee.getHireDate(),
             new ArrayList<>()
     );
        return employeeResponseDto;
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {

        List<Employee> employeeList= employeeRepository.findAll();
        List<VService> vServices=vehicleServiceRepository.findAll();

        List<EmployeeResponseDto>  employeeResponseDtos= new ArrayList<>();


        for(Employee emp:employeeList){
          employeeResponseDtos.add(
                 new EmployeeResponseDto(
                         emp.getId(),
                         emp.getName(),
                         emp.getEmail(),
                         emp.getPhone(),
                         emp.getHireDate(),
                         new ArrayList<>()


                 )
          );
        }


        return employeeResponseDtos;
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
      Employee employee=employeeRepository.findEmployeeById(id);
      EmployeeResponseDto employeeResponseDto= new EmployeeResponseDto(
              employee.getId(),
              employee.getName(),
              employee.getEmail(),
              employee.getPhone(),
              employee.getHireDate(),
              new ArrayList<>()
      );


        return employeeResponseDto;
    }

    @Override
    public EmployeeResponseDto partiallyUpdateEmployee(Long id, Map<String, Object> updates) {
        // Fetch the employee by ID or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));

        // Apply each update based on the key
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    // Write your code here
                   employee.setName(employee.getName());

                    break;
                case "email":
                    // Write your code here
                    employee.setEmail(employee.getEmail());
                    break;
                case "phone":
                    // Write your code here
                    employee.setPhone(employee.getPhone());


                    break;
                case "hireDate":
                    // Write your code here
                    employee.setHireDate(employee.getHireDate());

                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        // Write your code here

        return null;
    }

    @org.jetbrains.annotations.NotNull
    private EmployeeResponseDto mapToResponseDto(Employee employee) {
        List<VehicleServiceResponseDto> serviceDtos = employee.getVServices().stream()
                .map(service -> new VehicleServiceResponseDto(
                        service.getId(),
                        service.getServiceName(),
                        service.getCost(),
                        service.getVehicleType()
                )).toList();

        return new EmployeeResponseDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getHireDate(),
                serviceDtos
        );
    }
}
