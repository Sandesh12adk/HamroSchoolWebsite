package com.project.hamroschool.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception) {
        // This method will be invoked whenever an exception occurs in the entire project
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");  // Ensure you have an "error.html" or "error.jsp" view
        mav.addObject("error", exception.getMessage());
        return mav;
    }
}
