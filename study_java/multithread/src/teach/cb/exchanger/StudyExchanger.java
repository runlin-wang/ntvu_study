package teach.cb.exchanger;

import java.util.concurrent.Exchanger;

class Person {

    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class ExchangerThread extends Thread {

    private final Exchanger<Person> exch;
    private final Person person;
    private final String threadName;

    public ExchangerThread(Exchanger<Person> exch, Person person, String threadName) {
        this.exch = exch;
        this.person = person;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            Person received = exch.exchange(person);
            System.out.println(threadName + ": person: " + person + ", received: " + received);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class StudyExchanger {
    public static void main(String[] args) {
        Exchanger<Person> exch = new Exchanger<>();
        new ExchangerThread(exch, new Person(111, "Alice"), "ThreadA").start();
        new ExchangerThread(exch, new Person(222, "Bob"), "ThreadB").start();
    }
}
