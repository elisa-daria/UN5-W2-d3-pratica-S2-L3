package elisadaria.UN5W2d3praticaS2L3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Blogpost {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
}
