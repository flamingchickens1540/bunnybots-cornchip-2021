package org.team1540.cornchip;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.team1540.cornchip.commands.drivetrain.*;

import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    private final XboxController copilotController = new XboxController(1);

    public final DriveTrain driveTrain = new DriveTrain(NeutralMode.Brake);

    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        
    }

    private void configureButtonBindings() {

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public void getAutonomousCommand() {
    }
    
}