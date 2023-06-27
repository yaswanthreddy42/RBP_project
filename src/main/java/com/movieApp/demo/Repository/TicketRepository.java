package com.movieApp.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieApp.demo.Model.Ticket;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	@Query(value="select t from Ticket t where t.movie_id_fk= :movieId")
	public List<Ticket> getTicketList(int movieId);
	
	@Modifying
	@Query(value="delete from Ticket where movie_id_fk = :movieId")
	public void deleteTicketData(int movieId);

}
