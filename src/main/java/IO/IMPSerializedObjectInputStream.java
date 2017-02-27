package IO;

import java.io.*;

public class IMPSerializedObjectInputStream {

    public static class Person implements Serializable {
        public String name = null;
        public int    age  =   0;
        public String className = "PersonClass";
        public long longNumber = 1000L;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("C:\\Ravi\\workspace\\text\\ObjectStream.txt"));

        Person person = new Person();
        person.name = "Jakob Jenkov";
        person.age  = 40;

        objectOutputStream.writeObject(person);
        objectOutputStream.close();


        ObjectInputStream objectInputStream =
            new ObjectInputStream(new FileInputStream("C:\\Ravi\\workspace\\text\\ObjectStream.txt"));

        Person personRead = (Person) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(personRead.name);
        System.out.println(personRead.age);
        System.out.println(personRead.className + " " + personRead.longNumber);
    }
}