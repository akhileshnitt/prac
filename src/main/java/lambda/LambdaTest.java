package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Akhilesh","Singh"));
        personList.add(new Person("Manisha","Singh"));
        personList.add(new Person("Anshuman","Singh"));
        personList.add(new Person("Tejas","Tulankar"));
        personList.add(new Person("Nandu","Yadav"));


        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getLastName().compareTo(p1.getLastName()) ;
            }
        });
        personList.forEach(p-> System.out.println(p));

        // filter out the person whose lastname starts with S
        System.out.println("filter out the person whose lastname starts with S");

        filterPerson(personList,p->true);
        // filter out the person whose lastname starts with S

        System.out.println();

        System.out.println("filter out the person whose first starts with T");
        filterPerson(personList, p->p.getFirstName().startsWith("T"));

        long count = personList.parallelStream().filter(person -> person.getLastName().startsWith("Y")).count();
        System.out.println(count);
    }

    private static void filterPerson(List<Person> personList, Predicate<Person> condition) {
        for(Person p:personList){
            if(condition.test(p)){
                System.out.println(p);
            }
        }

    }
}
