package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.service.PeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pe")
public class PeController {

    private final PeService peService;

    public PeController(PeService peService) {
        this.peService = peService;
    }

    @GetMapping("/all")
    public List<Pe> getAllPe() {
        return peService.findAll();

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Pe> addNewPE(@RequestBody Pe pe) {
        peService.save(pe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pe/{peId}")
    public Pe getPeById(@PathVariable Pe peId) {
        return peId;
    }
}
