package org.team1540.candice.commands.turret;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DisableSoftLimit extends CommandBase {
    private final Turret turret;

    public DisableSoftLimit(Turret turret) {
        this.turret = turret;
        addRequirements(turret);
    }
    
    @Override
    public void initialize() {
        turret.setSoftLimit(false);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        turret.setSoftLimit(true);
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
