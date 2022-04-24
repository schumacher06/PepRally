// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive;

public class DriveCommand extends CommandBase {
  private Drive drive;
  /** Creates a new DriveCommand. */
  public DriveCommand(Drive drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.setLeft(0);
    drive.setRight(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*if(RobotContainer.getController().getAButton()){
      drive.setRight();
    }
    if(RobotContainer.getController().getRightTrigger() > 0){
      drive.setRight(RobotContainer.getController().getRightTrigger());
    } else if(RobotContainer.getController().getRightBumper()){
      drive.setRight(-RobotContainer.getController().getLeftTrigger());
    } else{
      drive.setRight(0);
      drive.setLeft(0);
    }
    if(RobotContainer.getController().getLeftTrigger() > 0){
      drive.setLeft(RobotContainer.getController().getLeftTrigger());
    } else if(RobotContainer.getController().getLeftBumper()){
      drive.setLeft(-RobotContainer.getController().getRightTrigger());
    } else{
      drive.setLeft(0);
    }*/
    
    if (RobotContainer.getController().getRightY() > 0) {
      
      drive.setRight(RobotContainer.getController().getRightY());
      drive.setLeft(RobotContainer.getController().getRightY());

    } else if (RobotContainer.getController().getRightY() < 0) {

      drive.setRight(RobotContainer.getController().getRightY());
      drive.setLeft(RobotContainer.getController().getRightY());
    
    } else if (RobotContainer.getController().getLeftX() > 0) {
      
      drive.setRight(-RobotContainer.getController().getLeftX());
      drive.setLeft(RobotContainer.getController().getLeftX());
    
    } else if (RobotContainer.getController().getLeftX() < 0) {
      
      drive.setRight(-RobotContainer.getController().getLeftX());
      drive.setLeft(RobotContainer.getController().getLeftX());
    
    } else {
      drive.setRight(0);
      drive.setLeft(0);
    }


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setLeft(0);
    drive.setRight(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
