package elisadaria.UN5W2d3praticaS2L3.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import elisadaria.UN5W2d3praticaS2L3.entities.Author;
import elisadaria.UN5W2d3praticaS2L3.exceptions.BadRequestEx;
import elisadaria.UN5W2d3praticaS2L3.exceptions.NotFoundException;
import elisadaria.UN5W2d3praticaS2L3.payloads.AuthorPayload;
import elisadaria.UN5W2d3praticaS2L3.repositories.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Service
public class AuthorsService {

    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public Author save(AuthorPayload author) {
        this.authorDAO.findByEmail(author.email()).ifPresent(author1 -> {throw new BadRequestEx("L'email "+author1.getEmail()+" è già in uso");
        });
        Author newA=new Author(author.name(), author.surname(), author.email(), author.dateOfBirth(),
       "https://ui-avatars.com/api/?name="+ author.name() + "+" + author.surname());
        return this.authorDAO.save(newA);

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
public String uploadImage(MultipartFile image) throws IOException {
    String url = (String) cloudinaryUploader.uploader().upload(image.getBytes(), ObjectUtils.emptyMap()).get("url");
    return url;
}
}
