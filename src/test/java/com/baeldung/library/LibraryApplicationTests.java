package com.baeldung.library;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.emptyIterable;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.library.repo.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

    @Autowired
    private BookRepository bookRepo;

    @Test
    public void contextLoads() {
        //
    }

    @Test
    public void persistenceWorks() {
        bookRepo.findAll();
    }

    @Test
    public void dataExists() {
        assertThat(bookRepo.findAll(), not(emptyIterable()));
    }

}
