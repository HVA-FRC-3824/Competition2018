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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.Competition2018.Constants;
import org.usfirst.frc3824.Competition2018.Robot;

/*********************************************************************
 *
 *********************************************************************/
public class ChassisTurnAngle extends Command
{
    private Timer  m_OnTargetTimer = new Timer();
    private Timer  m_WatchdogTimer = new Timer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_turnDegrees;
    private double m_power;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    /*********************************************************************
     *
     *********************************************************************/
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ChassisTurnAngle(double turnDegrees, double power)
    {
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_turnDegrees = turnDegrees;
        m_power = power;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    /*********************************************************************
     * Called just before this Command runs the first time
     *********************************************************************/
    @Override
    protected void initialize()
    {
        // Initialize the chassis turn angle PID
        Robot.chassis.turnAnglePID(m_turnDegrees, m_power);

        // Reset and start the on target timer
        m_OnTargetTimer.reset();
        m_OnTargetTimer.start();

        // Reset and start the on watch dog timer
        m_WatchdogTimer.reset();
        m_WatchdogTimer.start();
    }

    /*********************************************************************
     * Called repeatedly when this Command is scheduled to run
     *********************************************************************/
    @Override
    protected void execute()
    {
        
    }

    /*********************************************************************
     * Make this return true when this Command no longer needs to run execute()
     *********************************************************************/
    @Override
    protected boolean isFinished()
    {
        // Ensure the command ends after the watchdog time even if not on target
        if (m_WatchdogTimer.get() > Constants.ChassisTurnTimeOutTimeDefault)
        {
            return true;
        }

        if (Robot.chassis.gyroWithin(Constants.ChassisTurnThreshold))
        {
            // Ensure hold position for time out time
            if (m_OnTargetTimer.get() > 1.0)
            {
                return true;
            }
        }
        else
        {
            // Reset the timer since the move did not complete
            m_OnTargetTimer.reset();
        }

        // Not at proper angle
        return false;
    }

    /*********************************************************************
     * Called once after isFinished returns true
     *********************************************************************/
    @Override
    protected void end()
    {
        // Reset the chassis PID controller to stop the turn
        Robot.chassis.resetChassisPIDcontrollers();
        
        // Stop the timers
        m_OnTargetTimer.stop();
        m_WatchdogTimer.stop();
    }

    /*********************************************************************
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     *********************************************************************/
    @Override
    protected void interrupted()
    {
        end();
    }
}
