package elisadaria.UN5W2d3praticaS2L3.services;


import elisadaria.UN5W2d3praticaS2L3.entities.Author;
import elisadaria.UN5W2d3praticaS2L3.exceptions.NotFoundException;
import elisadaria.UN5W2d3praticaS2L3.repositories.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorsService {

    @Autowired
    private AuthorDAO authorDAO;

    public Author save(Author author) {
        author.setAvatar("https://ui-avatars.com/api/?name="+ author.getName() + "+" + author.getSurname());
        return this.authorDAO.save(author);

    }

    public Page<Author> getAuthors(int page, int size, String sortBy) {
        if(size>50)size=50;
        Pageable pageable= PageRequest.of(page,size,Sort.by(sortBy));
        return this.authorDAO.findAll(pageable);
    }

    public Author findById(int id) {
        return this.authorDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
//
//    public void findByIdAndDelete(int id) {
//        ListIterator<Author> iterator = this.authors.listIterator();
//
//        while (iterator.hasNext()) {
//            Author currentAuthor = iterator.next();
//            if (currentAuthor.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }

//    public Author findByIdAndUpdate(int id, Author author) {
//        Author found = null;
//
//        for (Author currentAuthor : authors) {
//            if (currentAuthor.getId() == id) {
//                found = currentAuthor;
//                found.setName(author.getName());
//                found.setSurname(author.getSurname());
//            }
//        }
//        if (found == null)
//            throw new NotFoundException(id);
//        return found;
//
//    }
}
