package com.movieApp.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieApp.demo.Model.Ticket;
import com.movieApp.demo.Repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepo;


	@Override
	public List<Ticket> getAllTickets(int mid) {
		List<Ticket> ticketlist = ticketRepo.getTicketList(mid);
		return ticketlist;
	}
	
	@Override
	public List<Ticket> getAllMovieTickets(){
		List<Ticket> ticketlist = ticketRepo.findAll();
		if(ticketlist !=null && ticketlist.size() >0)
		{
			return ticketlist;
		}
		return null;
	}

	@Override
	public boolean addTicket(Ticket ticket) {
		Ticket ticketObj = new Ticket();
		
		ticketObj.setNo_of_tickets(ticket.getNo_of_tickets());
		ticketObj.setMovie_id_fk(ticket.getMovie_id_fk());
		ticketObj.setIssueAt(ticket.getIssueAt());
		ticketRepo.saveAndFlush(ticketObj);
		return true;
	}

	@Override
	public boolean deleteTicket(int mid) {
		ticketRepo.deleteTicketData(mid);
		return true;
	}
	

}
