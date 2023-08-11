package com.barzigan.www.barziganlms.course.infra;

import com.barzigan.www.barziganlms.course.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {

}
