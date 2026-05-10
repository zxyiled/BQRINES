package org.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles insufficient stock during a sale — redirects back with an error message
    @ExceptionHandler(StockInsuficienteException.class)
    public String handleStockInsuficiente(StockInsuficienteException ex,
                                          RedirectAttributes flash,
                                          HttpServletRequest request) {
        flash.addFlashAttribute("error", ex.getMessage());
        // Redirect back to the page that triggered the error
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/sells/new");
    }

    // Handles any entity not found (vehicle, spare, user)
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex,
                                         RedirectAttributes flash,
                                         HttpServletRequest request) {
        flash.addFlashAttribute("error", ex.getMessage());
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/dashboard");
    }
}