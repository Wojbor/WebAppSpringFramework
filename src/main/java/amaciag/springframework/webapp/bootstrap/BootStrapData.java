package amaciag.springframework.webapp.bootstrap;

import amaciag.springframework.webapp.domain.Author;
import amaciag.springframework.webapp.domain.Book;
import amaciag.springframework.webapp.domain.Publisher;
import amaciag.springframework.webapp.repositories.AuthorRespository;
import amaciag.springframework.webapp.repositories.BookRespository;
import amaciag.springframework.webapp.repositories.PublisherRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRespository authorRespository;
    private final BookRespository bookRespository;
    private final PublisherRespository publisherRespository;

    public BootStrapData(AuthorRespository authorRespository, BookRespository bookRespository, PublisherRespository publisherRespository) {
        this.authorRespository = authorRespository;
        this.bookRespository = bookRespository;
        this.publisherRespository = publisherRespository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Strated in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine1("Poland");
        publisher.setCity("Warsaw");
        publisher.setState("Maz");
        publisher.setZip("00-000");

        publisherRespository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRespository.save(eric);
        bookRespository.save(ddd);
        publisherRespository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "872346598237465");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        publisher.getBooks().add(noEJB);

        authorRespository.save(rod);
        bookRespository.save(noEJB);
        publisherRespository.save(publisher);


        System.out.println("Publisher count: " + publisherRespository.count());
        System.out.println("Numbers of Books: " + bookRespository.count());
        System.out.println("Publisher numbers of books: " + publisher.getBooks().size());



    }
}
