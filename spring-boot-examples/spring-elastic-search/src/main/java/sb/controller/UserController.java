package sb.controller;

import java.util.List;
import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sb.entity.User;
import sb.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{first}")
    public ResponseEntity<List<User>> getUserByCustom(@PathVariable String first) {
        return new ResponseEntity<>(userService.getByCustom(first), HttpStatus.OK);
    }

    @GetMapping("/{second}")
    public ResponseEntity<List<User>> getUserBySBQuery(@PathVariable String second) {
        return new ResponseEntity<>(userService.getUserBySBQuery(second), HttpStatus.OK);
    }

}
