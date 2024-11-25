package edu.miu.cse.vsms.model;

import edu.miu.cse.vsms.service.VehicleService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private LocalDate hireDate;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private List<VService> vServices = new ArrayList<>();

    public Employee(String name, String email, String phone, LocalDate hireDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
    }
}
