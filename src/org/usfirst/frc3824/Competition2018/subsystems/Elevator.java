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
import org.usfirst.frc3824.Competition2018.RobotMap;
import org.usfirst.frc3824.Competition2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/*********************************************************************
 * 
 *********************************************************************/
public class Elevator extends Subsystem
{

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX lift = RobotMap.elevatorLift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /*********************************************************************
     *
     *********************************************************************/
    public Elevator()
    {
        lift.set(ControlMode.Velocity, 0);
        lift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        lift.setSensorPhase(false);
        
        lift.configClosedloopRamp(0, Constants.TalonInitialCommunicationTimeout);

        lift.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        lift.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        lift.configPeakOutputForward(Constants.ElevatorPIDMaximum, Constants.TalonInitialCommunicationTimeout);
        lift.configPeakOutputReverse(Constants.ElevatorPIDMinimum, Constants.TalonInitialCommunicationTimeout);

        lift.config_kF(0, Constants.ElevatorPIDParamF, Constants.TalonInitialCommunicationTimeout);
        lift.config_kP(0, Constants.ElevatorPIDParamP, Constants.TalonInitialCommunicationTimeout);
        lift.config_kI(0, Constants.ElevatorPIDParamI, Constants.TalonInitialCommunicationTimeout);
        lift.config_kD(0, Constants.ElevatorPIDParamD, Constants.TalonInitialCommunicationTimeout);

        resetPosition();
        
        System.out.println("*** Elevator Constructor ***");
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public void setRPM(boolean direction, double RPM)
    {
        /* Speed mode */
        /*
         * 4096 Units/Rev 100ms /min in either direction: velocity setpoint is
         * in units/100ms 500 RPM is maximum wheel speed
         */
        double targetVelocity_UnitsPer100ms = RPM * 4096 / 600;

        if (direction == true)
            targetVelocity_UnitsPer100ms = -targetVelocity_UnitsPer100ms;

        /* 1500 RPM in either direction */
        lift.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPID_Error()
    {
        return lift.getClosedLoopError(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getMotorVoltage()
    {
        return lift.getMotorOutputVoltage();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getMotorPercent()
    {
        return lift.getMotorOutputPercent();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public ControlMode getMotorControlMode()
    {
        return lift.getControlMode();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPID_Setpoint()
    {
        return lift.getClosedLoopTarget(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getVelocity()
    {
        return lift.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPosition()
    {
        return lift.getSelectedSensorPosition(0);
    }

    /*********************************************************************
     *  
     *********************************************************************/
    public void resetPosition()
    {
        lift.setSelectedSensorPosition(0, 0, 10);
    }

    /*********************************************************************
     *  
     *********************************************************************/
    @Override
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    /*********************************************************************
     * 
     *********************************************************************/
    @Override
    public void periodic()
    {
        // Put code here to be run every loop
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public void stop()
    {
        lift.set(0);

        SmartDashboard.putNumber("motorPercent", 0);
    }

//    /*********************************************************************
//     * 
//     *********************************************************************/
//    public void motorPercent(boolean directionUp)
//    {
//        // determine the desire elevator direction
//        if (directionUp == true)
//        {
//            // Raise the elevator
//            lift.set(ControlMode.PercentOutput, Constants.ElevatorVoltageUp);
//
//            SmartDashboard.putNumber("motorPercent", Constants.ElevatorVoltageUp);
//        }
//        else
//        {
//            // Lower the elevator
//            lift.set(ControlMode.PercentOutput, Constants.ElevatorVoltageDown);
//
//            SmartDashboard.putNumber("motorPercent", Constants.ElevatorVoltageDown);
//        }
//    }
}
