package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.Vector;
import java.util.function.Supplier;

public class Example7 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> vokswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () ->
        {
            Vehicle audi = new Vehicle();
            audi.setName("AUDI");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("randomNumber = "+randomNumber);

        if(randomNumber %2==0){
            context.registerBean("volkswagen",Vehicle.class,vokswagenSupplier);
        }
        else{
            context.registerBean("audi",Vehicle.class,audiSupplier);
        }
        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;
        try{
            volksVehicle = context.getBean("volkswagen",Vehicle.class);
        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("error while creating volkswagen vehicle");
        }
        try{
            audiVehicle = context.getBean("audi", Vehicle.class);
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("error creating audi vehicle");
        }
        if(null != volksVehicle){
            System.out.println("prgming vehicle name from context is :"+volksVehicle.getName());
        }
        else{
            //assert audiVehicle != null;
            System.out.println("prgming vehicle name from context is :"+audiVehicle.getName());
        }
//        Vehicle vehicle = context.getBean(Vehicle.class);
//        System.out.println("Component Vehicle name from Spring Context is: " + vehicle.getName());
//        vehicle.printHello();
//        context.close();
    }
}
