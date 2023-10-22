package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private Long id;
    @Column(length = 50, name = "first_name")
    private String firstName;
    @Column(length = 50, name = "middle_name")
    private String middleName;
    @Column(length = 50, name = "last_name")
    private String lastName;
    @Column(length = 15)
    private String mobile;
    @Column(length = 50)
    private String email;
    @Column(length = 64, name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(name = "registered_at", nullable = false)
    private Instant registeredAt;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Column(columnDefinition = "text")
    private String intro;
    @Column(columnDefinition = "text")
    private String profile;

    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
}
