package org.firstinspires.ftc.teamcode;

//importar librerias de ftc
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//declarar nombre de programa para visualizar en driver hub
@TeleOp(name = "menu_v3")
//clase main principal
public class OpMode_main extends OpMode {
    //declaración de variables
    drive m_drive;
    up_arm upArm;



    @Override
    //metodo inicializar
    public void init(){
        m_drive = new drive(hardwareMap);
        upArm = new up_arm(hardwareMap);
    }
    @Override
    //metodo ejecutar
    public void  loop(){
        //control core Hex Motor
        double power = -gamepad2.right_stick_y;
        //movement arm CoreHexMotor 1 & 2
        up_arm.setMotorPower(power);

        //movement train
        double y = gamepad1.left_stick_y;
        double x = -gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;
        //configuración boton para Ontop UP/DOWN motor
        double up = gamepad2.left_trigger;
        double down = gamepad2.right_trigger;

        m_drive.move(x,y,rx);
        //Read right trigger for Hex Core Motors
        double rightTriggerValue = gamepad1.right_trigger;//RT for servo1
        double leftTriggerValue = gamepad1.left_trigger;//LT for servo2 with right_stick_y

        //configure Core Hex motors using the trigger value
        upArm.configureServo1(rightTriggerValue);
        upArm.configureServo2(leftTriggerValue);

        //Telemetry Core Hex Motor and servos

        telemetry.addData("RT: ",upArm.getServo1Position());
        telemetry.addData("LT: ",upArm.getServo2Position());
        telemetry.addData("Servo1 Position: ",upArm.getServo1Position());
        telemetry.addData("Servo2 Position: ",upArm.getServo2Position());
        telemetry.addData("Hex Motor1 position: ",upArm.getMotor1Power());
        telemetry.addData("Hex Motor2 position: ",upArm.getMotor2Power());
        telemetry.addData("UP/DOWN motor: ",upArm.getMotor_Power_Ontop());
        telemetry.update();

    }



}
