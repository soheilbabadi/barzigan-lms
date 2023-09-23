package com.barzigan.www.barziganlms.course.presentation;

import com.barzigan.www.barziganlms.course.application.DetailService;
import com.barzigan.www.barziganlms.utils.KeyValDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/api/v1/course")
@RestController
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/{id}")
    public ResponseEntity<KeyValDto> getAll(@PathVariable long id) {
        var courseDtoList = detailService.findAllByCourseId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<KeyValDto> save(@RequestBody KeyValDto dto) {
        detailService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/all")
    public ResponseEntity<KeyValDto> save(@RequestBody Set<KeyValDto> dtoSet) {
        detailService.save(dtoSet);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<KeyValDto> delete(@PathVariable long id) {
        detailService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
