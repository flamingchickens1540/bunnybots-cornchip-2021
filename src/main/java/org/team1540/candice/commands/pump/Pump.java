package org.team1540.candice.commands.pump;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.team1540.candice.Constants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Pump extends SubsystemBase {
    private final TalonSRX pumpMotor = new TalonSRX(Constants.Motors.pump);

    public Pump() {
        initMotors(NeutralMode.Brake);
    }
    public Pump(NeutralMode brakeType) {
        initMotors(brakeType);
    }

    private void initMotors(NeutralMode brakeType) {
        pumpMotor.configFactoryDefault();
        pumpMotor.setNeutralMode(brakeType);
        pumpMotor.setInverted(false);

    }

    public void setPercent(double percent) {
        pumpMotor.set(ControlMode.PercentOutput, percent);
    }

    public void disableMotors() {
        this.setPercent(0);
    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}