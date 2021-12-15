package org.team1540.candice.commands.shooter;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Shooter extends SubsystemBase {
    private final TalonSRX valveMotor = new TalonSRX(7);

    public Shooter() {
        initMotors(NeutralMode.Brake);
    }
    public Shooter(NeutralMode brakeType) {
        initMotors(brakeType);
    }

    private void initMotors(NeutralMode brakeType) {
        valveMotor.configFactoryDefault();
        valveMotor.setNeutralMode(brakeType);
        valveMotor.setInverted(false);

    }

    public void setState(boolean open) {
        if (open) {
            valveMotor.set(ControlMode.PercentOutput, 1);
        } else {
            valveMotor.set(ControlMode.PercentOutput, 0);
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