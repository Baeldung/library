package com.baeldung.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.baeldung.library.domain.Author;
import com.baeldung.library.domain.Book;
import com.baeldung.library.repo.AuthorRepository;
import com.google.common.collect.Lists;

@SpringBootApplication
public class LibraryApplication {

    @Autowired
    private AuthorRepository authorRepo;

    @Component
    class DataSetup implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            final Book goneWithTheWindBook = Book.builder().title("Gone with the Wind").isbn("9787806571491").build();
            final Author goneWithTheWindAuthor = Author.builder().name("Margaret Mitchell").books(Lists.newArrayList(goneWithTheWindBook)).build();

            authorRepo.save(goneWithTheWindAuthor);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
