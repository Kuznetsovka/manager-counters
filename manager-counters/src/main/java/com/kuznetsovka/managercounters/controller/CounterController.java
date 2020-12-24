package com.kuznetsovka.managercounters.controller;

import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.EntityNotFoundResponse;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.exception.EntityNotFoundException;
import com.kuznetsovka.managercounters.repo.ValueRepository;
import com.kuznetsovka.managercounters.service.mediator.Mediator;
import com.kuznetsovka.managercounters.service.value.ValueService;
import org.springframework.data.domain.Sort;
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
    private final ValueService valueService;
    private final ValueRepository valueRepository;
    private HouseDto newHouse;
    private List<CounterDto> list = new ArrayList<> ();
    private Long regionId;

    public CounterController(Mediator mediator, ValueService valueService, ValueRepository valueRepository) {
        this.mediator = mediator;
        this.valueService = valueService;
        this.valueRepository = valueRepository;
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
        model.addAttribute("counters", list);
        model.addAttribute("counter", new CounterDto ());
        return "addCounter";
    }

    // http://localhost:8090/counter/newValue - GET
    @GetMapping("/newValue")
    public String newValue(Model model){
        System.out.println("Called method newHouse");
        model.addAttribute("value", new ValueDto ());
        return "addValue";
    }

    // http://localhost:8090/counter/newValue - POST
    @PostMapping(value = "/newValue")
    public String saveHouse(ValueDto dto, Model model){
        if(valueService.save(dto)){
            model.addAttribute("values", valueRepository.findAll ());
            return "redirect:/history";
        } else {
            model.addAttribute("value", dto);
            return "addValue";
        }
    }

    // http://localhost:8090/counter/value/SortByAsc - GET
    @RequestMapping("/value/SortByAsc")
    public String filterByMaxPriceProduct(Model model){
        List<Value> values = valueRepository.findAll (Sort.by("date").descending ());
        model.addAttribute("products", values);
        return "values";
    }

    // http://localhost:8090/counter/value/SortByAsc - GET
    @RequestMapping("/value/SortByDes")
    public String filterByMinPriceProduct(Model model){
        List<Value> values = valueRepository.findAll (Sort.by("date").ascending());
        model.addAttribute("products", values);
        return "values";
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
