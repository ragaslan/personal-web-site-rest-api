package com.ragaslan.rest.service;

import com.ragaslan.rest.entity.GeneralSettings;

public interface GeneralSettingsService {
    GeneralSettings getSettings();
    void setSettings(GeneralSettings settings);
}
