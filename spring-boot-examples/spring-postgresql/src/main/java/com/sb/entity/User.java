package com.sb.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_id_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_id_user", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> addressList;

}
