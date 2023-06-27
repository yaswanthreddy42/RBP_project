package com.movieApp.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movieApp.demo.Model.Ticket;

@Service
public interface TicketService {
	public List<Ticket> getAllTickets(int mid);
	public List<Ticket> getAllMovieTickets();
	public boolean addTicket(Ticket ticket);
	public boolean deleteTicket(int mid);
}
