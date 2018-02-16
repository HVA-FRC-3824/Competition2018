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
*
*********************************************************************/
public class IntakeTeleop extends Command
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    /*********************************************************************
     *
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
//        // Determine the intake angle from the joystick
//        double intakeAngle = -Robot.oi.opJoystick.getZ();
//        
//        // Set the intake based on the joystick setting
//        Robot.intake.setAngle(90 * intakeAngle);
//        
//        SmartDashboard.putNumber("Angle Value", (90 * intakeAngle));
        
        // Determine the intake wheel speed based on the joystick
        double intakeSpeed = -Robot.oi.opJoystick.getY();
        Robot.intake.setRPM(true, intakeSpeed * Constants.IntakeMaximumRPM);
        
        SmartDashboard.putNumber("Intake Wheel Speed", intakeSpeed * Constants.IntakeMaximumRPM);
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
        end();
    }
}