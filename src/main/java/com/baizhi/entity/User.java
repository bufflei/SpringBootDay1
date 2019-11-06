package com.baizhi.entity;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String ip;
    private String source;
    private String role;
    private String status;

}
