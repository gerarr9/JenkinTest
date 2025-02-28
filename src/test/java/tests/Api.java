package tests;

import api.dto.games.Authorization;
import api.dto.games.User;
import api.sevice.UserService;
import extensions.RestExtensions;
import extensions.UserFabric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(RestExtensions.class)
public class Api {
    private User user = UserFabric.createDefaultUser();

    @BeforeEach
    public void createUser() {
        UserService.createUser(user);
    }

    @Test
    @Tag("smoke")
    public void auto() {

        Authorization authorization = new Authorization(user.getPass(), user.getLogin());

        UserService.authorization(authorization);
    }

    @Test
    @Tag("smoke")
    public void createUserCheck() {
        assertThat(UserService.getListUser()).contains(user.getLogin());
    }


    @Test
    public void changePass() {
        Authorization authorization = new Authorization(user.getPass(), user.getLogin());

        UserService.authorization(authorization);

        UserService.ChangePass("123");
    }

    @Test
    public void deleteUser() {
        Authorization authorization = new Authorization(user.getPass(), user.getLogin());
        UserService.authorization(authorization);

        UserService.deleteUser();

        assertThat(UserService.getListUser()).doesNotContain(user.getLogin());
    }


}
