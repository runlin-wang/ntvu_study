package study.IO.dictclient;

import java.io.*;

class Phone implements Serializable {

    private String homePhone;
    transient private String mobilePhone;

    public Phone(String homePhone, String mobilePhone) {
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "{" +
                "homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}

class Person implements Serializable {

    private int id;
    private String name;
    transient private String gender;
    private Phone phone;

    public Person(int id, String name, String gender, Phone phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "study.IO.dictclient.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}

/**
 * @author Mr.lin
 * @version V1.0
 * @Package study.IO.dictclient
 * @date 2020/12/19 18:48
 */
public class DictClient {
    public static void main(String[] args) {

        byte[] buf = new byte[0];
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bout)) {
            Person person = new Person(990101, "Alice", "girl", new Phone("6686688", "17778595680"));
            oos.writeObject(person);
            buf = bout.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buf))) {
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
