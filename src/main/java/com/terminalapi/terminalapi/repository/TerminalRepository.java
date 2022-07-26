package com.terminalapi.terminalapi.repository;

import com.terminalapi.terminalapi.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {
     Terminal findByTerminalId(String terminalId);

     List<Terminal> findByResponseCode(String code);
    @Query(value = "SELECT * FROM terminal WHERE response_message LIKE %:query%", nativeQuery = true)
    List <Terminal> findBySearch(String query);

}