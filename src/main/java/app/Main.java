package app;
import Controller.StartUpController;
import Enum.*;

public class Main {
    public static void main(String[] args) {

//        Scheduler scheduler=new Scheduler(3,2,1);
//
//        new Thread(scheduler).start();
//
//        Request request1=new Request(1,35,FanSpeed.LOW,1000, Mode.FAN);
//        scheduler.dealWithRequest(request1);
//        Request request2=new Request(2,40,FanSpeed.LOW,100,Mode.FAN);
//        scheduler.dealWithRequest(request2);
//        Request request3=new Request(3,40,FanSpeed.LOW,100,Mode.FAN);
//        scheduler.dealWithRequest(request3);
//        Request request4=new Request(4,40,FanSpeed.MEDIUM,100,Mode.FAN);
//        scheduler.dealWithRequest(request4);
//        Request request5=new Request(5,40,FanSpeed.LOW,100,Mode.FAN);
//        scheduler.dealWithRequest(request5);
        StartUpController startup=new StartUpController();
        startup.powerOn();
    }
}