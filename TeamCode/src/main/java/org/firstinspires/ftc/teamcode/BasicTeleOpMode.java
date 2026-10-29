package org.firstinspires.ftc.teamcode;
/*motors

wheels

intake

shooter

for continous rotational servos (mini motors):
flower intake
transfer
use CRServo replaces DcMotor
*/

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class BasicTeleOpMode extends LinearOpMode {
    private DcMotor FLW, FRW, BLW, BRW;
    private DcMotor intake, launcher;
    private CRServo flowerIntakeLeft, flowerIntakeRight, transfer;

    @Override
    public void runOpMode() throws InterruptedException {
        FLW = hardwareMap.get(DcMotor.class, "FLW");
        FRW = hardwareMap.get(DcMotor.class, "FRW");
        BLW = hardwareMap.get(DcMotor.class, "BLW");
        BRW = hardwareMap.get(DcMotor.class, "BRW");

        flowerIntakeLeft = hardwareMap.get(CRServo.class, "flowerIntakeLeft");
        flowerIntakeRight = hardwareMap.get(CRServo.class, "flowerIntakeRight");
        transfer = hardwareMap.get(CRServo.class, "transfer");

        intake = hardwareMap.get(DcMotor.class, "intake");
        launcher = hardwareMap.get(DcMotor.class, "launcher");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }
}