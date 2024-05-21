package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.repository.TeacherRepository;
import net.javaguides.sms.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository TeacherRepository;

    public TeacherServiceImpl(TeacherRepository TeacherRepository) {
        super();
        this.TeacherRepository = TeacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return TeacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher Teacher) {
        return TeacherRepository.save(Teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return TeacherRepository.findById(id).get();
    }

    @Override
    public Teacher updateTeacher(Teacher Teacher) {
        return TeacherRepository.save(Teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        TeacherRepository.deleteById(id);
    }

}
