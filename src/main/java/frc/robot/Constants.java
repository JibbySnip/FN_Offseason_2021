// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import frc.robot.subsystems.Drivetrain.DriveMode;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class motorPorts {

            public static int rightMotor1 = 6;
            public static int rightMotor2 = 7;
        
            public static int leftMotor1 = 9;
            public static int leftMotor2 = 8;
			public static int leftMotor3;
			public static int rightMotor3;
        
        
    }

    public static final class driveConstants {
        public static DriveMode driveMode;

        public static double kS;
        public static double kV;
        public static double kA;

        public static boolean kLeftReversed;
		public static boolean kRightReversed;

		public static EncodingType kLeftEncoderReversed;

		public static DigitalSource kLeftEncoder2;

		public static DigitalSource kLeftEncoder1;

		public static boolean kLeftEncoder3;

		public static int kRightEncoder1;

		public static int kRightEncoder2;

		public static boolean kRightEncoder3;

		public static EncodingType kRightEncoderReversed;
        
    }
}
