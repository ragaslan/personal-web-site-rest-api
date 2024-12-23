package com.ragaslan.rest.controller;

import com.ragaslan.rest.entity.Language;
import com.ragaslan.rest.service.LanguageService;
import com.ragaslan.rest.dto.LanguageDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Language>> findAll(){
        return new ResponseEntity<>(languageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/tools/")
    public ResponseEntity<List<Language>> findAllTools(){
        return new ResponseEntity<>(languageService.findAllTools(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> findOne(@PathVariable Integer id){
        Language theLang = languageService.findById(id);
        if(theLang == null){
            throw new RuntimeException("There is no language with this id");
        }
        return new ResponseEntity<>(theLang,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Language> create(@Valid @RequestBody LanguageDTO languageDTO){
        ModelMapper mapper = new ModelMapper();
        Language theLang = mapper.map(languageDTO,Language.class);
        Language createdLang = languageService.create(theLang);
        return new ResponseEntity<>(createdLang,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        languageService.deleteById(id);
        return new ResponseEntity<>("The language is deleted successfully !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> update(@PathVariable Integer id,@Valid @RequestBody LanguageDTO languageDTO){
        ModelMapper mapper = new ModelMapper();
        Language theLang = mapper.map(languageDTO,Language.class);
        Language updatedLang = languageService.updateById(id,theLang);
        return new ResponseEntity<>(updatedLang,HttpStatus.OK);
    }
}
