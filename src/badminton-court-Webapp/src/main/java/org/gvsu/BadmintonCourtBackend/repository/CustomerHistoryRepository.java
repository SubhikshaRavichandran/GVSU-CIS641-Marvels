package org.gvsu.BadmintonCourtBackend.repository;


import org.gvsu.BadmintonCourtBackend.model.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {
}
