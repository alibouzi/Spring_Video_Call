package com.alibouzid.videocall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Service
public class Userservice {
    private static final List<User> User_List=new ArrayList<>();
    public void register(User user){
        user.setStatus("online");
        User_List.add(user);
    }

    public User login(User user){
        var userindex = IntStream.range(0, User_List.size())
                .filter(i->User_List
                        .get(i).getEmail()
                        .equals(user.getEmail())).findAny()
                .orElseThrow(()->new RuntimeException("User not found "));
        var cUser =User_List.get(userindex);//fetch the index in the user
        if(!cUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Password incorrect ");
        }
        cUser.setStatus("online");//update status
        return cUser;
    }
    public void logout(String email){
        var userindex = IntStream.range(0, User_List.size())
                .filter(i->User_List
                        .get(i).getEmail()
                        .equals(email)).findAny()
                .orElseThrow(()->new RuntimeException("User not found "));
        User_List.get(userindex).setStatus("offline");
    }

    public List<User> findAll(){
        return User_List;
    }
}
