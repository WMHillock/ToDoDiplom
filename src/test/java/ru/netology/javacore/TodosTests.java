package ru.netology.javacore;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

public class TodosTests {
    Todos sut;

    @BeforeAll
    public static void startTests() {
        System.out.println("Тестируем методы Todos.class ...");
    }

    @AfterAll
    public static void finishTests() {
        System.out.println("Все методы протестированы!");
    }

    @BeforeEach
    public void startTest() {
        sut = new Todos();
        System.out.println("Начинаем проверку ...");
    }

    @AfterEach
    public void finishTest() {
        System.out.println("Проверка завершена!");
    }

    @Test
    public void getAllTasksTest() {
        String task1 = "Работа";
        String task2 = "Программирование";
        String task3 = "Спорт";
        String expected = "Программирование Работа Спорт";

        sut.addTask(task1);
        sut.addTask(task2);
        sut.addTask(task3);
        String result = sut.getAllTasks();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTaskTest() {
        Todos todos = Mockito.spy(Todos.class);
        todos.addTask("Программирование");
        Mockito.verify(todos).addTask("Программирование");
    }

    @Test
    public void removeTaskTest() {
        Todos todos = Mockito.spy(Todos.class);
        todos.removeTask("Программирование");
        Mockito.verify(todos).removeTask("Программирование");
    }
}