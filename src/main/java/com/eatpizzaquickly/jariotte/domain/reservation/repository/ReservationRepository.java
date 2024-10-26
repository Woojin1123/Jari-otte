package com.eatpizzaquickly.jariotte.domain.reservation.repository;

import com.eatpizzaquickly.jariotte.domain.reservation.entity.Reservation;
import com.eatpizzaquickly.jariotte.domain.reservation.entity.ReservationStatus;
import com.eatpizzaquickly.jariotte.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserAndStatus(User user, ReservationStatus status);

}
