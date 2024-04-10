package elisadaria.UN5W2d3praticaS2L3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;
}
