package dungeonmart.ref.v35.classes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bdelude on 3/18/16.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterClassNotFoundException extends RuntimeException {
}
