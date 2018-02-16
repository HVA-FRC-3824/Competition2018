// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.Competition2018;

import org.usfirst.frc3824.Competition2018.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3824.Competition2018.subsystems.*;

/*********************************************************************
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *********************************************************************/
public class OI
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton driveDistance;
    public Joystick driveJoystick;
    public JoystickButton elevatorUp;
    public JoystickButton elevatorDown;
    public JoystickButton intakeIn;
    public JoystickButton intakeOut;
    public JoystickButton elevatorStart;
    public JoystickButton elevatorChute;
    public JoystickButton elevatorSwitch;
    public JoystickButton eleavatorScale;
    public JoystickButton intakeLevel;
    public JoystickButton intakeChute;
    public JoystickButton intakeShootAngle;
    public Joystick opJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /*********************************************************************
     * OI Constructor
     *********************************************************************/
    public OI()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        opJoystick = new Joystick(1);
        
        intakeShootAngle = new JoystickButton(opJoystick, 9);
        intakeShootAngle.whenPressed(new IntakeRotate(20));
        intakeChute = new JoystickButton(opJoystick, 10);
        intakeChute.whenPressed(new IntakeRotate(-80));
        intakeLevel = new JoystickButton(opJoystick, 11);
        intakeLevel.whenPressed(new IntakeRotate(0));
        eleavatorScale = new JoystickButton(opJoystick, 5);
        eleavatorScale.whenPressed(new ElevatorUpDownPosition(-50000));
        elevatorSwitch = new JoystickButton(opJoystick, 4);
        elevatorSwitch.whenPressed(new ElevatorUpDownPosition(0));
        elevatorChute = new JoystickButton(opJoystick, 3);
        elevatorChute.whenPressed(new ElevatorUpDownPosition(0));
        elevatorStart = new JoystickButton(opJoystick, 2);
        elevatorStart.whenPressed(new ElevatorUpDownPosition(0));
        intakeOut = new JoystickButton(opJoystick, 11);
        intakeOut.whileHeld(new IntakeInOut(false, 0));
        intakeIn = new JoystickButton(opJoystick, 10);
        intakeIn.whileHeld(new IntakeInOut(true, 0));
        elevatorDown = new JoystickButton(opJoystick, 7);
        elevatorDown.whileHeld(new ElevatorUpDown(false));
        elevatorUp = new JoystickButton(opJoystick, 6);
        elevatorUp.whileHeld(new ElevatorUpDown(true));
        driveJoystick = new Joystick(0);
        
        driveDistance = new JoystickButton(driveJoystick, 8);
        driveDistance.whenPressed(new ChassisDriveDistance(10.0, 0.5, 0.0));


        // SmartDashboard Buttons
        SmartDashboard.putData("ChassisDriveDistance: DISTANCE_10FT", new ChassisDriveDistance(10.0, 0.5, 0.0));
        SmartDashboard.putData("ChassisDriveDistanceReverse: DISTANCE_10FT", new ChassisDriveDistanceReverse(10.0, 0.4, 0));
        SmartDashboard.putData("ChassisTurnAngle: NinetyDegrees", new ChassisTurnAngle(0.0, 90.0));
        SmartDashboard.putData("ChassisResetEncoders", new ChassisResetEncoders());
        SmartDashboard.putData("ChassisGyroTest: Degrees90", new ChassisGyroTest(90, 0.5));
        SmartDashboard.putData("IntakeInOutTime: inTen", new IntakeInOutTime(true, 10, 500));
        SmartDashboard.putData("IntakeInOutTime: outTen", new IntakeInOutTime(false, 10, 500));
        SmartDashboard.putData("Gyro Reset", new GyroReset());
        SmartDashboard.putData("ChassisDriveRange: TWENTY_INCHES", new ChassisDriveRange(20.0, 0.4, 0.0));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }

    public Joystick getOpJoystick() {
        return opJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
