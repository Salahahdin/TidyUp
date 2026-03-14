package com.codecat.TidyUp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    //private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    private Instant userCreatedAt;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String active;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    void onCreate() {
        if (userCreatedAt == null) {
            userCreatedAt = Instant.now();
        }
        if (role == null) {
            role = Role.USER;
        }
    }
}
