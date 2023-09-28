package com.barzigan.www.barziganlms.course.application;
import com.barzigan.www.barziganlms.course.model.CourseDto;
import java.util.List;

public interface CourseService {
    void deleteCourse(long id);

    void createCourse(CourseDto courseDto);

    void updateCourse(CourseDto courseDto);

    List<CourseDto> getAll();
    CourseDto getCourse(long id);

}
