// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  public enum DriveMode {
    ARCADE,
    TANK,
    CURVATURE
  }

  private final DifferentialDrive m_drivetrain;

  private final CANSparkMax[] leftMotors = new CANSparkMax[]{
    new CANSparkMax(Constants.motorPorts.leftMotor1, MotorType.kBrushless),
    new CANSparkMax(Constants.motorPorts.leftMotor2, MotorType.kBrushless),
    new CANSparkMax(Constants.motorPorts.leftMotor3, MotorType.kBrushless)
  };

  private final CANSparkMax[] rightMotors = new CANSparkMax[]{
    new CANSparkMax(Constants.motorPorts.rightMotor1, MotorType.kBrushless),
    new CANSparkMax(Constants.motorPorts.rightMotor2, MotorType.kBrushless),
    new CANSparkMax(Constants.motorPorts.rightMotor3, MotorType.kBrushless)
  };

  private final SpeedControllerGroup leftMotorsGroup = new SpeedControllerGroup(leftMotors);
  private final SpeedControllerGroup rightMotorsGroup = new SpeedControllerGroup(rightMotors);

  private final CANEncoder leftEncoder = leftMotors[0].getEncoder();
  private final CANEncoder rightEncoder = rightMotors[0].getEncoder();
  

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    leftMotorsGroup.setInverted(Constants.driveConstants.kLeftReversed);
    rightMotorsGroup.setInverted(Constants.driveConstants.kRightReversed);

    m_drivetrain = new DifferentialDrive(leftMotorsGroup, rightMotorsGroup);

  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_drivetrain.tankDrive(leftSpeed, rightSpeed);
  }
  
  public void arcadeDrive(double throttle, double turn) {
    m_drivetrain.tankDrive(throttle, turn);
  }

  public void curvatureDrive(double throttle, double turn, boolean isQuickTurn) {
    m_drivetrain.curvatureDrive(throttle, turn, isQuickTurn);
  }
  
  public void setConversionFactors(int positionConversionFactor, int velocityConversionFactor) { 
    leftEncoder.setPositionConversionFactor(positionConversionFactor);
    rightEncoder.setPositionConversionFactor(positionConversionFactor);
    leftEncoder.setVelocityConversionFactor(velocityConversionFactor);
    rightEncoder.setVelocityConversionFactor(velocityConversionFactor);
  }
  
  public DifferentialDriveWheelSpeeds getWheelSpeeds() {
    return new DifferentialDriveWheelSpeeds(leftEncoder.getVelocity(),rightEncoder.getVelocity());
  }
  
  public void setMode(CANSparkMax motor) {
    motor.setIdleMode(Constants.driveConstants.kIdleMode);
  }

  public void setVoltage(double leftVoltage, double rightVoltage) {
    for (CANSparkMax m: leftMotors) {
      m.setVoltage(leftVoltage);
    }
    for (CANSparkMax m: rightMotors) {
      m.setVoltage(rightVoltage);
    }
    m_drivetrain.feed();
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

