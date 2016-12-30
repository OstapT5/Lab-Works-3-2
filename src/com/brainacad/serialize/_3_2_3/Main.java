package com.brainacad.serialize._3_2_3;

import com.brainacad.serialize._3_2_1.Employee;
import com.brainacad.serialize.paths_util.PathsUtil;

import java.io.*;

public class Main {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(Main.class, "files/employee.ser");

    public static void main(String[] args) {

        com.brainacad.serialize._3_2_1.Employee employee = new Employee();
        employee.setName("Ostap");
        employee.setAddress("Mazepy 26/110");
        employee.setNumber(159357);
        employee.setSSN(204010050);

        System.out.println("Create object: " + employee);
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objOutStream.writeObject(employee);
            System.out.println("Object write to file!");
        } catch (IOException expIO) {
            expIO.printStackTrace();
        }

        System.out.println("Deserializing an object transiert");
        Employee otherEmployee;
        try (ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            otherEmployee = (Employee) objInStream.readObject();
            System.out.println("Object read from file");
            System.out.println(otherEmployee);
        } catch (IOException expIO) {
            System.out.println("Error reading file");
        }catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        }
    }
}
