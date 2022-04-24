// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  private WPI_TalonFX m_fL, m_fR, m_rL, m_rR;
  public Drive() {
    m_fL = new WPI_TalonFX(Constants.driveConstants.FLid);
    m_fR = new WPI_TalonFX(Constants.driveConstants.FRid);
    m_rL = new WPI_TalonFX(Constants.driveConstants.RLid);
    m_rR = new WPI_TalonFX(Constants.driveConstants.RRid);

    m_fL.setNeutralMode(NeutralMode.Coast);
    m_fR.setNeutralMode(NeutralMode.Coast);
    m_rL.setNeutralMode(NeutralMode.Coast);
    m_rR.setNeutralMode(NeutralMode.Coast);
    
    m_fR.setInverted(true);
    m_rR.setInverted(true);


  }

  public void setLeft(double speed){
    m_fL.set(ControlMode.PercentOutput, speed);
    m_rL.set(ControlMode.PercentOutput, speed);
  }

  public void setRight(double speed){
    m_fR.set(ControlMode.PercentOutput, speed);
    m_rR.set(ControlMode.PercentOutput, speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
