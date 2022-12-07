package vn.sunasterisk.sunwebsite.UserService;


import lombok.AllArgsConstructor;
import lombok.Data;
import vn.sunasterisk.sunwebsite.model.UserDto;

import java.util.List;

@AllArgsConstructor
@Data
public class UserService {
    List<UserDto> listUser;

    public boolean login(String username, String password) {
        for (UserDto User : listUser
        ) {
            if (User.getUsername() == username && User.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(String username, String password) {
        UserDto user = new UserDto();
        user.setUsername(username);
        user.setPassword(password);
        listUser.add(user);
//        System.out.println(listUser);
    }
}
