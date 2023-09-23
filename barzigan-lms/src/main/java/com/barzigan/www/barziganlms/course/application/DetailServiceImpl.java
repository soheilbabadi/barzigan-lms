package com.barzigan.www.barziganlms.course.application;

import com.barzigan.www.barziganlms.course.infra.CourseRepository;
import com.barzigan.www.barziganlms.course.infra.DetailRepository;
import com.barzigan.www.barziganlms.course.model.Detail;
import com.barzigan.www.barziganlms.utils.KeyValDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {

    private final DetailRepository detailRepository;
    private final CourseRepository courseRepository;

    @Override
    public void deleteById(long id) {
        detailRepository.deleteById(id);
    }

    @Override
    public void save(Detail detail) {
        detailRepository.save(detail);
    }

    @Override
    public void save(Set<KeyValDto> dtoSet) {
        var detailSet = dtoSet.stream().map(dto -> Detail.builder().courseDetail(dto.getTitle())
                .id(dto.getId()).build()).collect(Collectors.toSet());
        detailRepository.saveAll(detailSet);
    }

    @Override
    public void save(KeyValDto dto) {
        var detail = Detail.builder().courseDetail(dto.getTitle()).id(dto.getId()).build();
        detailRepository.save(detail);
    }

    @Override
    public List<KeyValDto> findAllByCourseId(long courseId) {
        var course=courseRepository.findById(courseId).orElseThrow(()->new NullPointerException("Course not found"));
        return course.getDetails().stream().map(detail -> KeyValDto.builder()
                .id(detail.getId())
                .title(detail.getCourseDetail())
                .build()).collect(Collectors.toList());
    }

}
