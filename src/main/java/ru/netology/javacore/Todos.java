package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private final List<String> todos;

    public Todos() {
        todos = new ArrayList<>();
    }

    public void addTask(String task) {
        if (todos.contains(task)) {
            System.out.println(task + " уже есть в списке дел");
        } else {
            todos.add(task);
            System.out.println("Вы запланировали - " + task);
        }
    }

    public void removeTask(String task) {
        if (todos.contains(task)) {
            todos.remove(task);
            System.out.println("Вы удалили задачу - " + task);
        } else {
            System.out.println(task + " отсутствует в списке дел");
        }
    }

    public String getAllTasks() {
        return todos.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }
}
