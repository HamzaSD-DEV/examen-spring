package tn.suptech.examenspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.suptech.examenspring.domain.User;
import tn.suptech.examenspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-accounts")
public class UserAccountController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUserAccount(@RequestBody User user) {
        User newUser = userService.addUserAccount(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUserAccounts() {
        List<User> userList = userService.getAllUserAccounts();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserAccountById(@PathVariable("id") Long userAccountId) throws Exception {
        User user = userService.getUserAccountById(userAccountId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserAccountByUsername(@PathVariable("username") String username) throws Exception {
        User user = userService.getUserAccountByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserAccount(@PathVariable("id") Long userAccountId,
                                                  @RequestBody User userDetails) throws Exception {
        User updatedUser = userService.updateUserAccount(userAccountId, userDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUserAccount(@PathVariable("id") Long userAccountId) {
        boolean deleted = userService.deleteUserAccount(userAccountId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}