package com.barzigan.www.barziganlms.course.infra;

import com.barzigan.www.barziganlms.course.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
