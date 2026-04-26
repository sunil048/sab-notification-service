package com.sabtok.repository;

import com.sabtok.entity.IncomingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomingLogRepo extends JpaRepository<IncomingLog, Integer> {
}
