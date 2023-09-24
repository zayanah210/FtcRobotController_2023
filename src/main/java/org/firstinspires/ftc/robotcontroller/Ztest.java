package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.openftc.easyopencv.PipelineRecordingParameters;

@Autonomous(name="Ztest", group="Example")
public class Ztest extends LinearOpMode {
//creates containers for the motors to be used in the code
    DcMotor leftRear;
    DcMotor rightRear;
    DcMotor rightFront;
    DcMotor leftFront;


    @Override
    public void runOpMode() throws InterruptedException {
        //retrieves motors from hardware map
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightRear = hardwareMap.dcMotor.get("rightRear");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftFront = hardwareMap.dcMotor.get("leftFront");


        leftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftRear.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        //everything before this command happened during initialization, everything after is after start

        //move towards spike
        leftFront.setPower(.5);
        leftRear.setPower(.5);
        rightFront.setPower(.5);
        rightRear.setPower(.5);


        leftFront.setPower(1);
        rightFront.setPower(1);
        leftRear.setPower(1);
        rightRear.setPower(1);

        //waits for 1 second
        sleep(300);

        leftRear.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);

        sleep(1000);

        //move back, turns the robot
        leftFront.setPower(-1);
        rightFront.setPower(-1);
        leftRear.setPower(-1);
        rightRear.setPower(-1);


        sleep(100);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

        rightFront.setPower(1);
        rightRear.setPower(1);

        sleep(700);

        rightFront.setPower(0);
        rightRear.setPower(0);

        //move past gate
        leftFront.setPower(-1);
        rightFront.setPower(-1);
        leftRear.setPower(-1);
        rightRear.setPower(-1);

        sleep(650);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);

        sleep(1000);

        //turns toward back
        rightFront.setPower(1);
        rightRear.setPower(1);

        sleep(350);

        rightFront.setPower(0);
        rightRear.setPower(0);

        leftFront.setPower(-1);
        rightFront.setPower(-1);
        leftRear.setPower(-1);
        rightRear.setPower(-1);

        sleep(375);

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);
        rightRear.setPower(0);





    }
}
