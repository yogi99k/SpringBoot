package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        String name = vehicle.getName();
        System.out.println(name);
        vehicle.setName("Ford Mustang");
        System.out.println("Vehicle name from non spring context :"+vehicle.getName());


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println(veh.getName());
    }
}
