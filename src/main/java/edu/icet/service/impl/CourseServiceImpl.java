package edu.icet.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.icet.model.dto.CourseDto;
import edu.icet.model.entity.Course;
import edu.icet.repository.CourseRepository;
import edu.icet.service.CourseService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper mapper;
    @Override
    public void createCourse(CourseDto course) {
       courseRepository.save(mapper.map(course, Course.class));
    }

    @Override
    public List<CourseDto> getAllCourses() {
      List<CourseDto> courseList = new ArrayList<>();
      List <Course> all = courseRepository.findAll();
      all.forEach(courseEntity->{
        courseList.add(mapper.map(courseEntity, CourseDto.class));
      });
      return courseList;
    }

    @Override
    public void getCourseById(Long id) {
      courseRepository.findById(id);
    }

    @Override
    public void deleteCourse(Long id) {
       courseRepository.deleteById(id);
    }
}
