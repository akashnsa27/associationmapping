package com.nsa.repository;

import com.nsa.entity.Student;
import com.nsa.model.response.StudAddressResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

//    //    List<Student> findByFirstName(String name); //In-valid
//    List<Student> findByname(String name);//valid
//
//    List<Student> findByName(String name); //valid
//
//    List<Student> findByNameIgnoreCase(String name); //valid
//
//    List<Student> findByAge(int age); //valid
//
//    List<Student> findByAgeLessThan(int age); //valid
//
//    List<Student> findByNameAndMobile(String name, Long no); //valid
//
//    List<Student> findByNameOrMobile(String name, Long no); //valid
//
//    //Address
//    Optional<Student> findByAddressId(Long id);
//
//    List<Student> findByAddressCity(String name);
//
//    //course
//    List<Student> findByCoursesId(Long id);
//
//    List<Student> findByCoursesName(String name);
//
//    List<Student> findByCoursesNameOrderByAgeDesc(String name);
//
//    List<Student> findTop2ByCoursesNameOrderByAgeDesc(String name);
//
//    List<Student> findByNameContaining(String keyword);
//

    //    @Query(value = "SELECT * FROM student", nativeQuery = true) //SQL
    @Query(value = "SELECT s FROM Student s")
    //JPQL
    List<Student> getAllStudent(Pageable pageable);

    //       @Query(value = "SELECT stud_name FROM student", nativeQuery = true) //SQL
    @Query(value = "SELECT s.name FROM Student s")
    //JPQL
    List<String> getAllStudentName();

    @Query(value = "SELECT stud_name,age FROM student", nativeQuery = true)
        //SQL
        // @Query(value = "SELECT s.name FROM Student s")  //JPQL
    List<Object[]> getAllStudentNameAndAge();

    // @Query(value = "SELECT * FROM student WHERE id = id", nativeQuery = true)
    @Query(value = "SELECT s FROM Student s WHERE s.id = :id")
    Optional<Student> getStudentById(int id);

    //    @Query(value = "SELECT name FROM student where id = :id", nativeQuery = true)
    @Query(value = "SELECT s.name FROM Student s where s.id = :id")
    Optional<String> getStudNameById(@Param("id") int studId);

    //@Query(value = "SELECT age, mobile FROM student where id = :studId", nativeQuery = true)
    // @Query(value = "SELECT new com.nsa.model.response.StudDetails(s.age, s.mobile)  FROM Student s where s.id = :studId")
    //Optional<StudDetails> getStudDetailsById(@Param("studId") int studId);

    @Query(value = "select age, COUNT(*) from student group by age", nativeQuery = true)
    List<Object[]> getAgeCount();

    @Query(value = "Select s.age, s.stud_name, a.city, a.pincode from student s left join address a on s.address_id = a.id", nativeQuery = true)
    List<StudAddressResponse> getStudAddDetails();

    //    @Query(value = "SELECT * FROM student", nativeQuery = true) //SQL
    @Query(value = "SELECT s FROM Student s")
    //JPQL
    Page<Student> getAllStudentPaged(Pageable pageable);
}
