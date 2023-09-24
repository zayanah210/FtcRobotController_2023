package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.openftc.easyopencv.PipelineRecordingParameters;

@Autonomous(name="DistanceTest", group="Example")
public class DistanceTest extends LinearOpMode {
    //creates containers for the motors to be used in the code
    DcMotor leftRear;
    DcMotor rightRear;
    DcMotor rightFront;
    DcMotor leftFront;

    public int DriveForwardDistance(int distance) {
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftRear.setTargetPosition(distance);
        rightRear.setTargetPosition(distance);
        leftFront.setTargetPosition(distance);
        rightFront.setTargetPosition(distance);

        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(leftRear.isBusy() && rightRear.isBusy() && leftFront.isBusy() && rightFront.isBusy()) {
            //waits until target position is reached
        }
        //stop and change back to normal
        leftRear.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);

        return(1);

    }

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
        leftRear.setPower(1);
        rightRear.setPower(1);
        leftFront.setPower(1);
        rightFront.setPower(1);

        sleep(200);

        leftRear.setPower(0);
        rightRear.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);

        DriveForwardDistance(30000);
        //if (stat !=1)
    }

}
