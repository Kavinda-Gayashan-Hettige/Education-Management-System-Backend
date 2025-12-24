package edu.icet.service.impl;
import edu.icet.service.CourseService;
import edu.icet.model.dto.CourseDto;
import edu.icet.model.entity.Course;
import edu.icet.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    
   

    private Course mapToEntity(CourseDto dto) {
     
        return new Course(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getDurationMonths(),
                dto.getFee()
        );
    }

    private CourseDto mapToDto(Course entity) {
        return new CourseDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDurationMonths(),
                entity.getFee()
        );
    }
    
  

    @Override
    @Transactional
    public CourseDto createCourse(CourseDto dto) {
       
        if (courseRepository.findByName(dto.getName()).isPresent()) {
            throw new RuntimeException("Course name already exists: " + dto.getName());
        }

        Course entity = mapToEntity(dto);
        Course savedEntity = courseRepository.save(entity);
        return mapToDto(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CourseDto> getCourseById(Long id) {
        return courseRepository.findById(id).map(this::mapToDto);
    }
    
    @Override
    @Transactional
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

    
}