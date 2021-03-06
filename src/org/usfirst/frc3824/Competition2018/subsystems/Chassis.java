// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.Competition2018.subsystems;

import org.usfirst.frc3824.Competition2018.Constants;
import org.usfirst.frc3824.Competition2018.Robot;
import org.usfirst.frc3824.Competition2018.commands.JoystickDrive;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc3824.Competition2018.RobotMap;
import org.usfirst.frc3824.Competition2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/*********************************************************************
 * Chassis class
 *********************************************************************/
public class Chassis extends Subsystem
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder leftDriveEncoder = RobotMap.chassisLeftDriveEncoder;
    private final Encoder rightDriveEncoder = RobotMap.chassisRightDriveEncoder;
    private final SpeedController driveR1 = RobotMap.chassisDriveR1;
    private final SpeedController driveR2 = RobotMap.chassisDriveR2;
    private final SpeedControllerGroup rightDrive = RobotMap.chassisRightDrive;
    private final SpeedController driveL1 = RobotMap.chassisDriveL1;
    private final SpeedController driveL2 = RobotMap.chassisDriveL2;
    private final SpeedControllerGroup leftDrive = RobotMap.chassisLeftDrive;
    private final DifferentialDrive driveTrain = RobotMap.chassisDriveTrain;
    private final AnalogInput ultrasonic = RobotMap.chassisultrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private double turnAngle_F              = Constants.TurnAngle_F;
    private double turnAngle_P              = Constants.TurnAngle_P;
    private double turnAngle_I              = Constants.TurnAngle_I;
    private double turnAngle_D              = Constants.TurnAngle_D;
    
    private double drivetrainDriveStraight_P = Constants.DrivetrainDriveStraight_P;
    private double drivetrainDriveStraight_I = Constants.DrivetrainDriveStraight_I;
    private double drivetrainDriveStraight_D = Constants.DrivetrainDriveStraight_D;

    private AHRS   ahrs = new AHRS(SPI.Port.kMXP);

    // Parameter used for drive while running under PID Control. The values
    // not set by the controller constructor can be set by a command directly
    private double m_magnitude;

    // PID controller for driving based on Gyro
    public PIDController angleGyroPID = new PIDController(drivetrainDriveStraight_P, 
                                                          drivetrainDriveStraight_I, 
                                                          drivetrainDriveStraight_D,
                                                          ahrs, new AnglePIDOutput());

    /*********************************************************************
     * Chassis constructor
     *********************************************************************/
    public Chassis()
    {
        // Reset the drive encoders
        resetEncoders();
        
        // Reset navx gyro
        resetNavXGyro();
        
        // Set the PID input range
        angleGyroPID.setInputRange(-360.0, 360.0);
    }

    /*********************************************************************
     * Method to set the chassis default command
     *********************************************************************/
    @Override
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new JoystickDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }

    /*********************************************************************
     * Method that is called periodically for the chassis subsystem
     *********************************************************************/
    @Override
    public void periodic()
    {
        
    }

    /*********************************************************************
     * Method to stop the chassis drive motors and disable/reset pids
     *********************************************************************/
    public void resetChassisPIDcontrollers()
    {
        // Reset the gyro PID 
        angleGyroPID.reset();

        // Disable the gyro PID controller
        angleGyroPID.disable();

        // Clear the drive magnitude
        // Note: The calling routine must reset the magnitude to the desired value
        m_magnitude = 0;

        // Ensure the robot is stopped
        chassisStop();
    }

    /*********************************************************************
     * Method to control the drive through the specified joystick
     *********************************************************************/
    public void driveWithJoystick(Joystick stick)
    {
        double twist     = -stick.getTwist();
        double moveValue =  stick.getY();

        // Reduce the sensitivity of the joystick
        if (Math.abs(twist) > 0.2)
            twist *= 0.8;
  
        // Drive with arcade control
        driveTrain.arcadeDrive(moveValue, twist);
    }

    /*********************************************************************
     * Method to configure the gyro based turn/drive straight PID controller
     *********************************************************************/
    public void driveStraightPID(double power, double angle)
    {
        // Drive straight means keep current heading
        startGyroPID(drivetrainDriveStraight_P, drivetrainDriveStraight_I, drivetrainDriveStraight_D, 
                     Constants.DrivetrainDriveMinimumOutput, Constants.DrivetrainDriveMaximumOutput, angle);
        
        // Update the drive power
        // Note: Used in the pidWrite method
        m_magnitude = power;
    }

    /*********************************************************************
     * Method to configure the gyro based turn/drive straight PID controller
     *********************************************************************/
    public void turnAnglePID(double desiredHeading, double power)
    {
        // Turn to the desired heading current heading
        startGyroPID(turnAngle_P, turnAngle_I, turnAngle_D, 
                     Constants.TurnAngle_MinimumOutput, Constants.TurnAngle_MaximumOutput, desiredHeading);
        
        // Update the drive power
        // Note: Used in the pidWrite method
        m_magnitude = power;
    }

    /*********************************************************************
     * Method to update output power while under PID control ie. after
     * startGyroPID() is called
     *********************************************************************/
    public void updateMagnitude(double magnitude)
    {
        // Update the drive magnitude
        m_magnitude = magnitude;
    }

    /*********************************************************************
     * Method to determine if the gyro angle is within the specified range
     *********************************************************************/
    public boolean gyroWithin(double threshold)
    {
        // Return if the gyro is within the specified range
        return Math.abs(angleGyroPID.getError()) < threshold;
    }

    /*********************************************************************
     * Method to return the maximum of the two chassis wheel encoders
     *********************************************************************/
    public double getEncoderDistance()
    {
        // Return the maximum encoder distance in case the other is not working
//      return Math.max(rightDriveEncoder.getDistance(), leftDriveEncoder.getDistance());
        return leftDriveEncoder.getDistance();
    }

    /*********************************************************************
     * Compute the distance based on the ultrasonic sensor
     *********************************************************************/
    public double getUltrasonicDistance()
    {
        // Return the distance in inches
        return (Constants.Ultrasonic_A * ultrasonic.getVoltage()) + Constants.Ultrasonic_B;
    }

    /*********************************************************************
     * Setup the chassis to be under PID control relative to start heading
     *********************************************************************/
    private void startGyroPID(double P, double I, double D, double minimumOutput, double maximumOutput, double desiredHeading)
    {
        // reset other PIDS
        resetChassisPIDcontrollers();

        // Initialize the Gryo angle PID parameters
        angleGyroPID.setPID(P, I, D);

        // Limit the output power when turning
        angleGyroPID.setOutputRange(minimumOutput, maximumOutput);

        // Set the desired chassis heading
        angleGyroPID.setSetpoint(desiredHeading);

        // Enable the Gyro PID
        angleGyroPID.enable();
    }

    /*********************************************************************
     * Method to set the desired heading
     *********************************************************************/
    public void updateHeadingPID_Setpoint(double desiredHeading)
    {
        // Set the desired chassis heading
        angleGyroPID.setSetpoint(desiredHeading);
    }

    /*********************************************************************
     * Class declaration for the PIDOutput
     *********************************************************************/
    private class AnglePIDOutput implements PIDOutput
    {
        /****************************************************************
         * Virtual function to receive the PID output and set the drive
         * direction
         ****************************************************************/
        public void pidWrite(double PIDoutput)
        {
            // Drive the robot given the speed and direction
            // Note: The Arcade drive expects a joystick which is negative forward
            driveTrain.arcadeDrive(-m_magnitude, -PIDoutput, false);
        }
    }

    /*********************************************************************
     * Get the gryo angle PID error
     *********************************************************************/
    public double getAngleTurnError()
    {
        return angleGyroPID.getError();
    }

    /*********************************************************************
     * Method to reset the right and left chassis encoders
     *********************************************************************/
    public void resetEncoders()
    {
        // Reset the left and right chassis wheel encoders
        rightDriveEncoder.reset();
        leftDriveEncoder.reset();
    }
    
    /*********************************************************************
     * Method to get the right chassis encoder value
     *********************************************************************/
    public int getRightEncoder()
    {
        return rightDriveEncoder.get();
    }

    /*********************************************************************
     * Method to get the left chassis encoder value
     *********************************************************************/
    public int getLeftEncoder()
    {
        return leftDriveEncoder.get();
    }

    /*********************************************************************
     * Method to get the right encoder distance
     *********************************************************************/
    public double getRightDistance()
    {
        return rightDriveEncoder.getDistance();
    }

    /*********************************************************************
     * Method to get the left encode distance
     *********************************************************************/
    public double getLeftDistance()
    {
        return leftDriveEncoder.getDistance();
    }
    
    /*********************************************************************
     * Method to get the chassis right motor output percent
     *********************************************************************/
    public double getChassisRightMotorPercent()
    {
        return driveR1.get();
    }
    
    /*********************************************************************
     * Method to get the chassis left motor output percent
     *********************************************************************/
    public double getChassisLeftMotorPercent()
    {
        return driveL1.get();
    }
    
    /*********************************************************************
     * Method to reset the NavX gyro
     *********************************************************************/
    public void resetNavXGyro()
    { 
        // Reset the NavX gyro
        ahrs.reset();
    }
    
    /*********************************************************************
     * Method to stop the chassis drive motors
     *********************************************************************/
    public void chassisStop()
    {
        // Ensure the robot is stopped
        driveTrain.arcadeDrive(0, 0);
    }
    
    /*********************************************************************
     * Method to return the NavX angle
     *********************************************************************/
    public double getNavxAngle()
    {
        // Return the NavX angle
        return ahrs.getAngle();
    }
    
    /*********************************************************************
     * Method to read the SmartDashboard FPID parameters and update the
     * chassis turn angle PID parameters
     *********************************************************************/
    public void setTurnAnglePID()
    {
        // Read the FPID parameters from the SmartDashboard
        turnAngle_F = SmartDashboard.getNumber("F", Constants.TurnAngle_F);
        turnAngle_P = SmartDashboard.getNumber("P", Constants.TurnAngle_P);
        turnAngle_I = SmartDashboard.getNumber("I", Constants.TurnAngle_I);
        turnAngle_D = SmartDashboard.getNumber("D", Constants.TurnAngle_D);
        
        // Set the turn angle FPID parameters
        angleGyroPID.setF(turnAngle_F);
        angleGyroPID.setF(turnAngle_P);
        angleGyroPID.setF(turnAngle_I);
        angleGyroPID.setF(turnAngle_D);
    }
}
