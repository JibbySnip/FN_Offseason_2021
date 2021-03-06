// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainDriveCommand extends CommandBase {
  
  Drivetrain m_drivetrain;
  Joystick driver;

  /** Creates a new DrivetrainDriveCommand. */
  public DrivetrainDriveCommand(Drivetrain drivetrain, Joystick driver) {
    m_drivetrain = drivetrain;
    this.driver = driver;

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (Constants.driveConstants.driveMode) {
      case ARCADE:
        m_drivetrain.arcadeDrive(-driver.getRawAxis(1), driver.getRawAxis(4));
      case TANK:
        m_drivetrain.tankDrive(-driver.getRawAxis(1), -driver.getRawAxis(3));
      case CURVATURE:
        m_drivetrain.curvatureDrive(-driver.getRawAxis(1), driver.getRawAxis(4), driver.getRawButtonPressed(5));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
