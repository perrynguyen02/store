package com.perry.model.dto;

import com.perry.model.entity.user.Role;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;
@Data
public class UserDto {

    private UUID uuid;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private Role role;
    @CreationTimestamp
    private Date create_at;
    @UpdateTimestamp
    private Date update_at;
}
