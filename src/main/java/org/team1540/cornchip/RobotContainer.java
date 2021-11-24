package org.team1540.cornchip;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;

import org.team1540.cornchip.commands.drivetrain.DriveTrain;
import org.team1540.cornchip.commands.shooter.ShootCommand;
import org.team1540.cornchip.commands.shooter.Shooter;
import org.team1540.cornchip.commands.turret.Turret;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    public final Joystick copilotJoystick = new Joystick(1);

    public final DriveTrain driveTrain = new DriveTrain(NeutralMode.Brake);
    public final Turret turret = new Turret(NeutralMode.Brake);
    public final Shooter shooter = new Shooter(IdleMode.kBrake);

    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
        initSmartDashboard();

    }

    private void configureButtonBindings() {
        new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
            .whenHeld(new ShootCommand(shooter));
    }

    private void initSmartDashboard() {
        SmartDashboard.putNumber("turret/speedMinimum", SmartDashboard.getNumber("turret/speedMinimum", 0.1));
        SmartDashboard.putNumber("turret/disableButton", SmartDashboard.getNumber("turret/disableButton", 2));
    }
    
}
