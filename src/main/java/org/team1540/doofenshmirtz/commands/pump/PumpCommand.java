package org.team1540.doofenshmirtz.commands.pump;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PumpCommand extends CommandBase {
    private final Pump pump;
    private final Joystick joystick;
    private final double deadzone = 0.15;

    public PumpCommand(Pump pump, Joystick joystick) {
        this.pump = pump;
        this.joystick = joystick;
        addRequirements(pump);
    }
    


    @Override
    public void execute() {
        double output = -joystick.getY();
        if (output > deadzone) {
            pump.setPercent(output);
        }
    }

}
