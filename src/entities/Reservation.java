package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private static Date checkIn;
    private static Date checkOut;

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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
        Reservation.checkIn = checkIn;
        Reservation.checkOut = checkOut;
    }


    public String toString(){
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
