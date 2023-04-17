package com.moalosi;


import com.moalosi.dao.DaoImplementation;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                new DaoImplementation().findAllSubmissions()
                        .toString()
        );
    }
}
