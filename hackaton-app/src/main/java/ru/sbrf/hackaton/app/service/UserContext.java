package ru.sbrf.hackaton.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import ru.sbrf.hackaton.app.model.User;

import static java.util.Objects.requireNonNull;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Service
@RequestScope
public class UserContext implements UserInfoManager, UserInfoProvider {
    private User user;

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return requireNonNull(user);
    }
}