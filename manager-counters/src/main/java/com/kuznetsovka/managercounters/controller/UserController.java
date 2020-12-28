package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.*;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.service.house.HouseService;
import com.kuznetsovka.managercounters.service.mediator.Mediator;
import com.kuznetsovka.managercounters.service.region.RegionServiceProxy;
import com.kuznetsovka.managercounters.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class UserController {
    private final UserService userService;
    private final HouseService houseService;
    private final RegionServiceProxy regionService;

    @GetMapping
    public String manager(Model model, Principal principal){
        User user = userService.findByName (principal.getName ());
        model.addAttribute("user", user);
        List<Counter> counters = user.getHouses ().get (0).getCounters ();
        model.addAttribute("counters", counters);
//        HouseDto house;
//        if (user.getHouses ().isEmpty ()) {
//            house = new HouseDto ();
//        } else {
//            house = houseService.getHouseByDto (houseService.findByUser(user));
//        }
//        model.addAttribute("house", house);
        return "manager";
    }

    @GetMapping("/newHouse")
    public String newHouse(Model model){
        System.out.println("Called method newHouse");
        model.addAttribute("house", new HouseDto ());
        List<Region> regions = regionService.getAll ();
        model.addAttribute("regions", regionService.getListDto(regions));
        return "addHouse";
    }

    public UserController(UserService userService, HouseService houseService, RegionServiceProxy regionService) {
        this.userService = userService;
        this.houseService = houseService;
        this.regionService = regionService;
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
