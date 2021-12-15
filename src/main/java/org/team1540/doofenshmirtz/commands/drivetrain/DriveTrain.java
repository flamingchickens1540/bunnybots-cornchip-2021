package org.team1540.doofenshmirtz.commands.drivetrain;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftMotorFront = new TalonFX(4);
    private final TalonFX leftMotorRear = new TalonFX(3);
    private final TalonFX rightMotorFront = new TalonFX(6);
    private final TalonFX rightMotorRear = new TalonFX(2);

    private final TalonFX driveMotors[] = { leftMotorFront, leftMotorRear, rightMotorFront, rightMotorRear };
    private final TalonFX leftDriveMotors[] = { leftMotorFront, leftMotorRear };
    private final TalonFX rightDriveMotors[] = { rightMotorFront, rightMotorRear };

    public DriveTrain() {
        initMotors(NeutralMode.Coast);
    }
    public DriveTrain(NeutralMode brakeType) {
        initMotors(brakeType);
    }

    private void initMotors(NeutralMode brakeType) {
        for (TalonFX motor : driveMotors) {
            motor.configFactoryDefault();
            motor.setNeutralMode(brakeType);
        }
        // Set configuration for left motors
        for (TalonFX motor : leftDriveMotors) {
            motor.setInverted(false);
        }
        // Set configuration for right motors
        for (TalonFX motor : rightDriveMotors) {
            motor.setInverted(true);
        }
        // Make rear motors follow front motors
        leftMotorRear.follow(leftMotorFront);
        rightMotorRear.follow(rightMotorFront);

    }

    public void setPercent(double leftPercent, double rightPercent) {
        leftMotorFront.set(ControlMode.PercentOutput, leftPercent);
        rightMotorFront.set(ControlMode.PercentOutput, rightPercent);
    }

    public void disableMotors() {
        leftMotorFront.set(ControlMode.PercentOutput, 0);
        rightMotorFront.set(ControlMode.PercentOutput, 0);
    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}
