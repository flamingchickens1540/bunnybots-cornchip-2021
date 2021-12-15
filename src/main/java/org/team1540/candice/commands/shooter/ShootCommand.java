package org.team1540.candice.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootCommand extends CommandBase {
    private final Shooter shooter;

    public ShootCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }
    
    @Override
    public void initialize() {
        shooter.openValve();
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        shooter.closeValve();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
