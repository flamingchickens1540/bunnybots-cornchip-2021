package org.team1540.candice;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.team1540.candice.commands.drivetrain.DriveTrain;
import org.team1540.candice.commands.pump.Pump;
import org.team1540.candice.commands.shooter.ShootCommand;
import org.team1540.candice.commands.shooter.Shooter;
import org.team1540.candice.commands.turret.Turret;
import org.team1540.candice.commands.turret.ZeroTurret;
import org.team1540.candice.commands.turret.DisableSoftLimit;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    public final Joystick copilotJoystick = new Joystick(1);

    public final AHRS navx = new AHRS(SPI.Port.kMXP);

    public final DriveTrain driveTrain = new DriveTrain(NeutralMode.Brake);
    public final Turret turret = new Turret(navx, NeutralMode.Brake);
    public final Shooter shooter = new Shooter(NeutralMode.Brake);
    public final Pump pump = new Pump();

    public RobotContainer() {
        // Configure the button bindings\

        
        initSmartDashboard();
        configureButtonBindings();
    }


    private void configureButtonBindings() {
        new JoystickButton(copilotJoystick, 6)
            .whenPressed(new ZeroTurret(turret));

        new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
                .and(new JoystickButton(copilotJoystick, 3))
                .whileActiveOnce(new ShootCommand(shooter));

        new JoystickButton(copilotJoystick, 8)
            .whileActiveOnce(new DisableSoftLimit(turret));
        // if (shootConfirmation) {
        //     new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
        //         .and(new JoystickButton(copilotJoystick, 3))
        //         .whileActiveOnce(new ShootCommand(shooter));
        // } else {
        //     new JoystickButton(copilotJoystick, ButtonType.kTrigger.value)
        //         .whenHeld(new ShootCommand(shooter));
        // }
    }

    private void initSmartDashboard() {
        SmartDashboard.putNumber("turret/speedMinimum", SmartDashboard.getNumber("turret/speedMinimum", 0.1));
        SmartDashboard.putNumber("turret/disableButton", SmartDashboard.getNumber("turret/disableButton", 2));
        SmartDashboard.putBoolean("turret/shootConfirmation", SmartDashboard.getBoolean("turret/shootConfirmation", true));
        SmartDashboard.setDefaultBoolean("turret/shootConfirmation", true);
    }
    
}
