// src/main/java/com/example/bookMS/model/User.java
package com.example.bookMS.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 아이디
    @Column(nullable = false, unique = true)
    private String username;

    // 비밀번호 (지금은 평문, 필요하면 나중에 암호화)
    @Column(nullable = false)
    private String password;
}
