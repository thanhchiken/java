package com.K21CNT2.Ntt_account.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "ntt_account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NttAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nttUser;
    String nttPass;
    String nttName;
    String nttEmail;
    String nttPhone;
    String nttAddress;
    Integer nttStatus;
}