package org.team1540.doofenshmirtz.commands.drivetrain;

import org.team1540.doofenshmirtz.Constants.DriveConstants;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
    private final DriveTrain driveTrain;
    private final XboxController driverController;

    private final double deadzone;
    private final double speedMultiplier;

    private double leftY;
    private double rightY;
    private double leftSpeed;
    private double rightSpeed;

    public TankDrive(DriveTrain drivetrain, XboxController driver, double deadzone, double speedMultiplier) {
        this.driveTrain = drivetrain;
        this.driverController = driver;
        this.deadzone = deadzone;
        this.speedMultiplier = speedMultiplier;
        addRequirements(drivetrain);
    }

    public TankDrive(DriveTrain drivetrain, XboxController driver) {
        this.driveTrain = drivetrain;
        this.driverController = driver;
        this.deadzone = DriveConstants.deadzone;
        this.speedMultiplier = DriveConstants.speedMultiplier;
        addRequirements(drivetrain);
    }

    public TankDrive(DriveTrain drivetrain, XboxController driver, double speedMultiplier) {
        this.driveTrain = drivetrain;
        this.driverController = driver;
        this.deadzone = DriveConstants.deadzone;
        this.speedMultiplier = speedMultiplier;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        leftY = this.driverController.getY(Hand.kLeft);
        rightY = this.driverController.getY(Hand.kRight);

        if (Math.abs(leftY) > deadzone) {
            leftSpeed = leftY * this.speedMultiplier;
        } else {
            leftSpeed = 0;
        }

        if (Math.abs(rightY) > deadzone) {
            rightSpeed = rightY * this.speedMultiplier;
        } else {
            rightSpeed = 0;
        }

        driveTrain.setPercent(leftSpeed, rightSpeed);
    }
}
