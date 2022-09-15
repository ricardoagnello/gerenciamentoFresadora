package com.rtech.gerenciamentoFresadora.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "login", nullable = false, unique = true)
    @Size(max = 20)
    @NotBlank
    private String login;
    @Column(name = "password", nullable = false)
    @Size(min = 4)
    @NotBlank
    private String password;



}