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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc3824.Competition2018.Constants;
import org.usfirst.frc3824.Competition2018.Robot;
import org.usfirst.frc3824.Competition2018.subsystems.*;

/*********************************************************************
 *
 *********************************************************************/
public class AutonomousPlaceSwitchCenter extends CommandGroup
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutonomousPlaceSwitchCenter() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

        double angle = Constants.AutoCenterSwitchFromWallAngle; // Assume placing on the right switch

        // Get the switch and scale settings
        String gameData = DriverStation.getInstance().getGameSpecificMessage();

        // Ensure the gameData is available
        if (gameData.length() > 0)
        {
            double additionalDistance = 0.0;

            // Set intake to horizontal position
            addParallel(new IntakeRotate(Constants.IntakePlaceAngle));

            // Raise elevator to switch height
            addParallel(new ElevatorUpDownPosition(Constants.ElevatorSwitchPosition));

            // Set intake wheel voltage to hold onto cube
            addParallel(new IntakeInOutVoltage(true, Constants.IntakeWheelHoldVoltage));

            // Drive forward to switch
            addSequential(new ChassisDriveDistance(Constants.AutoCenterSwitchFromWallDistance, 
                                                   Constants.AutoCenterSwitchFromWallPower, 0.0));

            // Determine which switch is active
            if (gameData.charAt(0) == 'L')
            {
                // Left switch so turn left and add drive distance
                angle = -angle;
                additionalDistance = Constants.AutoCenterSwitchAdditionalDistance;
            }

            // Turn towards the switch
            addSequential(new ChassisTurnAngle(angle, 0.0), Constants.ChassisTurnTimeOutTime);

            // Drive towards the switch
            addSequential(new ChassisDriveDistance(Constants.AutoCenterSwitchDiagonalDistance + additionalDistance, 
                                                   Constants.AutoCenterSwitchDiagonalPower, angle));

            // Turn to face the side of the switch
            addSequential(new ChassisTurnAngle(0.0, 0.0), Constants.ChassisTurnTimeOutTime);

            // Drive up to the switch
            addSequential(new ChassisDriveRange(Constants.AutoCenterSwitchToSwitchDistance, 
                                                Constants.AutoCenterSwitchToSwitchPower, 0.0));

            // Place the cube
            addSequential(new IntakeInOutTime(false, Constants.IntakeWheelShootTime, Constants.IntakeMaximumRPM));

            // Back up from the switch
            addSequential(new ChassisDriveDistance(Constants.AutoCenterSwitchBackUpDistance, 
                                                   Constants.AutoCenterSwitchBackUpPower, angle));

            // Set the intake and elevator to the home position for teleoperated period
            homeIntakeAndElevator();
        }
    }

    /*********************************************************************
     * Set the intake and the elevator to the home position
     *********************************************************************/
    public void homeIntakeAndElevator()
    {
        // Set intake to home position
        addSequential(new IntakeRotate(Constants.IntakeAngleHomePosition));

        // Set elevator to home position
        addSequential(new ElevatorUpDownPosition(Constants.ElevatorStartPosition));

        // Stop intake wheels
        addSequential(new IntakeInOut(true, 0));
    }
}
