package de.epsdev.plugins.MMO.data.regions;

import de.epsdev.plugins.MMO.GUI.dev.City_GUI;
import de.epsdev.plugins.MMO.data.mysql.mysql;
import de.epsdev.plugins.MMO.data.output.Out;
import de.epsdev.plugins.MMO.data.regions.cites.City;

import java.util.ArrayList;
import java.util.List;

public class Region {
    public String name;
    public int level;
    public int id;
    public int index;

    public City_GUI city_gui;

    public List<City> cities = new ArrayList<>();

    public Region(String name, int level){
        this.name = name;
        this.level = level;
    }


    public void print(){
        Out.printToConsole("Name: "+name);
        Out.printToConsole("Level: " + level);
        Out.printToConsole("ID: " + id);
    }

    public int getId(){
     return id;
    }

    public void delete(){
        mysql.query("DELETE FROM `eps_regions`.`regions` WHERE `ID` = "+ this.id + ";");
    }

    public void save(){
        mysql.query("REPLACE INTO `eps_regions`.`regions` SET `ID` = "+ this.id + "," +
                " `NAME` = '" + this.name + "', `LEVEL` = " + this.level + ";");
    }

}
