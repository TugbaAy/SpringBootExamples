package com.sb.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_id_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 300)
    private String address;

    @Enumerated
    private AddressType addressType;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

}
