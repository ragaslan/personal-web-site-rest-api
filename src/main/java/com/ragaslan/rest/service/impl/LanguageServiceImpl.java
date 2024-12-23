package com.ragaslan.rest.service.impl;

import com.ragaslan.rest.dao.LanguageDAO;
import com.ragaslan.rest.entity.Language;
import com.ragaslan.rest.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageDAO languageDAO;

    @Autowired
    public LanguageServiceImpl(LanguageDAO languageDAO){
        this.languageDAO = languageDAO;
    }

    @Override
    public List<Language> findAll() {
        return languageDAO.findAll();
    }

    @Override
    public List<Language> findAllTools() {
        return languageDAO.findAllTools();
    }

    @Override
    public Language findById(Integer id) {
        return languageDAO.findById(id);
    }

    @Override
    @Transactional
    public Language create(Language lang) {
        languageDAO.save(lang);
        return lang;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Language theLang = languageDAO.findById(id);
        if(theLang == null){
            throw new RuntimeException("There is no language with this id !");
        }
        languageDAO.delete(id);
    }

    @Override
    @Transactional
    public Language updateById(Integer id, Language lang) {
        Language originalLang = languageDAO.findById(id);
        if(originalLang == null){
            throw new RuntimeException("There is no language with this id !");
        }
        originalLang.setName(lang.getName());
        languageDAO.update(originalLang);
        return originalLang;
    }
}
