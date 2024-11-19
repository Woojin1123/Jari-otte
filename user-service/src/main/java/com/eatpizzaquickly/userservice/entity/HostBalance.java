package com.eatpizzaquickly.userservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "host_balance")
public class HostBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hostId;
    private Long balance;

    @Builder
    public HostBalance(Long hostId, Long balance) {
        this.hostId = hostId;
        this.balance = balance;
    }

    public void addBalance(Long points) {
        this.balance = this.balance + points;
    }
}