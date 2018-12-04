package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Drive subsystem.
 */
public class Led extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DigitalOutput led;

  public Led() {
    
    led = new DigitalOutput(RobotMap.led);
  }

  public void setLed(boolean value) {
    led.set(value);
  }

  public void toggleLed() {
    System.out.println("Toggled");
    led.set(!led.get());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
