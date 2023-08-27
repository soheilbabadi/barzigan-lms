package com.barzigan.www.barziganlms.course.application;

import com.barzigan.www.barziganlms.course.model.Detail;
import com.barzigan.www.barziganlms.utils.KeyValDto;

import java.util.List;
import java.util.Set;

public interface DetailService {
    void deleteById(long id);


    void save(Detail detail);

    void save(Set<KeyValDto> dtoSet);

    void save(KeyValDto dto);

    List<KeyValDto> findAllByCourseId(long courseId);

}
