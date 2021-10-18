package net.slimou.carrental.contactinformation.repository;

import net.slimou.carrental.contactinformation.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Integer> {
}
