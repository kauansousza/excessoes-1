package entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private static Date checkIn;
    private static Date checkOut;

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after (checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        Reservation.checkIn = checkIn;
        Reservation.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        Reservation.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        Reservation.checkOut = checkOut;
    }

    public static long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return diff / (24 * 60 * 60 * 1000);
    }

    public void updateDates(Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        Reservation.checkIn = checkIn;
        Reservation.checkOut = checkOut;
    }


    public String toString() {
        return "Reservation: Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
}
