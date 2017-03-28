package rjunitPowerMock;

import java.util.Random;

public class Puppy {
    private final String name;
    public Human owner;
    private int energyLevel;
    private Random puppyRandomness;

    public Puppy(String name, Human owner){
        this.name = name;
        this.owner = owner;
        energyLevel = 100;
        puppyRandomness = new Random();
        //System.out.println("Hi puppy constructor..");
    }

    public static Puppy createPuppy(String name, Human human) {
        human.isSoHappy();
        return new Puppy(name, human);
    }

    public void chaseTail(){
        bark();
        energyLevel -= getRandomInt(10);
    }
    public void bark(){
        System.out.println("WOOF!");
    }

    public void goOnWalk(int length){
        performBusiness();
        energyLevel -= length;
        wipeOffFeet();
    }

    public void wipeOffFeet(){
        System.out.println("Paws on fleek");
    }

    private void performBusiness() {
        System.out.println("Puppy.performBusiness()...When you gotta go you gotta go...");
    }

    public void performPuppyTasks(){
        eat();
        sleep();
        play();
        System.out.println("Puppy.performPuppyTasks()..");
    }

    private void eat(){
        energyLevel+= getRandomInt(10);
    }

    private void sleep() {
        energyLevel+= getRandomInt(10);
    }

    private void play() {
        energyLevel-= getRandomInt(10);
    }

    private int getRandomInt(int bounds){
        return puppyRandomness.nextInt(bounds);
    }

    public String getName() {
        return name;
    }
}