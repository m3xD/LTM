import TCP.Student;

import java.io.*;
import java.net.Socket;

public class Ex_TCP_Object {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        objectOutputStream.writeObject("B21DCVT246;ES8K2OJV");
        objectOutputStream.flush();

        Student student = (Student) objectInputStream.readObject();

        student.setGpaLetter();

        objectOutputStream.writeObject(student);
        objectOutputStream.flush();

        objectOutputStream.close();
        objectInputStream.close();
        socket.close();
    }
}
