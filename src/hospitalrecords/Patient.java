/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

/**
 *
 * @author 92019179
 */
public class Patient {

    String PatientID;
    String Name;
    String CheckInDate;
    String AssignedMedicalPersonnel;

    public Patient(String Patient, String name, String cid, String amp) {
        PatientID = Patient;
        Name = name;
        CheckInDate = cid;
        AssignedMedicalPersonnel = amp;
    }

    @Override
    public String toString() {
        return ("Patient ID:" + PatientID + "\n" + "Name:" + Name + "\n" + "Check In Date:" + CheckInDate + "\n" + "Assigned Medical Personnel:" + AssignedMedicalPersonnel + "\n" + "\n");
    }

    public String getbyID() {
        return PatientID;
    }
}
