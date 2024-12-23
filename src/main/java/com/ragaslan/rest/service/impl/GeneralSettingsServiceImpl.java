package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.GeneralSettingsDAO;
import com.ragaslan.rest.entity.GeneralSettings;
import com.ragaslan.rest.service.GeneralSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneralSettingsServiceImpl implements GeneralSettingsService {

    private final GeneralSettingsDAO generalSettingsDAO;

    @Autowired
    public GeneralSettingsServiceImpl(GeneralSettingsDAO generalSettingsDAO){
        this.generalSettingsDAO = generalSettingsDAO;
    }


    @Override
    public GeneralSettings getSettings() {
        GeneralSettings settings = generalSettingsDAO.findFirst();
        if (settings == null){
            throw new RuntimeException("There are no settings ! Please create settings !");
        }
        return settings;
    }

    @Transactional
    @Override
    public void setSettings(GeneralSettings settings){
        generalSettingsDAO.setSettings(settings);
    }
}
