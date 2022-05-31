package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    static class Request {

        String type;
        String task;

        public Request(String type, String task) {
            this.type = type;
            this.task = task;
        }
    }

    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("\nStarting server at " + port);
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String clientMsg = in.readLine();
                    Request request = new Gson().fromJson(clientMsg, Request.class);
                    switch (request.type) {
                        case "ADD":
                            todos.addTask(request.task);
                            break;
                        case "REMOVE":
                            todos.removeTask(request.task);
                            break;
                        default:
                            System.out.println("Неверный запрос...");
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}

