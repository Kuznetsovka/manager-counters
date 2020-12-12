package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
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
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/counter")
public class CounterController {
    private Mediator mediator;
    private final UserService userService;
    private final HouseService houseService;
    private final RegionServiceProxy regionService;
    private List<CounterDto> list = new LinkedList<> ();
    private HouseDto newHouse;
    private Long regionId;
    public CounterController(Mediator mediator, UserService userService, HouseService houseService, RegionServiceProxy regionService) {
        this.mediator = mediator;
        this.userService = userService;
        this.houseService = houseService;
        this.regionService = regionService;
    }
    @PostMapping("/newCounters")
    public String newCounter(Model model,
                             HouseDto houseDto,
                             @RequestParam(name ="regionID") Long regionID){
        System.out.println("Called method newCounter");
        regionId = regionID;
        newHouse = houseDto;
        for (int i = 0; i < houseDto.getCountCounter (); i++) {
            list.add (new CounterDto ());
        }
        model.addAttribute("counters", list);
        return "addCounter";
    }
    @GetMapping("/newCounters")
    public String getNewCounter(Model model){
        return "addHouse";
    }

    @PostMapping(value = "/saveCounters")
    public String saveCounter(Model model,
                              @RequestParam(name = "listCounters")  List<CounterDto> listCounterDto,
                              Principal principal){
        if(mediator.addHouse (newHouse,listCounterDto,regionId,principal.getName ())){
            return "redirect:/manager";
        } else {
            model.addAttribute("counters", list);
            return "addCounter";
        }
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
