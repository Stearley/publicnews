package com.ippsby.publicnews.controller;

import com.ippsby.publicnews.dto.PeDto;
import com.ippsby.publicnews.model.Pe;
import com.ippsby.publicnews.model.Theme;
import com.ippsby.publicnews.repository.PeRepository;
import com.ippsby.publicnews.service.PeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.QueryHint;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/pe")
public class PeController {

    private final PeService peService;

    public PeController(PeService peService) {
        this.peService = peService;
    }

    @GetMapping
    public List<Pe> getAllPe() {
        return peService.findAll();

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Pe> addNewPE(@RequestBody Pe pe, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            peService.save(pe);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{peId}")
    public Pe getPeById(@PathVariable Pe peId) {
        return peId;
    }

    @DeleteMapping("/{peId}")
    public ResponseEntity<?> deletePe(@PathVariable Pe peId, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 1) {
            peService.delete(peId);
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping
    public ResponseEntity<?> updatePe(@RequestBody Pe pe, HttpServletRequest request) {
        if (Integer.parseInt(request.getHeader("Test")) > 4) {
            return new ResponseEntity<>(peService.save(pe), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}
