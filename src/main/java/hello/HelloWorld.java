package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
    public static LocalTime getCurrentTime() {
        return new LocalTime();
    }

    public static String getMessage() {
        Greeter greeter = new Greeter();
        return greeter.sayHello();
    }

    public static void main(String[] args) {
        LocalTime currentTime = getCurrentTime();
        System.out.println("The current local time is: " + currentTime);

        String message = getMessage();
        System.out.println(message);
        System.out.println("Hello World!");
    }
}

