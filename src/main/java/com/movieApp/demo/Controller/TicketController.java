package com.movieApp.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieApp.demo.Model.Movie;
import com.movieApp.demo.Model.Ticket;
import com.movieApp.demo.Service.MovieService;
import com.movieApp.demo.Service.TicketService;

@RestController
@RequestMapping("api/v1/ticket")
@CrossOrigin("*")
public class TicketController {
	@Autowired
	private TicketService ts;
	
	@Autowired
	private MovieService ms;
	
	@GetMapping("/alltickets")//done
	public ResponseEntity<?> allTickets(){
		List<Ticket> movielist = ts.getAllMovieTickets();
		if(movielist!=null)
		{
			return new ResponseEntity<List<Ticket>>(movielist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No shows Avalible", HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/add/{mid}")
	public ResponseEntity<?> addTicket(@PathVariable("mid")int movieId, @RequestBody Ticket ticket)//done
	{
		Movie b1 = ms.getMovieById(movieId);
		
		if(b1 !=null)
		{
			b1.setSeatsAvalible(b1.getSeatsAvalible() - ticket.getNo_of_tickets());
			ticket.setMovie_id_fk(ticket.getMovie_id_fk());
			ticket.setIssueAt(ticket.getIssueAt());
			ticket.setNo_of_tickets(ticket.getNo_of_tickets());
			
			if(ms.updateMovie(b1) && ts.addTicket(ticket))
			{
				return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<String>("Ticket cannot be booked", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
