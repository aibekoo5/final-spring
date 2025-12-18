package com.aibek.finalspring.controller;

import com.aibek.finalspring.dto.NationDto;
import com.aibek.finalspring.service.NationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nation")
public class NationController {
    private final NationService nationService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(nationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(nationService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNation(@RequestBody NationDto nationDto){
        nationService.createNation(nationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNation(@PathVariable(name = "id") Long id, @RequestBody NationDto nationDto){
        nationService.updateNation(id, nationDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNation(@PathVariable(name = "id") Long id){
        nationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
