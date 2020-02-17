package com.max.springboot_301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {

//    @Autowired
//    JobRepository jobRepository;
//
//    @RequestMapping("/")
//    public String listJobs(Model model){
//        model.addAttribute("jobs", jobRepository.findAll());
//        return "list";
//    }
//
//    @GetMapping("/add")
//    public String jobForm(Model model){
//        model.addAttribute("job", new Job());
//        return "jobform";
//    }
//
//    @PostMapping("/process")
//    public String processForm(@Valid Job job, BindingResult result){
//        if (result.hasErrors()){
//            return "jobform";
//        }
//        jobRepository.save(job);
//        return "redirect:/";
//    }

    //////////////////////////////////////////////////////////////////////////////////////////

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "listCourse";
    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("course", new Course());
        return "courseform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Course course, BindingResult result){
        if (result.hasErrors()){
            return "courseform";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("course", courseRepository.findById(id).get());
        return "courseform";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id, Model model) {
        courseRepository.deleteById(id);
        return "redirect:/";
    }





}
