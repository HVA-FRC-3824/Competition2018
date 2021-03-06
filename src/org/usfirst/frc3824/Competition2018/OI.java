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

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
    public JoystickButton intakeLevel;
    public JoystickButton intakeIn;
    public JoystickButton intakeChute;
    public JoystickButton intakeOut;
    public JoystickButton intakeShootAngle;
    public Joystick opJoystick;
    public JoystickButton intakeRotateDown;
    public JoystickButton intakeRotatePickup;
    public JoystickButton intakeRotateLevel;
    public JoystickButton intakeRotateShoot;
    public JoystickButton intakeRotateStepDown;
    public JoystickButton intakeRotateStepUp;
    public JoystickButton intakeWheelIn;
    public JoystickButton intakeWheelOut;
    public JoystickButton elevatorStepUp;
    public JoystickButton elevatorStepDown;
    public JoystickButton elevatorDown;
    public JoystickButton elevatorChute;
    public JoystickButton elevatorSwitch;
    public JoystickButton elevatorScale;
    public JoystickButton wiggleButton;
    public Joystick buttonPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private SendableChooser<String> changePIDChooser = new SendableChooser<>();

    /*********************************************************************
     * OI Constructor
     *********************************************************************/
    public OI()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonPanel = new Joystick(2);
        
        wiggleButton = new JoystickButton(buttonPanel, 17);
        wiggleButton.whenPressed(new IntakeRotateCube());
        elevatorScale = new JoystickButton(buttonPanel, 5);
        elevatorScale.whenPressed(new ElevatorUpDownScale());
        elevatorSwitch = new JoystickButton(buttonPanel, 6);
        elevatorSwitch.whenPressed(new ElevatorUpDownPosition(11000));
        elevatorChute = new JoystickButton(buttonPanel, 3);
        elevatorChute.whenPressed(new ElevatorUpDownPosition(0.0));
        elevatorDown = new JoystickButton(buttonPanel, 4);
        elevatorDown.whenPressed(new ElevatorUpDownPosition(-21000));
        elevatorStepDown = new JoystickButton(buttonPanel, 2);
        elevatorStepDown.whenPressed(new ElevatorStep(-1000));
        elevatorStepUp = new JoystickButton(buttonPanel, 1);
        elevatorStepUp.whenPressed(new ElevatorStep(1000));
        intakeWheelOut = new JoystickButton(buttonPanel, 10);
        intakeWheelOut.whenPressed(new IntakeInOut(false, 1.0));
        intakeWheelIn = new JoystickButton(buttonPanel, 14);
        intakeWheelIn.whenPressed(new IntakeInOut(true, 0.6));
        intakeRotateStepUp = new JoystickButton(buttonPanel, 12);
        intakeRotateStepUp.whenPressed(new IntakeRotateStep(500));
        intakeRotateStepDown = new JoystickButton(buttonPanel, 13);
        intakeRotateStepDown.whenPressed(new IntakeRotateStep(-500));
        intakeRotateShoot = new JoystickButton(buttonPanel, 15);
        intakeRotateShoot.whenPressed(new IntakeRotate(20));
        intakeRotateLevel = new JoystickButton(buttonPanel, 11);
        intakeRotateLevel.whenPressed(new IntakeRotate(0));
        intakeRotatePickup = new JoystickButton(buttonPanel, 4);
        intakeRotatePickup.whenPressed(new IntakeRotate(-10));
        intakeRotateDown = new JoystickButton(buttonPanel, 16);
        intakeRotateDown.whenPressed(new IntakeRotate(-90));
        opJoystick = new Joystick(1);
        
        intakeShootAngle = new JoystickButton(opJoystick, 9);
        intakeShootAngle.whenPressed(new IntakeRotate(20));
        intakeOut = new JoystickButton(opJoystick, 11);
        intakeOut.whileHeld(new IntakeInOut(false, 0));
        intakeChute = new JoystickButton(opJoystick, 10);
        intakeChute.whenPressed(new IntakeRotate(-80));
        intakeIn = new JoystickButton(opJoystick, 10);
        intakeIn.whileHeld(new IntakeInOut(true, 0));
        intakeLevel = new JoystickButton(opJoystick, 11);
        intakeLevel.whenPressed(new IntakeRotate(0));
        driveJoystick = new Joystick(0);
        
        driveDistance = new JoystickButton(driveJoystick, 8);
        driveDistance.whenPressed(new ChassisDriveDistance(10.0, 0.5, 0.0));


        // SmartDashboard Buttons
        SmartDashboard.putData("IntakeRotateCube", new IntakeRotateCube());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // Add a selector for changing which subsystem change PID command will write to
        changePIDChooser.addDefault("Turn Angle", "Turn Angle");
        changePIDChooser.addObject("Elevator", "Elevator");
        changePIDChooser.addObject("Intake Rotator", "Intake Rotator");
        changePIDChooser.addObject("Intake Wheel", "Intake Wheel");
        SmartDashboard.putData("PID Subsystem", changePIDChooser);

        SmartDashboard.putData("ChangePID", new ChangePID(changePIDChooser.getSelected()));
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }

    public Joystick getOpJoystick() {
        return opJoystick;
    }

    public Joystick getButtonPanel() {
        return buttonPanel;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
