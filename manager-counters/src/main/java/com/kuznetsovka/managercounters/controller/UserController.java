package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.service.house.HouseService;
import com.kuznetsovka.managercounters.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/manager")
public class UserController {

    private final UserService userService;
    private HouseService houseService;

    @GetMapping
    public String manager(Model model, Principal principal){
        model.addAttribute("user", userService.findByName (principal.getName ()));
        return "manager";
    }

    @GetMapping("/newHouse")
    public String newHouse(Model model){
        System.out.println("Called method newHouse");
        model.addAttribute("house", new HouseDto ());
        return "addHouse";
    }

    @PostMapping(value = "/newHouse")
    public String saveHouse(HouseDto dto, Model model){
        if(houseService.save(dto)){
            return "redirect:/manager";
        } else {
            model.addAttribute("house", dto);
            return "addHouse";
        }
    }

    public UserController(UserService userService) {
        this.userService = userService;
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
