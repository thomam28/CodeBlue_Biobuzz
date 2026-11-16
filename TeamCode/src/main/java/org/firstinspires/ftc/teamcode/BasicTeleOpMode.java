package org.firstinspires.ftc.teamcode;
/*make:
motors
wheels
intake
shooter


for continuous rotational servos (mini motors)
flower intake
transfer
use CRServo replaces DcMotor
*/


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class BasicTeleOpMode extends LinearOpMode {
    private DcMotor FLW, FRW, BLW, BRW;
    private DcMotorEx intake, launcher;
    private CRServo flowerIntakeLeft, flowerIntakeRight, transfer;
    private boolean intakeRunning = false;
    private boolean launcherRunning = false;
    private boolean flowerIntakeRunning = false;


    @Override
    public void runOpMode() throws InterruptedException {
        FLW = hardwareMap.get(DcMotor.class, "FLW");
        FRW = hardwareMap.get(DcMotor.class, "FRW");
        BLW = hardwareMap.get(DcMotor.class, "BLW");
        BRW = hardwareMap.get(DcMotor.class, "BRW");


        flowerIntakeLeft = hardwareMap.get(CRServo.class, "flowerIntakeLeft");
        flowerIntakeRight = hardwareMap.get(CRServo.class, "flowerIntakeRight");
        transfer = hardwareMap.get(CRServo.class, "transfer");


        intake = hardwareMap.get(DcMotorEx.class, "intake");
        launcher = hardwareMap.get(DcMotorEx.class, "launcher");


        FLW.setDirection(DcMotorSimple.Direction.FORWARD);
        BLW.setDirection(DcMotorSimple.Direction.FORWARD);
        FRW.setDirection(DcMotorSimple.Direction.REVERSE);
        BRW.setDirection(DcMotorSimple.Direction.REVERSE);
        //flower intake directiions
        flowerIntakeLeft.setDirection(CRServo.Direction.FORWARD);
        flowerIntakeRight.setDirection(CRServo.Direction.REVERSE);
        //flower intake directiions




        waitForStart();


        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            if (Math.abs(y) >= 0.4 || Math.abs(x) >= 0.4) {
                FLW.setPower(y);
                FRW.setPower(y);
                BLW.setPower(y);
                BRW.setPower(y);
                FLW.setPower(y + x);
                FRW.setPower(y - x);
                BLW.setPower(y - x);
                BRW.setPower(y + x);


                if (gamepad1.triangleWasPressed()) {
                    intakeRunning = !intakeRunning;
                }


                if (intakeRunning) {
                    intake.setPower(1);
                } else
                    intake.setPower(0);
            }


            if (gamepad1.crossWasPressed()) {
                launcherRunning = !launcherRunning;
            }
            //flower intake
            if(gamepad1.dpad_up){
                flowerIntakeRunning = true;
            }


            if (gamepad1.dpad_down){
                flowerIntakeRunning = true;
            }


            if (flowerIntakeRunning){
            }


            if (launcherRunning) {
                launcher.setPower(1);
            } else {
                launcher.setPower(0);
            }


            if (gamepad1.right_trigger >= 0.5) {
                transfer.setPower(1);
            } else {
                transfer.setPower(0);
            }


            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }
    }
}