package org.team1540.terminator.commands.drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AvianDrive extends CommandBase {

    private final DriveTrain driveTrain;

    public AvianDrive(DriveTrain drivetrain) {
        this.driveTrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        if (SmartDashboard.getNumber("avian/detected_hands", 0) == 0) {
            driveTrain.disableMotors();
        }
        driveTrain.setPercent(
            SmartDashboard.getNumber("avian/left_tank", 0),
            SmartDashboard.getNumber("avian/right_tank", 0)
        );
        
    }
}
