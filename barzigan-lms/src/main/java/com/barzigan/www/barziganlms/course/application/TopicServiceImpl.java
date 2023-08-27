package com.barzigan.www.barziganlms.course.application;

import com.barzigan.www.barziganlms.course.infra.TopicRepository;
import com.barzigan.www.barziganlms.course.model.Topic;
import com.barzigan.www.barziganlms.utils.KeyValDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Override
    public void deleteById(long id){
        topicRepository.deleteById(id);

    }
    @Override
    public void delete(Topic topic){
        topicRepository.delete(topic);
    }
    @Override
    public void save(KeyValDto dto){
        var topic = Topic.builder().title(dto.getTitle()).id(dto.getId()).build();
        topicRepository.save(topic);
    }
    @Override
    public void save(Topic topic){
        topicRepository.save(topic);
    }

    @Override
    public void save(Set<Topic> topics){
        topicRepository.saveAll(topics);
    }
}
