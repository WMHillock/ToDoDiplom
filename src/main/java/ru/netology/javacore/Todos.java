package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    private List<String> todoList;
    public static int counterToDo;

    public Todos() {
        this.todoList = new ArrayList<>();
    }

    public void addTask(String task) {
        if (todoList.contains(task)) {
            System.out.println("Данная задача уже есть в списке дел");
        } else {
            todoList.add(task);
            System.out.println("Вы запланировали " + (counterToDo < 5 ? " дело " : " дел ") + task);
            counterToDo++;
        }
    }

    public void removeTask(String task) {
        if (todoList.contains(task)) {
            todoList.remove(task);
            counterToDo--;
            System.out.println("Вы удалили задачу " + task + " Осталось " + (counterToDo < 5 ? " дел " : " дело "));
        } else {
            System.out.println("Данная задача отсутствует в списке дел");
        }
    }

    public String getAllTasks() {
        return todoList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));
    }
}
