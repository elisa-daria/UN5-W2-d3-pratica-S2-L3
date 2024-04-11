package elisadaria.UN5W2d3praticaS2L3.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestEx extends RuntimeException{
        private List<ObjectError> errors;
        public BadRequestEx(String message){
            super(message);
        }

        public BadRequestEx(List<ObjectError> errors){
            super("errori di validazione nel payload!");
            this.errors = errors;
        }
}
