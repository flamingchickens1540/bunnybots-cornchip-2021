package org.team1540.candice;

import org.team1540.candice.commands.drivetrain.AvianDrive;
import org.team1540.candice.commands.drivetrain.TankDrive;
import org.team1540.candice.commands.pump.Pump;
import org.team1540.candice.commands.pump.PumpCommand;
import org.team1540.candice.commands.shooter.Shooter;
import org.team1540.candice.commands.turret.TurnTurret;
import org.team1540.candice.commands.turret.Turret;
import org.team1540.candice.commands.drivetrain.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private RobotContainer robotContainer;

    private DriveTrain driveTrain;
    private Shooter shooter;
    private Pump pump;
    private Turret turret;

    private XboxController driverController;
    private Joystick copilotJoystick;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        driveTrain = this.robotContainer.driveTrain;
        shooter = this.robotContainer.shooter;
        pump = this.robotContainer.pump;
        turret = this.robotContainer.turret;

        driverController = this.robotContainer.driverController;
        copilotJoystick = this.robotContainer.copilotJoystick;
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        driveTrain.setDefaultCommand(new TankDrive(driveTrain, driverController));
        turret.setDefaultCommand(new TurnTurret(turret, copilotJoystick));
        pump.setDefaultCommand(new PumpCommand(pump, copilotJoystick,shooter));
    }

    @Override
    public void autonomousInit() {
        driveTrain.setDefaultCommand(new AvianDrive(driveTrain,pump,shooter));
    }

    @Override
    public void disabledInit() {
        System.out.println("Disabled");
    }
}