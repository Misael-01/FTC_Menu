package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class drive {
    private final DcMotor frontRight;
    private final DcMotor frontLeft;
    private final DcMotor backRight;
    private final DcMotor backLeft;
    public drive(HardwareMap hardwareMap) {

        frontRight = hardwareMap.dcMotor.get("front_right");
        frontLeft = hardwareMap.dcMotor.get("front_left");
        backRight = hardwareMap.dcMotor.get("back_right");
        backLeft = hardwareMap.dcMotor.get("back_left");

        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public  void  move(double x, double y, double rx){

        double power_max = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);

        frontRight.setPower((y - x - rx) / power_max);
        frontLeft.setPower((y + x + rx) / power_max);
        backRight.setPower((y + x - rx) / power_max);
        backLeft.setPower((y - x + rx) / power_max);



    }

}
