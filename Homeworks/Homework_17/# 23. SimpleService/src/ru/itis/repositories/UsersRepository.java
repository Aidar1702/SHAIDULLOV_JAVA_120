package ru.itis.repositories;

import ru.itis.models.User;
import ru.itis.models.UserRole;

import java.io.*;

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
    public User findOneById(int id) {
        User user = null;
        try {
            Reader reader = new FileReader("Users.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currentUserLine = bufferedReader.readLine();
            String[] userData = currentUserLine.split("\\|");
            User currentId = Integer.parseInt(userData[0]);
            while (currentUserLine != null) {
                userData = currentUserLine.split("\\|");

                String idString = userData[0];
                currentId = Integer.parseInt(userData[0]);
                if (currentId == id) {
                    user = currentId ;
                    break;
                }

                // переводишь String в int, сравниваешь с исходым айди и дальше делаешь объект

                String firstName = userData[1];
                String lastName = userData[2];
                String ageAsString = userData[3];
                String phone = userData[4];
                String email = userData[5];
                String login = userData[6];
                String password = userData[7];
                UserRole role = UserRole.valueOf(userData[8]);

                user = User.builder()
                        .login(login)
                        .password(password)
                        .id(Integer.parseInt(userData[0]))
                        .build();

                if (!firstName.equals("null")) {
                    user.setFirstName(firstName);
                }

                if (!lastName.equals("null")) {
                    user.setLastName(lastName);
                }

                if (!ageAsString.equals("null")) {
                    user.setAge(Integer.parseInt(ageAsString));
                }

                user.setRole(role);

                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return user;
    }


    public User[] findAll() {
        // Создаем массив для результата
        // сюда положим пользователей
        User[] users = new User[100];
        try {
            // открываем файл для чтения
            Reader reader = new FileReader(fileName);
            // открываем буфер для чтения из файла и передаем
            // туда файл
            BufferedReader bufferedReader
                    = new BufferedReader(reader);

            // считываем из файла первую строку
            String currentUserLine = bufferedReader.readLine();
            // начинаем с нуля
            int currentIndex = 0;
            // пока файл не кончился
            while (currentUserLine != null) {
                // разбиваем исходную строку
                // на элементы по разелителю |
                String[] userData = currentUserLine.split("\\|");
                String idString = userData[0];
                String firstName = userData[1];
                String lastName = userData[2];
                String ageAsString = userData[3];
                String phone = userData[4];
                String email = userData[5];
                String login = userData[6];
                String password = userData[7];
                UserRole role = UserRole.valueOf(userData[8]);

                User user = User.builder()
                        .login(login)
                        .password(password)
                        .build();

                if (!firstName.equals("null")) {
                    user.setFirstName(firstName);
                }

                if (!lastName.equals("null")) {
                    user.setLastName(lastName);
                }

                if (!ageAsString.equals("null")) {
                    user.setAge(Integer.parseInt(ageAsString));
                }

                user.setRole(role);

                users[currentIndex] = user;
                currentIndex++;
                currentUserLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        return users;
    }
}
