package sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.entity.User;
import sb.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getByCustom(String searchingVal) {
        return userRepository.getByCustomSearching(searchingVal);
    }

    public List<User> getUserBySBQuery(String searchingVal) {
        return userRepository.findAllByNameLikeOrSurnameLike(searchingVal, searchingVal);
    }

    @PostConstruct
    public void initUsers() {
        User user = new User();
        user.setName("Test");
        user.setSurname("Test");
        user.setBirthDay(new Date());

        userRepository.save(user);

        user = new User();
        user.setName("Deneme");
        user.setSurname("Deneme");
        user.setBirthDay(new Date());

        userRepository.save(user);

    }

}
