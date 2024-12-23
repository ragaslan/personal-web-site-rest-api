package com.ragaslan.rest.controller;

import com.ragaslan.rest.entity.GeneralSettings;
import com.ragaslan.rest.service.GeneralSettingsService;
import com.ragaslan.rest.dto.GeneralSettingsDTO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class GeneralSettingsController {

    private final GeneralSettingsService generalSettingsService;

    public GeneralSettingsController(GeneralSettingsService generalSettingsService){
        this.generalSettingsService = generalSettingsService;
    }

    @GetMapping("/")
    public ResponseEntity<GeneralSettings> getSettings(){
        GeneralSettings settings = generalSettingsService.getSettings();
        return new ResponseEntity<>(settings,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<GeneralSettings> setSettings(@Valid @RequestBody GeneralSettingsDTO settingsFromUser){
        ModelMapper mapper = new ModelMapper();
        GeneralSettings settings = mapper.map(settingsFromUser,GeneralSettings.class);
        generalSettingsService.setSettings(settings);
        return new ResponseEntity<>(settings,HttpStatus.CREATED);
    }

}
