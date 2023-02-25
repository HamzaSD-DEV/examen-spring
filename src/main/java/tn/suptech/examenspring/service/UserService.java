package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.User;
import tn.suptech.examenspring.repository.UserAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public User addUserAccount(User user) {
        return userAccountRepository.save(user);
    }

    public List<User> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public User getUserAccountById(Long userAccountId) throws Exception {
        Optional<User> userAccount = userAccountRepository.findById(userAccountId);
        if (userAccount.isPresent()) {
            return userAccount.get();
        } else {
            throw new Exception("User account not found with id " + userAccountId);
        }
    }

    public User getUserAccountByUsername(String username) throws Exception {
        Optional<User> userAccount = Optional.ofNullable(userAccountRepository.findByUsername(username));
        if (userAccount.isPresent()) {
            return userAccount.get();
        } else {
            throw new Exception("User account not found with username " + username);
        }
    }

    public User updateUserAccount(Long userAccountId, User userDetails) throws Exception {
        Optional<User> userAccount = userAccountRepository.findById(userAccountId);
        if (userAccount.isPresent()) {
            User existingUser = userAccount.get();
            existingUser.setCinNumber(userDetails.getCinNumber());
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setRoles(userDetails.getRoles());
            return userAccountRepository.save(existingUser);
        } else {
            throw new Exception("User account not found with id " + userAccountId);
        }
    }

    public boolean deleteUserAccount(Long userAccountId) {
        try {
            userAccountRepository.deleteById(userAccountId);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Cannot delete user account with id " + userAccountId, ex);
        }
    }

}
