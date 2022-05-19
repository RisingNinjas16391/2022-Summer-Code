package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drive.DrivetrainSubsystem;

/**
 * This is NOT an opmode.
 * <p>
 * This class can be used to define all the specific hardware for a single robot.
 */
public class Hardware {
    private final ElapsedTime period = new ElapsedTime();
    /* Public OpMode members. */
    public DrivetrainSubsystem drivetrainSubsystem;
    public DcMotor intake;
    public DcMotor lift;
    public DcMotor climber;
    /* local OpMode members. */
    HardwareMap hwMap = null;

    /* Constructor */
    public Hardware() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        drivetrainSubsystem = new DrivetrainSubsystem(ahwMap);
        intake = ahwMap.get(DcMotorEx.class, "intake");
        climber = ahwMap.get(DcMotorEx.class, "climber");
        lift = ahwMap.get(DcMotorEx.class, "lift");

        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        climber.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);

        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        climber.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);

        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        climber.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intake.setPower(0);
        climber.setPower(0);
        lift.setPower(0);
    }
    public void displayTelemetry(Telemetry telemetry) {
        telemetry.addLine("Drive Encoder ticks")
                .addData("Front Left", drivetrainSubsystem.getWheelPositions().get(0))
                .addData("Front Right", drivetrainSubsystem.getWheelPositions().get(3))
                .addData("Back Left", drivetrainSubsystem.getWheelPositions().get(1))
                .addData("Back Right", drivetrainSubsystem.getWheelPositions().get(2));
        telemetry.update();
    }
}