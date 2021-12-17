package org.team1540.candice.commands.pump;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.team1540.candice.commands.shooter.Shooter;
public class PumpCommand extends CommandBase {
    private final Pump pump;
    private final Joystick joystick;
    private final Shooter shooter;
    private final double deadzone = 0.15;

    public PumpCommand(Pump pump, Joystick joystick, Shooter shooter) {
        this.pump = pump;
        this.joystick = joystick;
        this.shooter = shooter;
        addRequirements(pump);
    }
    


    @Override
    public void execute() {
        if (shooter.getValveOpen()) {
            return;
        }
        double output = -joystick.getY();
        if (output > deadzone) {
            pump.setPercent(output);
        }
    }

}
