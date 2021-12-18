package org.team1540.candice.commands.drivetrain;

import org.team1540.candice.commands.pump.Pump;
import org.team1540.candice.commands.shooter.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AvianDrive extends CommandBase {

    private final DriveTrain driveTrain;
    private final Pump pump;
    private final Shooter shooter;

    public AvianDrive(DriveTrain drivetrain, Pump pump, Shooter shooter) {
        this.driveTrain = drivetrain;
        this.pump = pump;
        this.shooter = shooter;
        addRequirements(drivetrain, pump, shooter);
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

        if (SmartDashboard.getBoolean("avian/left_pinch", false) && SmartDashboard.getBoolean("avian/right_pinch", false)) {
            shooter.openValve();
        } else {
            shooter.closeValve();
        }

        // throw new RuntimeException("Set gestures for smart dashboard pumping");

        if (SmartDashboard.getBoolean("avian/left_index_finger", false) && SmartDashboard.getBoolean("avian/right_index_finger", false)) {
            pump.setPercent(1);
        } else {
            pump.setPercent(0);
        }
    }
}
