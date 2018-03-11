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

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.Competition2018.Constants;
import org.usfirst.frc3824.Competition2018.Robot;

/*********************************************************************
 * Intake Teleop class
 *********************************************************************/
public class IntakeTeleop extends Command
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    /*********************************************************************
     * Class constructor
     *********************************************************************/
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public IntakeTeleop()
    {
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.intake);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    /*********************************************************************
     * Called just before this Command runs the first time
     *********************************************************************/
    @Override
    protected void initialize()
    {
        
    }

    /*********************************************************************
     * Called repeatedly when this Command is scheduled to run
     *********************************************************************/
    @Override
    protected void execute()
    {
        // Set the intake wheels to hold the cube when not actively performing
        // a command
        Robot.intake.setBothWheelsVoltage(true, Constants.IntakeWheelHoldVoltage);
    }

    /*********************************************************************
     * Make this return true when this Command no longer needs to run execute()
     *********************************************************************/
    @Override
    protected boolean isFinished()
    {
        return false;
    }

    /*********************************************************************
     * Called once after isFinished returns true
     *********************************************************************/
    @Override
    protected void end()
    {
        
    }

    /*********************************************************************
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     *********************************************************************/
    @Override
    protected void interrupted()
    {
        
    }
}
