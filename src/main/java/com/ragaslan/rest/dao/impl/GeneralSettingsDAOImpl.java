package com.ragaslan.rest.dao.impl;

import com.ragaslan.rest.dao.GeneralSettingsDAO;
import com.ragaslan.rest.entity.GeneralSettings;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralSettingsDAOImpl implements GeneralSettingsDAO {

    private final EntityManager entityManager;

    public GeneralSettingsDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public GeneralSettings findFirst(){

        return entityManager.find(GeneralSettings.class,1);

    }

    @Override
    public void setSettings(GeneralSettings settings){
        GeneralSettings settingsFromDb = this.findFirst();
        if(settingsFromDb == null){
            entityManager.persist(settings);
        }else{
            settingsFromDb.setEmail(settings.getEmail());
            settingsFromDb.setGithub(settings.getGithub());
            settingsFromDb.setYoutube(settings.getYoutube());
            settingsFromDb.setLinkedin(settings.getLinkedin());
            settingsFromDb.setWhoami(settings.getWhoami());
            entityManager.merge(settingsFromDb);
        }
    }

}
