package com.company;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UsersRepository {
    private String fileName;
    private IdGenerator idGenerator;

    public UsersRepository(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public void save(User user) {
        try {
            user.setId(idGenerator.generate());
            OutputStream outputStream = new FileOutputStream(fileName, true);
            String userLine = user.toString() + "\n";
            outputStream.write(userLine.getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public User[] findAll() {
        User user [] = new User [];
        try {
            Reader reader = new FilerReader (fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

        }
     return null;
    }
}