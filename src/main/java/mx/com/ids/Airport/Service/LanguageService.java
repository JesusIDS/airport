package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Model.Language;

import java.util.List;

public interface LanguageService {
    Language findById(long id);
    List<Language> findAll();
    Language updateLanguage(Language language);
    void deleteLanguage(long id);
    Language createLanguage(Language language);
}
