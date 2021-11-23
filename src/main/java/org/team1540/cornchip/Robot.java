package org.team1540.cornchip;

import org.team1540.cornchip.commands.drivetrain.AvianDrive;
import org.team1540.cornchip.commands.drivetrain.TankDrive;
import org.team1540.cornchip.commands.turret.TurnTurret;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

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
        robotContainer.turret.setDefaultCommand(new TurnTurret(robotContainer.turret, robotContainer.copilotJoystick));
    }

    @Override
    public void autonomousInit() {
        robotContainer.driveTrain.setDefaultCommand(new AvianDrive(robotContainer.driveTrain));
    }
}