package com.ragaslan.rest.dao;

import com.ragaslan.rest.entity.GeneralSettings;
import jakarta.persistence.EntityManager;

public interface GeneralSettingsDAO {
    GeneralSettings findFirst();
    void setSettings(GeneralSettings settings);
}
