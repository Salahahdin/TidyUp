package com.codecat.TidyUp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    //private String email;
    @Column(nullable = false)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date userCreatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @PrePersist
    void onCreate() {
        if (userCreatedAt == null) {
            userCreatedAt = new Date();
        }
        if (role == null) {
            role = Role.USER;
        }
    }
}
