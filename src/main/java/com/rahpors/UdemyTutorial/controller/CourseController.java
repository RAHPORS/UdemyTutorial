package com.rahpors.UdemyTutorial.controller;

import com.rahpors.UdemyTutorial.entity.Course;
import com.rahpors.UdemyTutorial.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private static final String FORM_VIEW = "courses";
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImp")
    private CourseService courseService;

    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("../courses/listcourses");
    }

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses(){
        LOG.info("Call: listAllCourses");
        ModelAndView modelAndView = new ModelAndView(FORM_VIEW);
        modelAndView.addObject("courses", courseService.listAllCourse());
        modelAndView.addObject("course",new Course());
        return modelAndView;
    }

    @GetMapping("/showform")
    public ModelAndView showForm(){
        ModelAndView modelAndView =  new ModelAndView("formCourse");
        modelAndView.addObject("course",new Course());
        return modelAndView;
    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course")Course course){
        LOG.info("Call: addCourse --param:  "+course.toString());
        courseService.addCourse(course);
        return "redirect:/courses/listcourses";
    }
}
