package org.team1540.doofenshmirtz.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.kauailabs.navx.frc.AHRS;
public class ZeroNavX extends CommandBase {
    private AHRS navx;
    public ZeroNavX(AHRS navx) {
        this.navx = navx;
    }
    @Override
    public void execute() {
        System.out.println("Zeroing NavX");
        navx.zeroYaw();
    }
}
