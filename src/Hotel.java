import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Hotel {
    private final HashMap<Integer, List<Reservation>>  reservationsMap = new HashMap<>();
    private int nextReservationId = 0;  // Start ID from 0

    public Hotel() {


        // Create 4 rooms (with IDs 1, 2, 3, 4) and initialize them with empty reservation lists
        for (int roomId = 1; roomId <= 4; roomId++) {
            reservationsMap.put(roomId, new ArrayList<>());  // Each room has an empty list of reservations
        }

        System.out.println("Hotel initialized with 4 rooms and no reservations.");
    }

    // Create a new reservation without taking roomId as a parameter
    public boolean createReservation(int userId, Date dateStart, Date dateEnd) {
        Integer roomId = isValidReservation(dateStart, dateEnd);
        if (roomId == null) {
            System.out.println("Error: No valid room found or the dates overlap with an existing reservation.");
            return false;
        }

        // Create a new reservation object
        Reservation newReservation = new Reservation(++nextReservationId,userId, roomId, dateStart, dateEnd);
        // Set the auto-incremented ID
        System.out.println(nextReservationId);
        System.out.println("New reservation created: " + newReservation.getDateStart());
        // Add the new reservation to the list for the specific room
        List<Reservation> reservations = reservationsMap.get(roomId);
        System.out.println(reservations);
        reservations.add(newReservation);
        System.out.println("New reservation created: " + reservations);
         reservationsMap.put(roomId, reservations);
         System.out.println(reservationsMap);

        return true;
    }

    // Validates if the reservation is valid and returns a roomId if valid, null otherwise
    private Integer isValidReservation(Date dateStart, Date dateEnd) {
        if (dateStart.after(dateEnd)) {
            System.out.println("Error: Start date must be before end date.");
            return null;
        }

        // Loop through all rooms to find a valid roomId
        for (Integer roomId : reservationsMap.keySet()) {
            List<Reservation> reservations = reservationsMap.get(roomId);
            boolean isAvailable = true;
            System.out.println("test for");

            if (reservations != null) {
                System.out.println("test if");
                for (Reservation reservation : reservations) {
                    System.out.println("test for 2");
                    if (dateStart.before(reservation.getDateEnd()) &&
                            dateEnd.after(reservation.getDateStart())) {
                        isAvailable = false;
                        System.out.println("test  IF 2");
                        break;
                    }
                }
            }

            if (isAvailable) {
                  // Return the first roomId that is available
                System.out.println(roomId);
                return roomId;
                  // Return the first roomId that is available
            }
        }

        return null;  // No valid roomId found
    }


    public boolean deleteReservation(Integer reservationId) {
        for (List<Reservation> reservations : reservationsMap.values()) {
            for (Reservation reservation : reservations) {
                if (reservation.getIdReservation().equals(reservationId)) {
                    reservations.remove(reservation);
                    System.out.println("Reservation with ID " + reservationId + " deleted successfully.");
                    return true;
                }
            }
        }
        System.out.println("Error: Reservation with ID " + reservationId + " not found.");
        return false;
    }
//
//   public  boolean updateReservation(Integer idReservation, Date dateStart, Date dateEnd) {
//        boolean isDeleted = deleteReservation(idReservation);
//
//
//   }


    public HashMap<Integer, List<Reservation>> getReservationsMap() {
        return reservationsMap;
    }
}
