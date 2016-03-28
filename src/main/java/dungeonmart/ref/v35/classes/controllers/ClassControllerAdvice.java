package dungeonmart.ref.v35.classes.controllers;

import dungeonmart.ref.v35.classes.exceptions.CharacterClassNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClassControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CharacterClassNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors characterClassNotFoundExceptionHandler(CharacterClassNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
