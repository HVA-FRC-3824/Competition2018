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

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.Competition2018.OI;
import org.usfirst.frc3824.Competition2018.RobotMap;
import org.usfirst.frc3824.Competition2018.commands.ChassisDriveDistance;
import org.usfirst.frc3824.Competition2018.subsystems.Chassis;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc3824.Competition2018.commands.*;
import org.usfirst.frc3824.Competition2018.subsystems.*;

/*********************************************************************
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *********************************************************************/
public class Robot extends TimedRobot
{
    private static Command  changePIDCommand           = null;
    Command                 autonomousCommand          = null;
    SendableChooser<String> autonomousCommandSelection = new SendableChooser<>();
    SendableChooser<String> startPositionChooser       = new SendableChooser<>();
    SendableChooser<String> oneTwoCubeChooser          = new SendableChooser<>();

    public static OI        oi;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static Intake intake;
    public static Elevator elevator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /*********************************************************************
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     *********************************************************************/
    @Override
    public void robotInit()
    {
        RobotMap.init();
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new Chassis();
        intake = new Intake();
        elevator = new Elevator();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        // (which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

//        chooser.addDefault("AutonomousCommand", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        // Add a selector for the Autonomous command
        autonomousCommandSelection.addObject("Nothing",         "Nothing");
        autonomousCommandSelection.addDefault("Cross Autoline", "Cross Autoline");
        autonomousCommandSelection.addObject("Center Switch",   "Center Switch");
        autonomousCommandSelection.addObject("Switch Or Scale", "Switch Or Scale");
        autonomousCommandSelection.addObject("Scale",           "Scale");
        SmartDashboard.putData("Autonomous Command", autonomousCommandSelection);

        // Add a selector for the starting position
        startPositionChooser.addDefault("Center", "Center");
        startPositionChooser.addObject("Left",    "Left");
        startPositionChooser.addObject("Right",   "Right");
        SmartDashboard.putData("Start Position", startPositionChooser);
        
        // Add a selector for the second cube command
        oneTwoCubeChooser.addDefault("None",  "None");
        oneTwoCubeChooser.addObject("Switch", "Switch");
        oneTwoCubeChooser.addObject("Scale",  "Scale");
        SmartDashboard.putData("Second Cube Placement", oneTwoCubeChooser);

        // Setup the USB camera server
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

        // Setup the camera
        camera.setResolution(160, 120);
        camera.setBrightness(30);
        camera.setExposureManual(40);
        
        // Set up FPID, velocity, and acceleration for SmartDashboard PID setting
        SmartDashboard.putNumber("F",          0.0);
        SmartDashboard.putNumber("P",          0.0);
        SmartDashboard.putNumber("I",          0.0);
        SmartDashboard.putNumber("D",          0.0);
        SmartDashboard.putNumber("Velocity",     0);
        SmartDashboard.putNumber("Acceleration", 0);
    }

    /*********************************************************************
     * This function is called when the disabled button is hit. You can use it
     * to reset subsystems before shutting down.
     *********************************************************************/
    @Override
    public void disabledInit()
    {

    }

    /*********************************************************************
     * This function is called when periodic is disabled
     *********************************************************************/
    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();

        // Show robot information on the SmartDashboard
        showInformationOnDashboard();
        
        // Verify the control panel buttons
//        checkButtons();
    }

    /*********************************************************************
     * This function is called just before autonomous period starts
     *********************************************************************/
    @Override
    public void autonomousInit()
    {
        chassis.resetNavXGyro();
        
        // Get the autonomous command selection
        String selection = autonomousCommandSelection.getSelected();

        // Call the appropriate autonomous command
        switch (selection)
            {
            // Just drive straight across the autonomous line
            case "Cross Autoline":
                autonomousCommand = new AutonomousCrossAutoLine();
                break;

            // Start in the center and place on the appropiate switch
            case "Center Switch":
                autonomousCommand = new AutonomousPlaceSwitchCenter();
                break;

            // Start on the left or right and place on the switch, if active, or the active scale
            case "Switch Or Scale":
                autonomousCommand = new AutonomousSwitchOrScale(startPositionChooser.getSelected(),
                                                                oneTwoCubeChooser.getSelected(),
                                                                autonomousCommandSelection.getSelected());
                break;
             
            // Start on the left or right and place on the appropiate scale
            case "Scale":
                autonomousCommand = new AutonomousSwitchOrScale(startPositionChooser.getSelected(),
                                                                oneTwoCubeChooser.getSelected(),
                                                                autonomousCommandSelection.getSelected());
                break;
                
             // Just drive straight across the autonomous line
            default:
                autonomousCommand = new AutonomousCrossAutoLine();
                break;   
            }

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
            autonomousCommand.start();
    }

    /*********************************************************************
     * This function is called periodically during autonomous
     *********************************************************************/
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();

        // Show robot information on the SmartDashboard
        showInformationOnDashboard();
    }

    /*********************************************************************
     * Routine called just before the teleoperator period
     *********************************************************************/
    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /*********************************************************************
     * This function is called periodically during operator control
     *********************************************************************/
    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();

        // Show robot information on the SmartDashboard
        showInformationOnDashboard();
    }
    
    /*********************************************************************
     * Report the pressed button
     *********************************************************************/
    public void checkButtons()
    {   
        // Support for up to 20 buttons
        for (int i = 1; i <= 20; i++)
        {   
            // Get the first button pressed
            if (Robot.oi.buttonPanel.getRawButtonPressed(i) == true)
            {
                // Show the button on the SmartDash board and exit
//                SmartDashboard.putNumber("Button Selected", i);
                break;
            }
        } 
    }
    /*********************************************************************
     * Show robot information on the SmartDashboard
     *********************************************************************/
    public void showInformationOnDashboard()
    {
         SmartDashboard.putNumber("rightEncoder",               chassis.getRightEncoder());
         SmartDashboard.putNumber("leftEncoder",                chassis.getLeftEncoder());
         SmartDashboard.putNumber("rightDistance",              chassis.getRightDistance());
         SmartDashboard.putNumber("leftDistance",               chassis.getLeftDistance());
        
         SmartDashboard.putNumber("Elevator Error",             elevator.getError());
         SmartDashboard.putNumber("Elevator MotorPercent",      elevator.getMotorPercent());
         SmartDashboard.putNumber("Elevator Velocity",          elevator.getVelocity());
         SmartDashboard.putNumber("Elevator Setpoint",          elevator.getSetpoint());
         SmartDashboard.putNumber("Elevator Position",          elevator.getPosition());
         SmartDashboard.putNumber("Elevator Current",           elevator.getCurrent());
        
         SmartDashboard.putNumber("Intake Angle Error",         intake.getAngleError());
         SmartDashboard.putNumber("Intake Angle MotorPercent",  intake.getAngleMotorPercent());
         SmartDashboard.putNumber("Intake Angle Setpoint",      intake.getAngleSetpoint());
         SmartDashboard.putNumber("Intake Angle Position",      intake.getAnglePositionEncoder());
         SmartDashboard.putNumber("Intake Angle Velocity",      intake.getAngleVelocity());
        
         SmartDashboard.putNumber("Intake Right Error",         intake.getWheelErrorRight());
         SmartDashboard.putNumber("Intake Right MotorPercent",  intake.getWheelMotorPercentRight());
         SmartDashboard.putNumber("Intake Right Setpoint",      intake.getWheelSetpointRight());
         SmartDashboard.putNumber("Intake Right Velocity",      intake.getWheelVelocityRight());
         
         SmartDashboard.putNumber("Intake Left Error",          intake.getWheelErrorLeft());
         SmartDashboard.putNumber("Intake Left MotorPercent",   intake.getWheelMotorPercentLeft());
         SmartDashboard.putNumber("Intake Left Setpoint",       intake.getWheelSetpointLeft());
         SmartDashboard.putNumber("Intake Left Velocity",       intake.getWheelVelocityLeft());
        
         SmartDashboard.putNumber("UltraSonic Distance Inches", chassis.getUltrasonicDistance());
        
         SmartDashboard.putNumber("navx Gyro Angle: ",          chassis.getNavxAngle());
         SmartDashboard.putNumber("navx Gyro Error",            chassis.angleGyroPID.getError());
    }
}
