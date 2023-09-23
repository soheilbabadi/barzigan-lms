package com.barzigan.www.barziganlms.course.application;

import com.barzigan.www.barziganlms.course.infra.CourseRepository;
import com.barzigan.www.barziganlms.course.model.Course;
import com.barzigan.www.barziganlms.course.model.CourseDto;
import com.barzigan.www.barziganlms.course.model.Detail;
import com.barzigan.www.barziganlms.course.model.Topic;
import com.barzigan.www.barziganlms.utils.KeyValDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }


    @Override
    public void createCourse(CourseDto courseDto) {
        var detailSet = getDetails(courseDto.getDetails());
        var topicSet = getTopics(courseDto.getTopics());
        var course = Course.builder().archived(false).title(courseDto.getTitle())
                .capacity(courseDto.getCapacity())
                .description(courseDto.getDescription())
                .tuition(courseDto.getTuition())
                .createdDate(LocalDateTime.now(ZoneOffset.UTC))
                .finishDate(courseDto.getFinishDate())
                .title(courseDto.getTitle())
                .startDate(courseDto.getStartDate())
                .updatedDate(LocalDateTime.now(ZoneOffset.UTC))
                .topics(topicSet)
                .details(detailSet)
                .build();
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        var course = courseRepository.findById(courseDto.getId())
                .orElseThrow(() -> new NullPointerException("Course not found"));
        BeanUtils.copyProperties(courseDto, course);
        course.setUpdatedDate(LocalDateTime.now(ZoneOffset.UTC));
        courseRepository.save(course);

    }

    @Override
    public List<CourseDto> getAll() {
        var list = courseRepository.findAll();
        return list.stream().map(this::getCourseDto)
                .filter(courseDto -> !courseDto.isArchived())
                .sorted((o1, o2) -> o2.getStartDate().compareTo(o1.getStartDate()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourse(long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Course not found"));
        return getCourseDto(course);
    }

    private CourseDto getCourseDto(Course course) {
        return CourseDto.builder().id(course.getId()).title(course.getTitle())
                .capacity(course.getCapacity())
                .description(course.getDescription())
                .tuition(course.getTuition())
                .startDate(course.getCreatedDate())
                .finishDate(course.getFinishDate())
                .title(course.getTitle())
                .startDate(course.getStartDate())
                .details(getDetailDto(course.getDetails()))
                .topics(getTopicDto(course.getTopics()))
                .build();
    }

    private Set<KeyValDto> getTopicDto(Set<Topic> topics) {
        return topics.stream().map(topic -> KeyValDto.builder().id(topic.getId()).title(topic.getTitle()).build())
                .collect(Collectors.toSet());
    }

    private Set<KeyValDto> getDetailDto(Set<Detail> details) {
        return details.stream().map(detail -> KeyValDto.builder().id(detail.getId()).title(detail.getCourseDetail()).build())
                .collect(Collectors.toSet());
    }

    private Set<Topic> getTopics(Set<KeyValDto> topics) {
        return topics.stream().map(topic -> Topic.builder().id(topic.getId()).title(topic.getTitle()).build())
                .collect(Collectors.toSet());
    }

    private Set<Detail> getDetails(Set<KeyValDto> details) {
        return details.stream().map(detail -> Detail.builder().id(detail.getId()).courseDetail(detail.getTitle()).build())
                .collect(Collectors.toSet());

    }
}
