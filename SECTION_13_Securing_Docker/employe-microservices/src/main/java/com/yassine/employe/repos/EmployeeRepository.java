package com.yassine.employe.repos;


import java.util.List;


import com.yassine.employe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByNomEmployeContainingIgnoreCase(String nom);

    List<Employee> findByNomEmploye(String nom);

    @Query("select e from Employee e where e.nomEmploye like %:nom  and e.salaire > :salaire")
    List<Employee> findBynometsalaire (@Param("nom")String nom,@Param("salaire")int salaire );

//    List<Employee> findByGradeIdGraEmp(int id);

    List<Employee> findByOrderByNomEmployeAsc();
    List<Employee> findByOrderByNomEmployeDesc();

    @Query("select e from Employee e order by e.nomEmploye ASC, e.salaire DESC")
    List<Employee> trierEmployeesNomsSalaire ();



}
