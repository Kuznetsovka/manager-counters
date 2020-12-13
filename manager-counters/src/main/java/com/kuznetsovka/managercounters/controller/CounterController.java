package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.registry.IdentityMap;
import com.kuznetsovka.managercounters.registry.Registry;
import com.kuznetsovka.managercounters.registry.UnitOfWork;
import com.kuznetsovka.managercounters.service.counter.CounterService;
import com.kuznetsovka.managercounters.service.house.HouseService;
import com.kuznetsovka.managercounters.service.mediator.Mediator;
import com.kuznetsovka.managercounters.service.region.RegionServiceProxy;
import com.kuznetsovka.managercounters.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/counter")
public class CounterController {
    private Mediator mediator;
    private final UserService userService;
    private final HouseService houseService;
    private final RegionServiceProxy regionService;
    private final CounterService counterService;
    private HouseDto newHouse;
    private List<CounterDto> list = new ArrayList<> ();
    private Long regionId;
    public CounterController(Mediator mediator, UserService userService, HouseService houseService, RegionServiceProxy regionService, CounterService counterService) {
        this.mediator = mediator;
        this.userService = userService;
        this.houseService = houseService;
        this.regionService = regionService;
        this.counterService = counterService;
    }

    @GetMapping
    public String userList(Model model){
        model.addAttribute("counters", list);
        return "addCounter";
    }


    @PostMapping("/newCounters")
    public String newCounters(Model model,
                             HouseDto houseDto,
                             @RequestParam(name ="regionID") Long regionID){
        System.out.println("Called method newCounter");
        regionId = regionID;
        newHouse = houseDto;
        //Registry.getInstance ().getIdentityMap ().init();
        model.addAttribute("counter", new CounterDto ());
        return "addCounter";
    }

    @PostMapping(value = "/continue")
    public String continueAddHouse(Model model, Principal principal){
        if(mediator.addHouse (newHouse,list,regionId,principal.getName ())){
            return "redirect:/manager";
        } else {
            model.addAttribute("counters", list);
            return "addCounter";
        }
    }

    @PostMapping(value = "/saveCounter")
    public String saveCounter(Model model,  CounterDto counterDto, Principal principal){
        list.add(counterDto);
        //Registry.getInstance ().getIdentityMap ().getCurrent ().add (counterService.getCounterByDto(counterDto));
        model.addAttribute("counters", list);
        model.addAttribute("counter", new CounterDto ());
        return "addCounter";
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
