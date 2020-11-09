package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.model.PeModel;
import com.ippsby.publicnews.repository.PeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pe")
public class PeController {

    @Autowired
    private PeRepository peRepository;

    @GetMapping("/all")
    public List <PeModel> getAllPe() {
       return peRepository.findAll();

    }
   // @PostMapping("/add")
  //  public @ResponseBody
   // String addNewPe(@RequestParam long peId ,
       //             @RequestParam String name ,
      //              RequestParam String fullName ,
      //              RequestParam String description ,
        //            RequestParam long themeId ,
       //             RequestParam long newsId) {


       // PeModel pe = new PeModel();
        //pe.setPeId(peId);
      //  pe.setName(name);
     //   pe.setDescription(description);
     //   pe.setFullName(fullName);
      //  PeRepository.save(pe);
     //   return "Saved";
    //}

}
