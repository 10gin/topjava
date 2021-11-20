package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.*;
import ru.javawebinar.topjava.to.UserTo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsersUtil {
    public static final List<User> users = Arrays.asList(
            new User(0, "admin", "admin@anklav.ru", "1", Role.ADMIN),
            new User(1, "Ivan", "Ivan@anklav.ru", "1", Role.USER),
            new User(2, "Anton", "Anton@anklav.ru", "1", Role.USER),
            new User(3, "Sasha", "Sasha@anklav.ru", "1", Role.USER)
    );

    public static List<UserTo> getTos(Collection<User> users) {
        return filterByPredicate(users, user -> true);
    }

    public static List<UserTo> getFilteredTos(Collection<User> users) {
        return filterByPredicate(users, user -> true);
    }

    public static List<UserTo> filterByPredicate(Collection<User> users, Predicate<User> filter) {

        return users.stream()
                .filter(filter)
                .map(user -> createTo(user))
                .collect(Collectors.toList());
    }

    private static UserTo createTo(User user) {
        return new UserTo(user.getId(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getRegistered(), user.getRoles(), user.getCaloriesPerDay());
    }
}
