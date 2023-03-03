package com.example.io;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("users.dat");
        UserService userService = new UserServiceInMemory(userDao.getUser());

        while (true) {
            int menuId = userUI.menu();
            if (menuId == 5) {
                System.out.println("종료합니다");
                userDao.saveUser(userService.getUsers());
                break;
            } else if (menuId == 1) {
                User user = userUI.regMenu();
                userService.addUser(user);
                System.out.println("등록되었습니다");
            } else if (menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
               boolean isFindeEmail =  userService.exists(email);
                if (isFindeEmail) {
                    User updateUser = userUI.inputUser(email);
                    userService.updateUser(updateUser);
                    System.out.println("수정되었습니다.");
                } else {
                    System.out.println("수정할 회원 정보가 없습니다.");
                }
            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                boolean isFindeEmail =  userService.exists(email);
                if(isFindeEmail) {
                    userService.deleteUser(email);
                    System.out.println("삭제하였습니다.");
                }else {
                    System.out.println("삭제할 회원 정보가 없습니다.");
                }
            }
        }
    }
}