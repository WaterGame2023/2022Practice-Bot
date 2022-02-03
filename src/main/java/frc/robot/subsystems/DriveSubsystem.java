// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.mototcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Change to proper CAN adress before use!!!
public class DriveSubsystem extends SubsystemBase {
  private TalonFX Left = new TalonFX(1);
  private TalonSRX gyroSRX = new TalonSRX(2);
  private TalonFX Right = new TalonFX(5);
  //private TalonSRX backRight = new TalonSRX(4);

  public DriveSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double left, double right) {
    Left.set(ControlMode.PercentOutput, -left);
    //backLeft.set(ControlMode.PercentOutput, -left);
    Right.set(ControlMode.PercentOutput, right);
    //backRight.set(ControlMode.PercentOutput, right);
  }

  public void arcadeDrive(double power, double steering) {
    double leftPower = power + steering;
    double rightPower = power - steering;
    tankDrive(leftPower, rightPower);
  }

  public void stop() {
    tankDrive(0, 0);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
