package ocp17.Ch7.sealed;

public sealed class Penguin permits Emperor { // DOES NOT COMPILE Permitted class Emperor does not declare ocp17.Ch7.sealed.Penguin as direct super class

}
