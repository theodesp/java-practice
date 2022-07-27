package ocp17.Ch1;

import java.util.*;
// import java.sql.*; // causes Date declaration to not compile
import java.util.Date; // works as it is explicit

public class Conflicts { 
    Date date;

    java.util.Date date2; // explicit
    java.sql.Date sqlDate; // explicit

}
