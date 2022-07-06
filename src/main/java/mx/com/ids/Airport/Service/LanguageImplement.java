package mx.com.ids.Airport.Service;

import mx.com.ids.Airport.Exception.ResourceNotFoundException;
import mx.com.ids.Airport.Model.Employee;
import mx.com.ids.Airport.Model.Language;
import mx.com.ids.Airport.Repository.LanguageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageImplement implements LanguageService{
    @Autowired
    private LanguageRep languageRep;

    @Override
    public Language findById(long id) {
        Optional<Language> languageDb = this.languageRep.findById(id);
        if (languageDb.isPresent()) {
            return languageDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Language> findAll() {
        return this.languageRep.findAll();
    }

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> languageDb = this.languageRep.findById(language.getLanguage_id());
        if (languageDb.isPresent()) {
            Language languageUpdate = languageDb.get();
            languageUpdate.setLanguage_id(language.getLanguage_id());
            languageUpdate.setCode(language.getCode());
            languageUpdate.setName(language.getName());
            return languageUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + language.getLanguage_id());
        }
    }

    @Override
    public void deleteLanguage(long id) {
        Optional<Language> languageDb = this.languageRep.findById(id);
        if (languageDb.isPresent()) {
            this.languageRep.delete(languageDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

}
