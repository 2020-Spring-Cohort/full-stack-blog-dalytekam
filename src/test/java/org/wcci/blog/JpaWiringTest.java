package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.blog.dao.AuthorRepository;
import org.wcci.blog.dao.CategoryRepository;
import org.wcci.blog.dao.PostRepository;
import org.wcci.blog.dao.TagRepository;
import org.wcci.blog.entities.Author;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class JpaWiringTest {

    @DataJpaTest
    public class JpaWiringTest {
        @Autowired
        private AuthorRepository authorRepository;
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private PostRepository postRepository;
        @Autowired
        private TagRepository tagRepository;
        @Autowired
        private TestEntityManager entityManager;
        @Test


        public void () {
            Campus testCampus = new Campus("Testville");
            Author testAuthor1 = new Author("Testy", "McTesterson");

            Book testBook = new Book("Title", "Test Description", testCampus, testAuthor1);
            authorRepo.save(testAuthor1);
            campusRepo.save(testCampus);
            bookRepo.save(testBook);

            entityManager.flush();
            entityManager.clear();

            Optional<Campus> retrievedCampusOptional = campusRepo.findById(testCampus.getId());
            Campus retrievedCampus = retrievedCampusOptional.get();
            Book retrievedBook = bookRepo.findById(testBook.getId()).get();

            assertThat(retrievedCampus.getBooks()).contains(testBook);

        }

        @Test
        public void booksShouldBeAbleToHaveMultipleAuthors() {
            Author testAuthor1 = new Author("Testy", "McTesterson");
            Author testAuthor2 = new Author("Bobby", "Testerson");
            Campus testCampus = new Campus("Test Town");
            Book testBook1 = new Book("Title1", "Test Description", testCampus, testAuthor1, testAuthor2);
            Book testBook2 = new Book("Title2", "Test Description", testCampus, testAuthor2);
            Book testBook3 = new Book("Title3", "Test Description", testCampus, testAuthor1);
            authorRepo.save(testAuthor1);
            authorRepo.save(testAuthor2);
            campusRepo.save(testCampus);
            bookRepo.save(testBook1);
            bookRepo.save(testBook2);
            bookRepo.save(testBook3);

            entityManager.flush();
            entityManager.clear();

            Book retrievedBook = bookRepo.findById(testBook1.getId()).get();
            Author retrievedAuthor1 = authorRepo.findById(testAuthor1.getId()).get();
            Author retrievedAuthor2 = authorRepo.findById(testAuthor2.getId()).get();
            assertThat(retrievedBook.getAuthors()).contains(testAuthor1, testAuthor2);
            assertThat(retrievedAuthor1.getBooks()).contains(testBook1, testBook3);
            assertThat(retrievedAuthor2.getBooks()).contains(testBook1, testBook2);
        }

        @Test
        public void booksShouldHaveHashTags(){
            Author testAuthor1 = authorRepo.save(new Author("Testy", "McTesterson"));
            Campus testCampus = campusRepo.save(new Campus("Test Town"));
            Book testBook1 = bookRepo.save(new Book("Title1", "Test Description", testCampus, testAuthor1));
            Book testBook2 = bookRepo.save(new Book("Another Title", "Another Description", testCampus, testAuthor1));
            Book testBook3 = bookRepo.save(new Book("Yet Another Book", "Yet another description", testCampus, testAuthor1));
            HashTag testHashTag1 = hashTagRepo.save(new HashTag("Dude"));
            HashTag testHashTag2 = hashTagRepo.save(new HashTag("Sweet"));
            HashTag testHashTag3 = hashTagRepo.save(new HashTag("#Dude"));
            testBook1.addHashTag(testHashTag1);
            testBook1.addHashTag(testHashTag2);
            bookRepo.save(testBook1);
            testBook2.addHashTag(testHashTag3);
            testBook2.addHashTag(testHashTag1);
            bookRepo.save(testBook2);

            entityManager.flush();
            entityManager.clear();

            Book retreivedBook1 = bookRepo.findById(testBook1.getId()).get();
            Book retreivedBook2 = bookRepo.findById(testBook2.getId()).get();

            assertThat(retreivedBook1.getHashTags()).contains(testHashTag1, testHashTag2);
            assertThat(retreivedBook2.getHashTags()).contains(testHashTag1, testHashTag3);
        }
    }






}
