package be.technifutur.mechanofiliback.bll;

import be.technifutur.mechanofiliback.dl.entities.User;

public interface AuthService {

    void register(User user);

    User login(String email, String password);
}
