package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.service.house.HouseService;
import com.kuznetsovka.managercounters.service.user.UserService;
import com.kuznetsovka.managercounters.service.value.ValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ValueController {

    private final ValueService valueService;

    @GetMapping("/newValue")
    public String newHouse(Model model){
        System.out.println("Called method newHouse");
        model.addAttribute("value", new ValueDto ());
        return "addValue";
    }

    @PostMapping(value = "/newValue")
    public String saveHouse(ValueDto dto, Model model){
        if(valueService.save(dto)){
            return "redirect:/manager";
        } else {
            model.addAttribute("value", dto);
            return "addValue";
        }
    }

    public ValueController( ValueService valueService) {
        this.valueService = valueService;
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
