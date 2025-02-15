package com.example.androidgoapp.androidgoapp.model.objectStructure;

/**
 * Created by Schokomonsterchen on 21.12.2016.
 */

public class Appointment {

    private AppointmentDate appointmentDate;
    //private DestinationPosition destinationPosition;
    private AppointmentDestination appointmentDestination;
    //private DestinationPosition destinationPosition; //latitude and longitude

    protected Appointment() {
        appointmentDate.setDate("01012000");//default
        appointmentDate.setTime("0000");//default
        appointmentDestination.setDestinationName("default address");//somehow get the coordinates of this place with osmdroid

         //coordinates will be created out of the name
    }

    /**
     * Set new date and time for the next appointment.
     * @param stringDate
     * @param stringTime
     */
    public void setAppointmentDate(String stringDate, String stringTime) {
        appointmentDate.setDate(stringDate);
        appointmentDate.setTime(stringTime);
    }

    /**
     * To show in activity.
     * @return
     */
    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Set a new destination for the appointment.
     * @param appointmentDestination
     */
    public void setAppointmentDestination(String appointmentDestination){

    }

    /**
     * Get the name and the position of the appointment.
     * @return name and position.
     */
    public AppointmentDestination getAppointmentDestination() {

        return appointmentDestination;
    }

}