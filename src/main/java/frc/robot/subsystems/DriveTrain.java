package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Drive subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private ADXRS450_Gyro gyro;
  private Spark leftMotor, rightMotor;
  private DifferentialDrive drive;

  public DriveTrain() {
    gyro = new ADXRS450_Gyro();
    leftMotor = new Spark(RobotMap.leftMotor);
    rightMotor = new Spark(RobotMap.rightMotor);
    drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public void calibrate() {
    gyro.calibrate();
  }

  public double getAngle() {
    return gyro.getAngle();
  }

  public void teleopDrive(XboxController stick) {
    drive.arcadeDrive(stick.getY(Hand.kLeft), stick.getX(Hand.kRight));
    SmartDashboard.putNumber("Joystick Left", stick.getY(Hand.kLeft));
    SmartDashboard.putNumber("Joystick Right", stick.getY(Hand.kRight));
    SmartDashboard.putNumber("Gyro Angle", getAngle());
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
