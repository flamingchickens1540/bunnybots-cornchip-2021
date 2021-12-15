package org.team1540.candice.commands.turret;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;

public class Turret extends SubsystemBase {
    public final TalonSRX turretMotor = new TalonSRX(5);
    public double currentRotation, baseRotation, degreesSetpoint;
    public int threshold = this.degreesToSensorUnits(180);
    public Turret(AHRS navx) {
        initMotors(NeutralMode.Coast);

    }
    public Turret(AHRS navx, NeutralMode brakeType) {
        initMotors(brakeType);
    }
    

    private void initMotors(NeutralMode brakeType) {
        
        turretMotor.configFactoryDefault();
        turretMotor.setNeutralMode(brakeType);

        turretMotor.configReverseSoftLimitEnable(true);
        turretMotor.configForwardSoftLimitEnable(true);

        turretMotor.configReverseSoftLimitThreshold(-threshold);
        turretMotor.configForwardSoftLimitThreshold(threshold);
    }


    public void setPercent(double percent) {
        turretMotor.set(ControlMode.PercentOutput,percent);
    }

    public void zeroRotation() {
        turretMotor.setSelectedSensorPosition(0);
    }

    public int degreesToSensorUnits(double degrees) {
        return (int) degrees*(4096/180);
    }
    
    public double getDegrees() {
        return turretMotor.getSelectedSensorPosition()/(4096/180);
    }

    public void disableMotors() {
        turretMotor.set(ControlMode.PercentOutput, 0);
    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}
