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
    
    private static SendableChooser<String> changePIDChooser = new SendableChooser<>();

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
        // Initialize the constants (difference between prototype and competition robots)
        Constants.InitConstants();
        
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
        autonomousCommandSelection.addObject("Nothing", "Nothing");
        autonomousCommandSelection.addDefault("Cross Autoline", "Cross Autoline");
        autonomousCommandSelection.addObject("Center Switch", "Center Switch");
        autonomousCommandSelection.addObject("Switch Or Scale", "Switch Or Scale");
        SmartDashboard.putData("Autonomous Command", autonomousCommandSelection);

        // Add a selector for the starting position
        startPositionChooser.addDefault("Center", "Center");
        startPositionChooser.addObject("Left", "Left");
        startPositionChooser.addObject("Right", "Right");
        SmartDashboard.putData("Start Position", startPositionChooser);
        
        // Add a selector for the second cube command
        oneTwoCubeChooser.addDefault("None", "None");
        oneTwoCubeChooser.addObject("Switch", "Switch");
        oneTwoCubeChooser.addObject("Scale", "Scale");
        SmartDashboard.putData("Second Cube Placement", oneTwoCubeChooser);
        
        // Add a selector for changing which subsystem change PID command will write to
        changePIDChooser.addDefault("Turn Angle", "Turn Angle");
        changePIDChooser.addObject("Elevator", "Elevator");
        changePIDChooser.addObject("Intake Rotator", "Intake Rotator");
        changePIDChooser.addObject("Intake Wheel", "Intake Wheel");
        changePIDChooser.addObject("Drive Straight", "Drive Straight");
        SmartDashboard.putData("PID Subsystem", changePIDChooser);
        
        // Setup the USB camera server
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

        // Setup the camera
        camera.setResolution(320, 240);
        camera.setBrightness(30);
        camera.setExposureManual(40);
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
        
        // Shows PID change selector
    }

    /*********************************************************************
     * This function is called just before autonomous period starts
     *********************************************************************/
    @Override
    public void autonomousInit()
    {
        String selection = autonomousCommandSelection.getSelected();

        switch (selection)
            {
            case "Cross Autoline":
                autonomousCommand = new AutonomousCrossAutoLine();
                break;

            case "Center Switch":
                autonomousCommand = new AutonomousPlaceSwitchCenter();
                break;

            case "Switch Or Scale":
                autonomousCommand = new AutonomousSwitchOrScale(startPositionChooser.getSelected(), oneTwoCubeChooser.getSelected());
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
    
    public static String getChangePIDChooser()
    {
        return changePIDChooser.getSelected();
    }
    
    /*********************************************************************
     * Show robot information on the SmartDashboard
     *********************************************************************/
    public void showInformationOnDashboard()
    {
         SmartDashboard.putNumber("rightEncoder", chassis.getRightEncoder());
         SmartDashboard.putNumber("leftEncoder", chassis.getLeftEncoder());
         SmartDashboard.putNumber("rightDistance", chassis.getRightDistance());
         SmartDashboard.putNumber("leftDistance", chassis.getLeftDistance());
//        
//         SmartDashboard.putNumber("gyro", chassis.getCurrentHeading());
//         SmartDashboard.putNumber("gyroTurnError", chassis.getAngleTurnError());
        
         SmartDashboard.putNumber("Elevator Error", Robot.elevator.getPID_Error());
//         SmartDashboard.putNumber("Elevator MotorPercent", Robot.elevator.getMotorPercent());
//         SmartDashboard.putNumber("Elevator Velocity", Robot.elevator.getVelocity());
         SmartDashboard.putNumber("Elevator Setpoint", Robot.elevator.getPID_Setpoint());
         SmartDashboard.putNumber("Elevator Position", Robot.elevator.getPosition());
        
//         SmartDashboard.putNumber("Intake Angle Error", Robot.intake.getPID_ErrorAngle());
//         SmartDashboard.putNumber("Intake Angle MotorPercent", Robot.intake.getMotorPercentAngle());
//         SmartDashboard.putNumber("Intake Angle Setpoint", Robot.intake.getPID_SetpointAngle());
         SmartDashboard.putNumber("Intake Angle Position", Robot.intake.getPositionAngle());
//         SmartDashboard.putNumber("Intake Angle Velocity", Robot.intake.getVelocityAngle());
        
//         SmartDashboard.putNumber("Intake Right Error", Robot.intake.getPID_ErrorRight());
//         SmartDashboard.putNumber("Intake Right MotorPercent", Robot.intake.getMotorPercentRight());
//         SmartDashboard.putNumber("Intake Right Setpoint", Robot.intake.getPID_SetpointRight());
//         SmartDashboard.putNumber("Intake Right Velocity", Robot.intake.getVelocityRight());
        
//         SmartDashboard.putNumber("Intake Left Error", Robot.intake.getPID_ErrorLeft());
//         SmartDashboard.putNumber("Intake Left MotorPercent", Robot.intake.getMotorPercentLeft());
//         SmartDashboard.putNumber("Intake Left Setpoint", Robot.intake.getPID_SetpointLeft());
//         SmartDashboard.putNumber("Intake Left Velocity", Robot.intake.getVelocityLeft());
        
         SmartDashboard.putNumber("UltraSonic Distance Inches", Robot.chassis.getUltrasonicDistance());
         SmartDashboard.putNumber("navx Gyro Angle: ", chassis.getNavxAngle());
//         SmartDashboard.putNumber("navx Gyro Error", chassis.angleGyroPID.getError());
    }
}
