package org.team1540.candice.commands.turret;


import edu.wpi.first.wpilibj2.command.InstantCommand;
public class ZeroTurret extends InstantCommand {
    private Turret turret;
    public ZeroTurret(Turret turret) {
        this.turret = turret;
    }
    @Override
    public void execute() {
        System.out.println("Zeroing Turret Encoder");
        turret.zeroRotation();
    }
}
