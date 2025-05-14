//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private int id;
    public static List<String> allReaderNames = new ArrayList();

    public Reader(String name, int id) {
        this.name = name;
        this.id = id;
        allReaderNames.add(name);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void printAllReaderNames() {
        System.out.println("Усі читачі:");

        for(String name : allReaderNames) {
            System.out.println(name);
        }

    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public String getReaderInfo() {
        return "Reader: " + this.name + " (ID: " + this.id + ")";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Reader)) {
            return false;
        } else {
            Reader reader = (Reader)o;
            return this.id == reader.id;
        }
    }

    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    public String toString() {
        return "Reader: " + this.name + " (ID: " + this.id + ")";
    }
}
