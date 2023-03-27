package org.project.wearweather.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Table(name = "Product")
@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productNo;

    @Column(nullable = false)
    private String productName;

    @Column(length = 100, nullable = false)
    private Integer productPrice;

    @Column(length = 100, nullable = false)
    private Integer valueCount;

    @Column(nullable = false)
    private String productInfo;

    @Column(length = 15, nullable = false)
    private Integer viewCount;

    @Column(length = 15, nullable = false)
    private String category;

    //기온번호는 나중에 추가

    @Column(nullable = false)
    private String sex;
}
