package mx.com.ids.Airport.Controller;

import mx.com.ids.Airport.Exception.Mensaje;
import mx.com.ids.Airport.Model.Language;
import mx.com.ids.Airport.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.ok().body("LANGUAGE CONTROLLER");
    }

    @Autowired
    private LanguageService languageService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<Language> lista = languageService.findAll();
        if(lista.isEmpty()){
            return new ResponseEntity<>(new Mensaje("Sin lenguajes en la Base de Datos"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(languageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(languageService.findById(id));
    }

    @PutMapping("/update_language/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language) {
        language.setLanguage_id(id);
        return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
    }

    @DeleteMapping("/delete_language/{id}")
    public HttpStatus deleteLanguage(@PathVariable long id) {
        this.languageService.deleteLanguage(id);
        return HttpStatus.OK;
    }
}
