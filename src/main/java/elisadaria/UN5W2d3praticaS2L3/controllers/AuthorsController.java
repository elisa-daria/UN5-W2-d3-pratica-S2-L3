package elisadaria.UN5W2d3praticaS2L3.controllers;


import elisadaria.UN5W2d3praticaS2L3.entities.Author;
import elisadaria.UN5W2d3praticaS2L3.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorsService authorsService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Author saveAuthor(@RequestBody Author body) throws Exception {
        System.out.println(body);
        return authorsService.save(body);
    }


    @GetMapping("")
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "15")int size,@RequestParam(defaultValue = "name")String sortBy ) {
        return authorsService.getAuthors(page,size,sortBy);
    }

//    // 3. - GET http://localhost:3001/authors/{id}
//    @GetMapping("/{authorId}")
//    public Author findById(@PathVariable int authorId) throws Exception {
//        return authorsService.findById(authorId);
//    }
//
//    // 4. - PUT http://localhost:3001/authors/{id} (+ req.body)
//    @PutMapping("/{authorId}")
//    public Author findAndUpdate(@PathVariable int authorId, @RequestBody Author body) throws Exception {
//        return authorsService.findByIdAndUpdate(authorId, body);
//    }
//
//    // 5. - DELETE http://localhost:3001/authors/{id}
//    @DeleteMapping("/{authorId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
//    public void findAndDelete(@PathVariable int authorId) {
//        authorsService.findByIdAndDelete(authorId);
//    }
}
