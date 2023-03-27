package org.project.wearweather.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "User")
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(length = 10, nullable = false)
    private String userID;

    @Column(length = 15, nullable = false)
    private String userPwd;

    @Column(length = 100, nullable = false)
    private String userEmail;

    @Column(length = 20, nullable = false)
    private String userPhone;

    @Column(length = 15, nullable = false)
    private String userName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable=false)
    private Integer mileage;

    @CreationTimestamp
    private Date userRegDate;

    @Column(nullable = false)
    private String userAddress;
}
