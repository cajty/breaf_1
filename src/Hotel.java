import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hotel {
    private final HashMap<Integer, List<Reservation>> reservationsMap = new HashMap<>();
    private   int nextReservationId = 0;  // Start ID from 0

    public Hotel() {
        for (int roomId = 1; roomId <= 4; roomId++) {
            reservationsMap.put(roomId, new ArrayList<>());
        }
    }

    public boolean addReservationToHotel(int roomId, LocalDate[] dates, int userId) {
        try {
            Reservation newReservation = new Reservation(++nextReservationId, userId, roomId, dates[0], dates[1]);

            List<Reservation> reservations = reservationsMap.get(roomId);

            reservations.add(newReservation);

            reservationsMap.put(roomId, reservations);

            return true;
        }catch (Exception e) {
            return false;
        }

    }


    public boolean createReservation(int userId, LocalDate[] dates) {
        // dates[0] = dateStart , dates[1] = dateEnd
        Integer roomId = isValidReservation(dates[0], dates[1]);
        if (roomId == null) {
            System.out.println("Error: No valid room found or the dates overlap with an existing reservation.");
            return false;
        }


        boolean newReservation = addReservationToHotel(userId, dates ,roomId);




        System.out.println("New reservation created: " + newReservation);


        return true;
    }





    private Integer isValidReservation(int idReservation,LocalDate dateStart, LocalDate dateEnd) {

        // Loop through all rooms to find a valid roomId
        for (Integer roomId : reservationsMap.keySet()) {
            List<Reservation> reservations = reservationsMap.get(roomId);
            boolean isAvailable = true;

            if (reservations != null) {
                for (Reservation reservation : reservations) {

                    if (dateStart.isBefore(reservation.getDateEnd()) &&
                            dateEnd.isAfter(reservation.getDateStart()) &&
                            reservation.getIdReservation().equals(idReservation) ) {
                        isAvailable = false;

                        break;
                    }
                }
            }

            if (isAvailable) {
                return roomId;
            }
        }

        return null;
    }



    private Integer isValidReservation(LocalDate dateStart, LocalDate dateEnd) {

        // Loop through all rooms to find a valid roomId
        for (Integer roomId : reservationsMap.keySet()) {
            List<Reservation> reservations = reservationsMap.get(roomId);
            boolean isAvailable = true;
            

            if (reservations != null) {
                for (Reservation reservation : reservations) {

                    if (dateStart.isBefore(reservation.getDateEnd()) &&
                            dateEnd.isAfter(reservation.getDateStart())) {
                        isAvailable = false;

                        break;
                    }
                }
            }

            if (isAvailable) {
                return roomId;
            }
        }

        return null;
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
        System.out.println("Reservation with ID " + reservationId + " not found.");
        return false;
    }


    public boolean updateReservation(Integer idReservation, LocalDate[] dates, int userId ) {
        // dates[0] = dateStart , dates[1] = dateEnd
        Integer roomId = isValidReservation(idReservation,dates[0], dates[1]);
        if (roomId == null) {
            System.out.println("Error: No valid room found or the dates overlap with an existing reservation.");
            return false;
        }

        if(deleteReservation(idReservation)){
            return addReservationToHotel(roomId, dates, userId);
        }

        return false;
    }


    public  void getReservationsOfUser( int userid) {
        for (List<Reservation> reservations : reservationsMap.values()) {
            for (Reservation reservation : reservations) {
                if (reservation.getIdUser().equals(userid)) {
                    System.out.println(reservation);
                }

            }
        }
    }
}
