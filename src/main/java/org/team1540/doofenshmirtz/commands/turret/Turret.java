package org.team1540.doofenshmirtz.commands.turret;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Turret extends SubsystemBase {
    private final TalonSRX turretMotor = new TalonSRX(8);
    public double currentRotation, baseRotation;
    private AHRS navx;
    public Turret(AHRS navx) {
        this.navx = navx;
        initMotors(NeutralMode.Coast);

    }
    public Turret(AHRS navx, NeutralMode brakeType) {
        this.navx = navx;
        initMotors(brakeType);
    }

    private void initMotors(NeutralMode brakeType) {
        
        turretMotor.configFactoryDefault();
        turretMotor.setNeutralMode(brakeType);

    }

    public void counterRotate() {
        baseRotation = navx.getAngle();
        this.setDegrees(-0);
    }

    public void setPercent(double percent) {
        turretMotor.set(ControlMode.PercentOutput, percent);
    }

    public void setDegrees(double percent) {
        currentRotation = turretMotor.getSelectedSensorPosition();
        turretMotor.set(ControlMode.Position, currentRotation+percent);
    }

    public void disableMotors() {
        turretMotor.set(ControlMode.PercentOutput, 0);
    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}
