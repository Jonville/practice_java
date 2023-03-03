package com.example.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputExam {
    public static void main(String[] args) throws Exception {
        User user = new User("hong@example.com", "홍길동" , 1992);

        // user.dat 을 저장
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"));
        out.writeObject(user);

        out.close();
    }
}
