package elisadaria.UN5W2d3praticaS2L3.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AuthorPayload(
        @NotEmpty(message = "il nome è un campo obbligatorio")
        @Size(max = 30, message = "massimo caratteri:30")
        String name,
        @NotEmpty(message = "il cognome è un campo obbligatorio")
        @Size(max = 30, message = "massimo caratteri:30")
        String surname,
        @NotEmpty(message = "email obbligatoria")
        @Email(message = "email non valida")
        String email,
        @NotEmpty(message = "data di nascita obbligatoria")
        String dateOfBirth
) {
}
