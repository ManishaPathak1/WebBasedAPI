package com.example.webbasedspringapi.Controller;

import com.example.webbasedspringapi.Entities.Student;
import com.example.webbasedspringapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class studentController {
@Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private int id;

    @GetMapping("/")
            public String homepage(Model model){
        List<Student> listofstudents=userService.getAllstudents();

        model.addAttribute("liststudents",listofstudents);
        return "index";
            }
    @GetMapping("/newstudent")
    public String addstudent(Model model){
        Student student=new Student();
        model.addAttribute("student",student);

        return "createNewUser";
    }
    @PostMapping("/saveStudent")
    public String saveStudents(Student student){
        String encryptPassword=bCryptPasswordEncoder.encode(student.getPassword());
        student.setPassword(encryptPassword);
userService.saveStudent(student);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id")int id){
        userService.deleteStudent(id);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editStudent(@PathVariable(name = "id")int id){
        ModelAndView modelAndView=new ModelAndView("createNewUser");
        Student student=userService.editStudent(id);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
