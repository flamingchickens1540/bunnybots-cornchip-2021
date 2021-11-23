package org.team1540.cornchip.commands.turret;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Turret extends SubsystemBase {
    private final TalonFX turretMotor = new TalonFX(8);

    public Turret() {
        initMotors(NeutralMode.Coast);
    }
    public Turret(NeutralMode brakeType) {
        initMotors(brakeType);
    }

    private void initMotors(NeutralMode brakeType) {
        
        turretMotor.configFactoryDefault();
        turretMotor.setNeutralMode(brakeType);

    }

    public void setPercent(double percent) {
        turretMotor.set(ControlMode.PercentOutput, percent);
    }

    public void disableMotors() {
        turretMotor.set(ControlMode.PercentOutput, 0);
    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}
