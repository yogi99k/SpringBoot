package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean("audiVechile")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("AUDI");
        return veh;
    }

    @Bean(name = "benzVechile")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("benz");
        return veh;
    }

    @Bean(name = "marutiVechile")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("maruti");
        return veh;
    }

    @Primary
    @Bean(name = "suzukiVechile")
    Vehicle vehicle4(){
        var veh = new Vehicle();
        veh.setName("suzuki");
        return veh;
    }
}
