package com.nsa.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.nsa.entity.Address;
import com.nsa.entity.Course;
import com.nsa.entity.Student;
import com.nsa.model.request.StudentRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentFilterService {

    @Autowired
    private EntityManager entityManager;

    public List<StudentRequest> findStudentWithSearchAndFilter(String search, Integer minAge, Long pincode, LocalDate startDate) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentRequest> cq = cb.createQuery(StudentRequest.class);

        Root<Student> studentRoot = cq.from(Student.class);  //FROM clause

        Join<Student, Address> addressJoin = studentRoot.join("address", JoinType.LEFT);
        Join<Student, Course> coursesJoin = studentRoot.join("courses", JoinType.LEFT);

        List<Predicate> finalPredicate = new ArrayList<>();

        cq.select(cb.construct(StudentRequest.class,
                studentRoot.get("name"),
                studentRoot.get("age"),
                studentRoot.get("mobile"),
                addressJoin.get("pincode"),
                addressJoin.get("street"),
                addressJoin.get("city"),
                coursesJoin.get("name")
                ));


        if(search != null && !search.isBlank() && !StringUtil.isNullOrEmpty(search)){
            String likePattern = "%" + search.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(studentRoot.get("name")), likePattern);
            Predicate mobilePredicate = cb.like(cb.toString(studentRoot.get("mobile")), "%" + search.toLowerCase() + "%");
            Predicate courseNamePredicate = cb.like(cb.lower(coursesJoin.get("name")), likePattern);

            Predicate orPredicate = cb.or(namePredicate, mobilePredicate, courseNamePredicate);
            finalPredicate.add(orPredicate);

        }

        if (minAge != null) {
            Predicate agePredicate = cb.greaterThanOrEqualTo(studentRoot.get("age"), minAge);
            finalPredicate.add(agePredicate);
        }

        if (pincode != null) {
            Predicate pincodePredicate = cb.equal(addressJoin.get("pincode"), pincode);
            finalPredicate.add(pincodePredicate);
        }

        if (startDate != null) {
            Predicate startDatePredicate = cb.greaterThanOrEqualTo(coursesJoin.get("startDate"), startDate.atStartOfDay());
            finalPredicate.add(startDatePredicate);
        }

//        cq.where(cb.and(finalPredicate.toArray(new Predicate[0])));

        Predicate[] predicateArray = finalPredicate.toArray(new Predicate[0]);

        Predicate combinePredicate = cb.and(predicateArray);

        CriteriaQuery<StudentRequest> where = cq.where(combinePredicate);

        List<StudentRequest> resultList = entityManager.createQuery(cq).getResultList();

        return  resultList;

    }

}
