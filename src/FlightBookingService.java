import java.util.List;

// FlightBookingService.java
public class FlightBookingService {

    public boolean bookFlight(Flight flight, Customer customer, int numOfTickets) {
        if (flight.getNoOfSeats() < numOfTickets) return false;

        flight.setNoOfSeatsInTheFlight(flight.getNoOfSeats() - numOfTickets);

        if (!flight.isCustomerAlreadyAdded(flight.getListOfRegisteredCustomersInAFlight(), customer)) {
            flight.addNewCustomerToFlight(customer);
        }

        List<Flight> flights = customer.getFlightsRegisteredByUser();
        int existingIndex = getFlightIndex(flights, flight);

        if (existingIndex != -1) {
            customer.updateTicketsForExistingFlight(existingIndex, numOfTickets);
        } else {
            customer.bookNewFlight(flight, numOfTickets);
        }

        return true;
    }

    public boolean cancelFlight(Flight flight, Customer customer, int ticketsToCancel) {
        List<Flight> registeredFlights = customer.getFlightsRegisteredByUser();
        int index = getFlightIndex(registeredFlights, flight);
        if (index == -1) return false;

        int returnedTickets = customer.cancelFlightAtIndex(index, ticketsToCancel);
        flight.setNoOfSeatsInTheFlight(flight.getNoOfSeats() + returnedTickets);

        if (returnedTickets == 0) {
            flight.getListOfRegisteredCustomersInAFlight().remove(customer);
        }

        return true;
    }

    private int getFlightIndex(List<Flight> flightList, Flight flight) {
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getFlightNumber().equalsIgnoreCase(flight.getFlightNumber())) {
                return i;
            }
        }
        return -1;
    }
}
