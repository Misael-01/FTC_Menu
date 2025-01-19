package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class up_arm {
    //Initialize de los servos
    private final Servo servo1;
    private final Servo servo2;

    //Initialize Core Hex Motor
    private static DcMotor coreHexMotor;
    private static DcMotor coreHexMotor2;
    //INICIALIZAR MOTOR
    private final DcMotor up_down;
    //constructors
    public up_arm(HardwareMap hardwareMap){
        servo1 = hardwareMap.get(Servo.class,"servo1");
        servo2 = hardwareMap.get(Servo.class,"servo2");
        //CONSTRUCTOR FOR MOTOR UP_DOWN_ARM
        up_down = hardwareMap.dcMotor.get("up_down");


        //CONTRUCTOR CORE HEXMOTOR
        coreHexMotor = hardwareMap.get(DcMotor.class,"coreHexMotor1");
        coreHexMotor2 = hardwareMap.get(DcMotor.class,"coreHexMotor2");

        //configure motor direction
        coreHexMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        coreHexMotor2.setDirection(DcMotorSimple.Direction.FORWARD);

        //configure operation mode
        coreHexMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        coreHexMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //standby operation
        coreHexMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        coreHexMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void ontop(HardwareMap hardwareMap){
        up_down.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //setup coreHexMotor power
    public static void setMotorPower(double power) {
        coreHexMotor.setPower(power);
        coreHexMotor2.setPower(power);
    }
    //get actual motor power UP/DOWN MOTOR
    public  double getMotor_Power_Ontop(){
        return  up_down.getPower();
    }
    public double getMotor2Power(){
        return coreHexMotor2.getPower();
    }
    //get actual motor power
    public double getMotor1Power(){
        return coreHexMotor.getPower();
    }

    //Configure servo trigger position
    public void configureServo1(double triggerValue){
        servo1.setPosition(triggerValue);

    }

    public void configureServo2(double triggerValue){
        servo2.setPosition(triggerValue);
    }
    public double getServo1Position(){
        return servo1.getPosition();

    }

    public double getServo2Position() {
        return servo2.getPosition();
    }
}
