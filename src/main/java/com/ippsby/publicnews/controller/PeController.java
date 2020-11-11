package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.PeModel;
import com.ippsby.publicnews.service.PeService;
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
    public List<PeModel> getAllPe() {
        return peService.findAll();

    }

    @PostMapping("/add")
    public @ResponseBody String addNewPe(
            @RequestBody PeModel peModel) {
        peService.save(peModel);
        return "Saved";
    }

}
