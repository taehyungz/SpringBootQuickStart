package com.rubypaper.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //전역 예외처리
public class GlobalExceptionHandler {
    @ExceptionHandler(BoardException.class)
    public String handleCustomExcption(BoardException exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/boardError";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "/errors/globalError";
    }

}
