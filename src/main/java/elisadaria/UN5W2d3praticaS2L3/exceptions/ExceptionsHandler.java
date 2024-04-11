package elisadaria.UN5W2d3praticaS2L3.exceptions;

import elisadaria.UN5W2d3praticaS2L3.payloads.ErrorsPayloadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayloadDTO handle404 (NotFoundException ex){
        return new ErrorsPayloadDTO(ex.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(BadRequestEx.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    public ErrorsPayloadDTO handleBadRequest(BadRequestEx ex){
        if(ex.getErrors()!= null) {

            String msg = ex.getErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". " ));
            return new ErrorsPayloadDTO(msg, LocalDateTime.now());

        } else {

            return new ErrorsPayloadDTO(ex.getMessage(), LocalDateTime.now());
        }
    }
}
