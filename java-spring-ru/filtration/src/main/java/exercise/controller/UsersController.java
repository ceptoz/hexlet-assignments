package exercise.controller;
import com.querydsl.core.types.Predicate;
import exercise.model.User;
import exercise.model.QUser;
import exercise.repository.UserRepository;
import liquibase.pro.packaged.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

// Зависимости для самостоятельной работы
// import org.springframework.data.querydsl.binding.QuerydslPredicate;
// import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    // BEGIN
//    @GetMapping(path = "")
//    public Iterable<User> getUsers(
//            @RequestParam(required = false) String firstName,
//            @RequestParam(required = false) String lastName
//    ) {
//        if (firstName == null && lastName == null) {
//            return userRepository.findAll();
//        }
//
//        if (firstName == null) {
//            return userRepository.findAll(
//                    QUser.user.lastName.containsIgnoreCase(lastName)
//            );
//        }
//
//        if (lastName == null) {
//            return userRepository.findAll(
//                    QUser.user.firstName.containsIgnoreCase(firstName)
//            );
//        }
//
//        return userRepository.findAll(QUser.user.firstName.containsIgnoreCase(firstName)
//                .and(QUser.user.lastName.containsIgnoreCase(lastName)));
//    }

    @GetMapping
    public Iterable<User> getUsers(@QuerydslPredicate(root = User.class) Predicate predicate) {
        return userRepository.findAll(predicate);
    }
    // END
}

