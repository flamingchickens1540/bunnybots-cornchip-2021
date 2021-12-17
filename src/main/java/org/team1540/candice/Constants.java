package org.team1540.candice;

public class Constants {
    public static final class Motors {
        public static final int valve = 7;
        public static final int pump = 8;
        public static final int turret = 5;
        public static final class Drive {
            public static final int leftFront = 4;
            public static final int leftRear = 3;
            public static final int rightFront = 6;
            public static final int rightRear = 2;
        }
    }
    public static final class DriveConstants {
        public static final double deadzone = 0.15;
        public static final double speedMultiplier = -0.5;
    }
    public static final class TurretConstants {
        public static final double speedMultiplier = 0.5;
        public static final double deadzone = 0.05;
    }
}
