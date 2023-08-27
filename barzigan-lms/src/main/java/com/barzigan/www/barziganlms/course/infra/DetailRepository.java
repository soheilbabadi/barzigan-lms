package com.barzigan.www.barziganlms.course.infra;

import com.barzigan.www.barziganlms.course.model.Course;
import com.barzigan.www.barziganlms.course.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    List<Detail> findAllByCourse(Course course);

}
