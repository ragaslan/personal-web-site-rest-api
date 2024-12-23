package com.ragaslan.rest.dao;

import com.ragaslan.rest.entity.Language;

import java.util.List;

public interface LanguageDAO {
        void save(Language lang);
        Language findById(Integer id);
        List<Language> findAll();
        void update(Language lang);
        void delete(Integer id);
        List<Language> findAllTools();
}
