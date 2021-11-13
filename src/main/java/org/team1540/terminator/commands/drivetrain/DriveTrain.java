package org.team1540.terminator.commands.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.team1540.terminator.Constants.DriveConstants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftMotorFront   = new TalonFX(1);
    private final TalonFX leftMotorRear    = new TalonFX(2);
    private final TalonFX rightMotorFront  = new TalonFX(3);
    private final TalonFX rightMotorRear   = new TalonFX(4);
    
    private final TalonFX driveMotors[]       = { leftMotorFront, leftMotorRear, rightMotorFront, rightMotorRear };
    private final TalonFX leftDriveMotors[]   = { leftMotorFront, leftMotorRear };
    private final TalonFX rightDriveMotors[]  = { rightMotorFront, rightMotorRear };
    
    public DriveTrain() {
        initMotors();
    }

    private void initMotors() {
        for (TalonFX motor : driveMotors) {
            motor.configFactoryDefault();
            motor.setNeutralMode(NeutralMode.Coast);
        }
        // Set configuration for left motors
        for (TalonFX motor: leftDriveMotors) {
            motor.setInverted(false);
        }
        // Set configuration for right motors
        for (TalonFX motor: rightDriveMotors) {
            motor.setInverted(true);
        }
        // Make rear motors follow front motors
        leftMotorRear.follow(leftMotorFront);
        rightMotorRear.follow(rightMotorFront);
        System.out.println(DriveConstants.speedMultiplier);
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
