package org.team1540.terminator;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

import org.team1540.terminator.commands.drivetrain.AvianDrive;
import org.team1540.terminator.commands.drivetrain.TankDrive;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        robotContainer.driveTrain.setDefaultCommand(new TankDrive(robotContainer.driveTrain, robotContainer.driverController));
    }

    @Override
    public void autonomousInit() {
        robotContainer.driveTrain.setDefaultCommand(new AvianDrive(robotContainer.driveTrain));
    }
}