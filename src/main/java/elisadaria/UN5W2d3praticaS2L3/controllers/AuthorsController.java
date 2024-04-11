package elisadaria.UN5W2d3praticaS2L3.controllers;


import com.cloudinary.utils.ObjectUtils;
import elisadaria.UN5W2d3praticaS2L3.entities.Author;
import elisadaria.UN5W2d3praticaS2L3.exceptions.BadRequestEx;
import elisadaria.UN5W2d3praticaS2L3.payloads.AuthorPayload;
import elisadaria.UN5W2d3praticaS2L3.payloads.NewAutRESP;
import elisadaria.UN5W2d3praticaS2L3.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorsService authorsService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public NewAutRESP saveAuthor(@RequestBody @Validated AuthorPayload body, BindingResult validation) {
        if(validation.hasErrors()){
            throw new BadRequestEx(validation.getAllErrors());
        }
        return new NewAutRESP(this.authorsService.save(body).getId());
    }


    @GetMapping("")
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "15")int size,@RequestParam(defaultValue = "name")String sortBy ) {
        return authorsService.getAuthors(page,size,sortBy);
    }


    @GetMapping("/{authorId}")
    public Author findById(@PathVariable int authorId) throws Exception {
        return authorsService.findById(authorId);
    }
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

    @PostMapping("/upload")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile image) throws IOException {
        return this.authorsService.uploadImage(image);

    }

}
