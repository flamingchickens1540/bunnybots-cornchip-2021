package org.team1540.cornchip.commands.turret;

import org.team1540.cornchip.Constants.TurretConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnTurret extends CommandBase {
    private final Turret turret;
    private final Joystick joystick;

    private final double deadzone;
    private double multiplierMinimum;
    private double speedMultiplier;

    private double joystickX, joystickZ;

    public TurnTurret(Turret turret, Joystick joystick, double deadzone, double speedMultiplier) {
        this.turret = turret;
        this.joystick = joystick;
        this.deadzone = deadzone;
        this.speedMultiplier = speedMultiplier;
        addRequirements(turret);
    }

    public TurnTurret(Turret turret, Joystick joystick) {
        this.turret = turret;
        this.joystick = joystick;
        this.deadzone = TurretConstants.deadzone;
        this.speedMultiplier = TurretConstants.speedMultiplier;
        addRequirements(turret);
    }

    private void calculateSpeedMultiplier(double rawValue) {
        multiplierMinimum = SmartDashboard.getNumber("turret/speedMinimum", 0);
        speedMultiplier = (rawValue+1)/2;
        if (speedMultiplier < multiplierMinimum) {
            speedMultiplier = multiplierMinimum;
        }
    }

    private boolean checkDisabled() {
        int buttonIndex = (int) SmartDashboard.getNumber("turret/disableButton", 0);
        return joystick.getRawButton(buttonIndex);
    }

    @Override
    public void execute() {
        if (checkDisabled()) {
            turret.setPercent(0);
            return;
        }
        joystickX = joystick.getX();
        joystickZ = joystick.getZ();

        calculateSpeedMultiplier(joystickZ);
        if (Math.abs(joystickX) > deadzone) {
            turret.setPercent(joystickX * speedMultiplier);
        } else {
            turret.setPercent(0);
        }
    }
}
