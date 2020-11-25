package Mapper;

import entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> list();
    public Employee Byid(Integer id);
    public void add(Employee em);
    void del(Integer id);
   List<Employee> byname(String name);
   void up(Employee e);
}
