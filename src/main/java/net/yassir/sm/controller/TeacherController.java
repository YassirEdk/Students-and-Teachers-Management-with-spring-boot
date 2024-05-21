package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Teacher;
import net.javaguides.sms.service.TeacherService;

@Controller
public class TeacherController {

    private TeacherService TeacherService;

    public TeacherController(TeacherService TeacherService) {
        super();
        this.TeacherService = TeacherService;
    }

    // handler method to handle list Teachers and return mode and view
    @GetMapping("/Teachers")
    public String listTeachers(Model model) {
        model.addAttribute("Teachers", TeacherService.getAllTeachers());
        return "Teachers";
    }

    @GetMapping("/Teachers/new")
    public String createTeacherForm(Model model) {

        // create Teacher object to hold Teacher form data
        Teacher Teacher = new Teacher();
        model.addAttribute("Teacher", Teacher);
        return "create_Teacher";

    }

    @PostMapping("/Teachers")
    public String saveTeacher(@ModelAttribute("Teacher") Teacher Teacher) {
        TeacherService.saveTeacher(Teacher);
        return "redirect:/Teachers";
    }

    @GetMapping("/Teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model) {
        model.addAttribute("Teacher", TeacherService.getTeacherById(id));
        return "edit_Teacher";
    }

    @PostMapping("/Teachers/{id}")
    public String updateTeacher(@PathVariable Long id,
                                @ModelAttribute("Teacher") Teacher Teacher,
                                Model model) {

        // get Teacher from database by id
        Teacher existingTeacher = TeacherService.getTeacherById(id);
        existingTeacher.setId(id);
        existingTeacher.setFirstName(Teacher.getFirstName());
        existingTeacher.setLastName(Teacher.getLastName());
        existingTeacher.setEmail(Teacher.getEmail());
        existingTeacher.setMat(Teacher.getMat());

        // save updated Teacher object
        TeacherService.updateTeacher(existingTeacher);
        return "redirect:/Teachers";
    }

    // handler method to handle delete Teacher request

    @GetMapping("/Teachers/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        TeacherService.deleteTeacherById(id);
        return "redirect:/Teachers";
    }

}
