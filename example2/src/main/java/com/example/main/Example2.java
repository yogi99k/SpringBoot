package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Vector;

public class Example2 {

    @Autowired private Vehicle vehicle;
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        String name = vehicle.getName();
        System.out.println(name);
        vehicle.setName("Ford Mustang");
        System.out.println("Vehicle name from non spring context :"+vehicle.getName());


        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean("audiVechile",Vehicle.class);
        //Vehicle veh1 = context.getBean("vehicle2",Vehicle.class);
        Vehicle veh3 = context.getBean("suzukiVechile", Vehicle.class);
        Vehicle veh1 = context.getBean(Vehicle.class);
        System.out.println(veh.getName());
        System.out.println(veh3.getName());
        System.out.println("Primary: "+veh1.getName());
    }
}
