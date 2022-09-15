package com.rtech.gerenciamentoFresadora.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long clientId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;



}