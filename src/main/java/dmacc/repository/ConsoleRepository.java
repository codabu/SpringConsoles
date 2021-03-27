package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {}


