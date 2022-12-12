package org.gvsu.BadmintonCourtBackend.repository;

import org.gvsu.BadmintonCourtBackend.model.BadmintonCourt;
import org.gvsu.BadmintonCourtBackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BadmintonCourtRepository extends JpaRepository<BadmintonCourt, Long> {

    @Query("select bc from BadmintonCourt bc where bc.location like :location and bc.id not in (select b.court.id from Booking b where b.bookingDate between :startDate and :endDate)")
    List<BadmintonCourt> findByLocationAndStartDateAndEndDate(@Param("location") String location,
                                                  @Param("startDate") Date startDate,
                                                  @Param("endDate") Date endDate);
}
