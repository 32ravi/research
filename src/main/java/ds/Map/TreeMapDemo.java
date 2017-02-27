package ds.Map;

import java.util.Comparator;
import java.util.TreeMap;
/**
 *
 * @author Ganesh.Rashinker
 *
 */
class Person implements Comparator {
 private int id;

 public Person() {
  super();
  // TODO Auto-generated constructor stub
 }
 public Person(int id) {
  super();
  this.id = id;
 }
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 @Override
 public String toString() {
  return "Person [id=" + id + "]";
 }
 @Override
 public int compare(Object o1, Object o2) {
  Person p1 = (Person) o1;
  Person p2 = (Person) o2;
  if (p1.id == p2.id)
   return 0;
  else if (p1.id > p2.id)
   return 1;
  else
   return -1;
 }
}

public class TreeMapDemo {

 public static void main(String[] args) {
  TreeMap<Person, String> map = new TreeMap<Person, String>(new Person());
  Person p1 = new Person(18);
  Person p2 = new Person(6);
  Person p3 = new Person(4);
  Person p4 = new Person(12);
  Person p5 = new Person(10);
  map.put(p1, "first data");
  map.put(p2, "second data");
  map.put(p3, "third data");
  map.put(p4, "fourth data");
  map.put(p5, "fifth data");
  System.out.println(map);
 }

}
