package com.barzigan.www.barziganlms.course.application;

import com.barzigan.www.barziganlms.course.model.Topic;
import com.barzigan.www.barziganlms.utils.KeyValDto;

import java.util.Set;

public interface TopicService {
    void deleteById(long id);

    void delete(Topic topic);

    void save(KeyValDto dto);

    void save(Topic topic);

    void save(Set<Topic> topics);
}
