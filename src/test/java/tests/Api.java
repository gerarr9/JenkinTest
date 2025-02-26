package tests;

import api.dto.games.Authorization;
import api.dto.games.User;
import api.sevice.UserService;
import extensions.RestExtensions;
import extensions.UserFabric;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(RestExtensions.class)
public class Api {
    @BeforeAll
    public static void auto() {
        Authorization authorization = new Authorization("123321", "gerarr996117");

        UserService.authorization(authorization);
    }

    @Test
    @Tag("smoke")
    public void createUserCheck() {
        User user = UserFabric.createDefaultUser();


        UserService.createUser(user);

        assertThat(UserService.getListUser()).contains(user.getLogin());
    }


    @Test
    public void changePass() {
        UserService.ChangePass("123");
    }

    @Test
    public void deleteUser() {
        UserService.deleteUser();
    }


}
