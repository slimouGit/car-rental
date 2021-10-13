package net.slimou.carrental.employee;


import net.slimou.carrental.office.Office_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>  {
        }

