package vn.sunasterisk.sunwebsite;

import vn.sunasterisk.sunwebsite.UserService.UserService;
import vn.sunasterisk.sunwebsite.model.UserDto;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserDto> userList = new ArrayList<>();
        UserService us = new UserService(userList);
        us.registerUser("nguyenvana - PW: ","123");
        us.registerUser("nguyenvanb - PW: ","123");
        us.registerUser("nguyenvanc - PW:","123");
        us.registerUser("nguyenvand - PW:","123");
        us.registerUser("nguyenvane - PW:","123");
        us.registerUser("nguyenvanf - PW:","123");
        if (us.login("nguyenvanw","123")){
            System.out.println("nguyenvanw-123  ==>  Login thành công");
        }
        else System.out.println("nguyenvanw-123  ==>  Login thất bại");
        if (us.login("nguyenvanc","- 1234")){
            System.out.println("nguyenvanc- 1234  ==>  Login thành công");
        }
        else System.out.println("nguyenvanc- 1234  ==>   thất bại");
        if (us.login("nguyenvand","123")){
            System.out.println("nguyenvand- pass123  ==>  Login thành công");
        }
        else System.out.println("nguyenvand-123  ==>  Login thất bại");

        System.out.println("\nDanh sách các member đang có trong UserService là:");
        for (UserDto user:userList
        ) {

            System.out.println(user.getUsername() + " " + user.getPassword());
        }

    }
}