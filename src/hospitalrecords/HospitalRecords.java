/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 92019179
 */
public class HospitalRecords {

    public static ArrayList<Patient> aL = new ArrayList();
    public static Scanner s = new Scanner(System.in);
    public static String uI;
    public static Patient check;

    public static void main(String[] args) {

        obtainRecords();

        boolean going = true;
        System.out.println("**Patient records have been recorded successfully**");
        // this is the start of the loop for the main menu and also the user input.
        while (going) {
            System.out.println("Press s for search, Press e for exit");
            uI = s.next();
            if (uI.equalsIgnoreCase("s")) {
                recordCheck();
            } else if (uI.equalsIgnoreCase("e")) {
                System.out.println("Bye");
                going = false;
            } else {
                System.out.println("That is not a Command I understand try again");
            }
        }
    }
// this is to check for patient records and reply if its null.

    public static void recordCheck() {

        System.out.println("Enter Patient ID to search");
        uI = s.next();
        check = searchByID(uI);
        if (check == null) {
            System.out.println("there is no record of that patient in our database.");
            return;
        }
        System.out.println(check.toString());

        if (check != null) {
            System.out.println("Would you like to delete the patient data? next time please press 'y' yes, 'n' no");
            uI = s.next();
            if (uI.equalsIgnoreCase("y")) {
                deleteRecords();
            } else if (uI.equalsIgnoreCase("n")) {
                System.out.println("ok no change to patient data files");
            } else {
                System.out.println("I dont understand that command, please press y or n");
            }
        }
    }

    // this methed is to delete the patient records
    public static void deleteRecords() {
        for (int i = 0; i < aL.size(); i++) {
            if (aL.get(i).getbyID().equals(check.getbyID())) {
                aL.remove(i);
                System.out.println("The Records have been successfully delete");
            }
        }
    }
// this is where the patients details are grabbed from the patient list.

    public static Patient searchByID(String Patient) {
        ArrayList<Patient> check = new ArrayList();
        for (Patient o : aL) {
            if (o.PatientID.equals(Patient)) {
                check.add(o);
            }
        }
        if (!check.isEmpty()) {
            return check.get(0);
        }
        return null;
    }

    public static void obtainRecords() {
        String path = "src/hospitalrecords/ListOfPatients.txt";
//Use path to the ListOfPatients.txt here
        LineNumberReader lr = null;
//allows to read information from the file line by line
        String[] oneRecord = new String[4];
//an array to store info about one patient
        Patient pat;
        try {
//using try-catch for exception handling to catch
//possible errors with i/o operations
            FileReader inputStream = new FileReader(path);
//FileReader reads the file’s contents
            lr = new LineNumberReader(inputStream);
            String str;
            while ((str = lr.readLine()) != null) {
//while the next line exists
                oneRecord = str.split(",");
//dividing one file line by commas and assigning to array
                pat = new Patient(oneRecord[0], oneRecord[1],
                        oneRecord[2], oneRecord[3]);
                aL.add(pat); //adding patient to the ArrayList
            }
        } catch (IOException ioe) {
            System.out.println("IOExcception occured");
        }
    }
}
