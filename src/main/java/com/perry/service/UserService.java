package com.perry.service;

import com.perry.model.dto.UserDto;
import com.perry.model.entity.user.User;
import com.perry.model.request.ChangePasswordRequest;
import com.perry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

public class UserService implements GeneralService<User, UserDto> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void changePassword(ChangePasswordRequest changePasswordRequest, Principal principal) {
        User user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        // check if the current password is correct
        if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID uuid) {
        return findById(uuid);
    }

    @Override
    public User create(UserDto userDto) {
        return userRepository.save(mapToEntity(userDto, User.class));
    }

    @Override
    public User update(UUID uuid, UserDto userDto) {
        userRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        User user;
        user = mapToEntity(userDto, User.class);
        user.setUuid(uuid);
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.delete(findById(uuid));
    }
}
