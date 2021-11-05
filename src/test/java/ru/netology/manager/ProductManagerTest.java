package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Name1", 500, "Author1");
    Product book2 = new Book(2, "Name2", 600, "Author2");
    Product book3 = new Book(3, "Name3", 700, "Author3");
    Product smartphone1 = new Smartphone(4, "Name1", 1000, "Manufacturer1");
    Product smartphone2 = new Smartphone(5, "Name2", 1500, "Manufacturer2");
    Product smartphone3 = new Smartphone(6, "Name3", 2000, "Manufacturer3");


    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }


    @Test
    public void shouldSearchByName() {
        Product[] expected = {book3, smartphone3};
        Product[] actual = manager.searchBy("Name3");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Author1");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Manufacturer2");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Name8");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Author15");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindManufacturer() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Manufacturer26");
        assertArrayEquals(expected, actual);
    }
}

