package org.team1540.doofenshmirtz;

import org.team1540.doofenshmirtz.commands.drivetrain.AvianDrive;
import org.team1540.doofenshmirtz.commands.drivetrain.TankDrive;
import org.team1540.doofenshmirtz.commands.pump.PumpCommand;
import org.team1540.doofenshmirtz.commands.turret.TurnTurret;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;

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
        robotContainer.pump.setDefaultCommand(new PumpCommand(robotContainer.pump, robotContainer.copilotJoystick));
    }

    @Override
    public void autonomousInit() {
        robotContainer.driveTrain.setDefaultCommand(new AvianDrive(robotContainer.driveTrain));
    }

    @Override
    public void testInit() {
        robotContainer.driveTrain.setDefaultCommand(new TankDrive(robotContainer.driveTrain, robotContainer.driverController));
    }
    @Override
    public void testPeriodic() {
        System.out.println(robotContainer.navx.getYaw());
        if (robotContainer.copilotJoystick.getRawButtonPressed(4)) {
            robotContainer.navx.zeroYaw();
        }
    }
}