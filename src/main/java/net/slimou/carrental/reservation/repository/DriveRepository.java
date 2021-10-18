package net.slimou.carrental.reservation.repository;

import net.slimou.carrental.reservation.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveRepository extends JpaRepository<Drive, Integer> {
}
