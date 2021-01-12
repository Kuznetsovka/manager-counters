package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.dto.ValuesCreationDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.service.user.UserService;
import com.kuznetsovka.managercounters.service.value.ValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/values")
public class ValueController {
    private final UserService userService;
    private final ValueService valueService;

    public ValueController(UserService userService, ValueService valueService) {
        this.userService = userService;
        this.valueService = valueService;
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model, Principal principal) {
        User user = userService.findByName (principal.getName ());
        model.addAttribute("user", user);
        List<Counter> counters = user.getHouses ().get (0).getCounters ();
        ValuesCreationDto valuesForm = new ValuesCreationDto();
        valuesForm.addValues (counters);
        valueService.saveAll(valuesForm.getValues ());
        model.addAttribute("form", valuesForm);
        return "addValue";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute ValuesCreationDto form, Model model) {
        valueService.saveAll(form.getValues ());

        model.addAttribute("values", valueService.findAll());
        return "redirect:/manager";
    }

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex){
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setEntityName(ex.getEntityName());
        response.setEntityId(ex.getEntityId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<> (response, HttpStatus.NOT_FOUND);
    }

}
