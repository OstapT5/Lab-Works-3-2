package com.brainacad.serialize._3_2_1;

import com.brainacad.serialize.paths_util.PathsUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo  {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(SerializeDemo.class, "files/employee.ser");

    public static void main(String[] args) {

        Employee employee = new Employee();
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
    }
}
