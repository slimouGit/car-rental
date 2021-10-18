package net.slimou.carrental.staff.repository;


import net.slimou.carrental.staff.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>  {
        }

