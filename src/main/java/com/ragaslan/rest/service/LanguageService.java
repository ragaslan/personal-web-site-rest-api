package com.ragaslan.rest.service;


import com.ragaslan.rest.entity.Language;

import java.util.List;

public interface LanguageService {
    List<Language> findAll();
    List<Language> findAllTools();
    Language findById(Integer id);
    void deleteById(Integer id);
    Language updateById(Integer id,Language lang);
    Language create(Language lang);

}
