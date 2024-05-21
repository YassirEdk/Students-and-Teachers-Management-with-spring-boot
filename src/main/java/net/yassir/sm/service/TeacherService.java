package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Teacher;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher saveTeacher(Teacher Teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Teacher Teacher);

    void deleteTeacherById(Long id);
}
