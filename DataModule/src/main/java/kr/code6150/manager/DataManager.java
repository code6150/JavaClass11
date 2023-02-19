package kr.code6150.manager;

import kr.code6150.data.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DataManager {

    private static DataManager instance;

    public static DataManager getInstance() {
        if(instance==null) instance = new DataManager();
        return instance;
    }

    private List<User> userList = new ArrayList<>();

    private DataManager() {

    }

    // 아이디, 비밀번호를 주면 User 를 돌려주는 메소드
    // 해당하는 아이디, 비밀번호가 없으면 null 값 리턴

    public User getUser(String id, String pw) {
        return userList.stream().filter((u) -> u.getId().equals(id) && u.getPw().equals(pw))
                .findFirst().orElse(null);
    }

    public boolean registerUser(User user) {
        // 아이디가 중복이라면, 폰 번호가 중복이라면 false
        // 이 외의 경우 userList에 추가하고 true 리턴
        if(userList.stream().anyMatch((u) ->
                u.getId().equals(user.getId()) || u.getPhone().equals(user.getPhone())))
            return false;

        userList.add(user);
        return true;
    }

}
