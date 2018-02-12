// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.Competition2018.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3824.Competition2018.Constants;
import org.usfirst.frc3824.Competition2018.Robot;

/**
 *
 */
public class ChassisDriveRange extends Command
{
    
    private Timer m_Timer;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_distance;
    private double m_power;
    private double m_angle;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ChassisDriveRange(double distance, double power, double angle)
    {

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_distance = distance;
        m_power = power;
        m_angle = angle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        m_Timer = new Timer();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize()
    {
        System.out.println("Drive Straight Init: " + m_power); 

        // reset and start the timer
        m_Timer.reset();
        m_Timer.start();
        
        // Set the PID up for driving straight
        Robot.chassis.driveStraightPID(m_power, m_angle);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute()
    {
        // Slow down when reaching the desired position
        if (Math.abs(m_distance - Robot.chassis.getUltrasonicDistance()) < Constants.ULTRASONIC_DRIVE_DISTANCE_RANGE)
        {
            System.out.println("Change Magnitude");
            Robot.chassis.updateMagnitude(0.2);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished()
    {
     // Determine if the robot has reached the specified distance
        if (m_Timer.get() > 5.0)
        {
            // fail after 5.0 seconds
            return true;
        }

        // Determine if the robot has reached the desired distance
        // Note: Use absolute values since the distance can be negative
        return Math.abs(Robot.chassis.getUltrasonicDistance()) < Math.abs(m_distance);
    }

    // Called once after isFinished returns true
    @Override
    protected void end()
    {
        // Stop the chassis controllers and reset the encoders
        Robot.chassis.resetChassisPIDcontrollers();
        m_Timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted()
    {
        end();
    }
}
