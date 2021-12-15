package org.team1540.candice;

import org.team1540.candice.commands.drivetrain.AvianDrive;
import org.team1540.candice.commands.drivetrain.TankDrive;
import org.team1540.candice.commands.pump.PumpCommand;
import org.team1540.candice.commands.turret.TurnTurret;

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
        robotContainer.turret.setDefaultCommand(new InstantCommand(() -> {}));
        robotContainer.pump.setDefaultCommand(new InstantCommand(() -> {}));
    }

    @Override
    public void disabledInit() {
        System.out.println("Disabled");
    }
}