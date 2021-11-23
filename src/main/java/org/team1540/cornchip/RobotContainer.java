package org.team1540.cornchip;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.team1540.cornchip.commands.drivetrain.DriveTrain;
import org.team1540.cornchip.commands.turret.Turret;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    public final Joystick copilotJoystick = new Joystick(1);

    public final DriveTrain driveTrain = new DriveTrain(NeutralMode.Brake);
    public final Turret turret = new Turret(NeutralMode.Brake);

    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
        initSmartDashboard();

    }

    private void configureButtonBindings() {

    }
    
    private void initSmartDashboard() {
        SmartDashboard.putNumber("turret/speedMinimum", SmartDashboard.getNumber("turret/speedMinimum", 0.1));
    }
    
}
