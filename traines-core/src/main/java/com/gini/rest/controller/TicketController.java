package com.gini.rest.controller;

import com.gini.service.TicketService;
import gin.model.TicketRequest;
import gin.model.TicketResponsePaginated;
import gini.api.TicketApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TicketController implements TicketApi {

    private final TicketService ticketService;

    @Override
    public ResponseEntity<Void> createTicket(TicketRequest ticketRequest) {
        log.debug("ticket request received");
        ticketService.createTicket(ticketRequest);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TicketResponsePaginated> getUsersTicketsPaginated(@RequestParam Integer pageNumber, @RequestParam String customerId) {
        log.info("request for user tickets received, getting page: {} for customerId {}", pageNumber, customerId);
        var ticketsPaginated = ticketService.getUserTicketsPaginated(pageNumber, customerId);
        return ResponseEntity.ok(ticketsPaginated);
    }

    @Override
    public ResponseEntity<TicketResponsePaginated> getAllTicketsPaginated(@PathVariable Integer pageNumber) {
        log.info("request for all tickets received, getting page: {}", pageNumber);
        var ticketsPaginated = ticketService.getTicketsPaginated(pageNumber);
        return ResponseEntity.ok(ticketsPaginated);
    }

    @Override
    public ResponseEntity<TicketResponsePaginated> getTicketsByDestination(@PathVariable Integer pageNumber, @PathVariable String destination) {
        log.info("request for all tickets received, getting page: {}", pageNumber);
        var ticketsPaginated = ticketService.getTicketsByDestination(pageNumber, destination);
        return ResponseEntity.ok(ticketsPaginated);
    }

}
