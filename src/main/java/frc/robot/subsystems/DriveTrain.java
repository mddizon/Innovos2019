package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;;

/**
 * Drive subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Spark leftMotor, rightMotor;
  private DifferentialDrive drive;

  public DriveTrain() {
    leftMotor = new Spark(RobotMap.leftMotor);
    rightMotor = new Spark(RobotMap.rightMotor);
    drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void teleopDrive(Joystick stick) {
    drive.arcadeDrive(stick.getY(), stick.getX());
  }

  public void stop() {
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
