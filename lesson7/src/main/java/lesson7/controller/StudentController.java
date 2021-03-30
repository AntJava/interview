package lesson7.controller;

import lesson7.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import lesson7.service.StudentServiceImpl;

import java.util.List;

//Создать JSP-страницу, на которой в таблице отобразить список студентов с кнопками для добавления, обновления и удаления записей.
@Controller
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentServiceImpl){this.studentService = studentServiceImpl;}

    //http://localhost:8080/
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Student student = new Student();
                student.setAge(20 + i);
                student.setName("Student" + i);
                studentService.saveAndSet(student);
            }
            students = studentService.findAll();
        }
        model.addAttribute("students", students);
        Student newStudent = new Student();
        model.addAttribute("newStudent", newStudent);
        Student updateStudent = new Student();
        model.addAttribute("updateStudent", updateStudent);
        return "index";
    }

    @PostMapping(value = "/new")
    public String saveStudent(@ModelAttribute("newStudent") Student student){
        studentService.saveAndSet(student);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@ModelAttribute("updateStudent") Student student){
        studentService.saveAndSet(student);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteStudent(@ModelAttribute("updateStudent") Student student){
        studentService.delete(student);
        return "redirect:/";
    }

    @PostMapping(value = "/updateName")
    public String updateStudentName(@ModelAttribute("updateStudent") Student student){
        studentService.updateName(student.getId(), student.getName());
        return "redirect:/";
    }

    @PostMapping(value = "/updateAge")
    public String updateStudentAge(@ModelAttribute("updateStudent") Student student){
        studentService.updateAge(student.getId(), student.getAge());
        return "redirect:/";
    }

}
