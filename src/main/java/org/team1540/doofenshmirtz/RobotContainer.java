package org.team1540.doofenshmirtz;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;

import org.team1540.doofenshmirtz.commands.drivetrain.DriveTrain;
import org.team1540.doofenshmirtz.commands.shooter.ShootCommand;
import org.team1540.doofenshmirtz.commands.shooter.Shooter;
import org.team1540.doofenshmirtz.commands.turret.Turret;
import org.team1540.doofenshmirtz.commands.turret.ZeroNavX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    public final Joystick copilotJoystick = new Joystick(1);

    public final AHRS navx = new AHRS(SPI.Port.kMXP);

    public final DriveTrain driveTrain = new DriveTrain(NeutralMode.Brake);
    public final Turret turret = new Turret(navx, NeutralMode.Brake);
    // public final Shooter shooter = new Shooter(IdleMode.kBrake);

    private boolean shootConfirmation;

    public RobotContainer() {
        // Configure the button bindings\

        
        initSmartDashboard();
        configureButtonBindings();


    }

    private void configureButtonBindings() {
        shootConfirmation = SmartDashboard.getBoolean("turret/shootConfirmation", true);
        // if (shootConfirmation) {
        //     new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
        //         .and(new JoystickButton(copilotJoystick, 3))
        //         .whileActiveOnce(new ShootCommand(shooter));
        // } else {
        //     new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
        //         .whenHeld(new ShootCommand(shooter));
        // }
        new JoystickButton(copilotJoystick, 4)
            .whenActive(new ZeroNavX(navx));
        
    }

    private void initSmartDashboard() {
        SmartDashboard.putNumber("turret/speedMinimum", SmartDashboard.getNumber("turret/speedMinimum", 0.1));
        SmartDashboard.putNumber("turret/disableButton", SmartDashboard.getNumber("turret/disableButton", 2));
        // SmartDashboard.putBoolean("turret/shootConfirmation", SmartDashboard.getBoolean("turret/shootConfirmation", true));
        SmartDashboard.setDefaultBoolean("turret/shootConfirmation", true);
    }
    
}