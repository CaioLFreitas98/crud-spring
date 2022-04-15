package br.edu.ifms.crudspring.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.crudspring.Model.Student;
import br.edu.ifms.crudspring.Service.StudentService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public String save(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student/";

    }

    @GetMapping("/")
    public String locAll(Model model) {
        List<Student> students = studentService.getStudent();
        model.addAttribute("students", students);
        return "index";

    }

    @GetMapping("/cadastrar")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "cad";
    }

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") UUID id) {
        studentService.delete(id);
        return "redirect:/student/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model) {
        log.info("id = edit", id);
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "editar";

    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") UUID id, @ModelAttribute Student student) {

        studentService.saveStudent(student);
        return "redirect:/student/";
    }
}
