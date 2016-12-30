package com.brainacad.serialize._3_2_2;

import com.brainacad.serialize._3_2_1.Employee;
import com.brainacad.serialize.paths_util.PathsUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

    private static final String FILE_PATH = PathsUtil.getPackageFileAccess(DeserializeDemo.class, "files/employee.ser");

    public static void main(String[] args) {

        Employee employee;
        System.out.println("Opening file for reading...");
        try(ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            employee = (Employee) objInStream.readObject();
            System.out.println("Object read from file");
            System.out.println(employee);
        }catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        }catch (IOException expIO) {
            System.out.println("Error reading file");
        }
    }
}
