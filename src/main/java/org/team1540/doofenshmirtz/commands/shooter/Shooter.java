package org.team1540.doofenshmirtz.commands.shooter;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Shooter extends SubsystemBase {
    private final CANSparkMax valveMotor = new CANSparkMax(5, MotorType.kBrushless);

    public Shooter() {
        initMotors(IdleMode.kCoast);
    }
    public Shooter(IdleMode brakeType) {
        initMotors(brakeType);
    }

    private void initMotors(IdleMode brakeType) {
        valveMotor.setIdleMode(brakeType);
        valveMotor.restoreFactoryDefaults();
        valveMotor.setInverted(false);

    }

    public void setState(boolean open) {
        if (open) {
            valveMotor.set(0.5);
        } else {
            valveMotor.set(0);
        }
    }

    public void closeValve() {
        setState(false);
    }

    public void openValve() {
        setState(true);
    }

    public Command commandStop() {
        return new InstantCommand(this::closeValve, this);
    }
}
