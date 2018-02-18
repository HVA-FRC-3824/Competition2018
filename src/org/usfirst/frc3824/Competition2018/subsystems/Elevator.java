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
    private final WPI_TalonSRX liftMaster = RobotMap.elevatorLiftMaster;
    private final WPI_TalonSRX liftSlave = RobotMap.elevatorLiftSlave;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /*********************************************************************
     *
     *********************************************************************/
    public Elevator()
    {
        // Reset the elevator position
        resetPosition();
        
        // Configure the elevator master velocity PID
        
        if (Constants.ElevatorUsePosition == false)
        {
            liftMaster.set(ControlMode.Velocity, 0);
        } else
        {
            liftMaster.set(ControlMode.MotionMagic, 0);
        }
        
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.setSensorPhase(true);
        
        liftMaster.configClosedloopRamp(0, Constants.TalonInitialCommunicationTimeout);

        liftMaster.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configPeakOutputForward(Constants.ElevatorPIDMaximum, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configPeakOutputReverse(Constants.ElevatorPIDMinimum, Constants.TalonInitialCommunicationTimeout);

        liftMaster.config_kF(0, Constants.ElevatorPIDParamF, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kP(0, Constants.ElevatorPIDParamP, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kI(0, Constants.ElevatorPIDParamI, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kD(0, Constants.ElevatorPIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        liftMaster.configMotionCruiseVelocity(Constants.ElevatorCruiseVelocity, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configMotionAcceleration(Constants.ElevatorAcceleration, Constants.TalonInitialCommunicationTimeout);

        // Make the slave follow the master
        liftSlave.follow(liftMaster);
        
        System.out.println("*** Elevator Constructor ***");
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public void setRPM(boolean direction, double RPM)
    {
        /* Speed mode */
        /*
         * 4096 Units/Rev 
         * 60 seconds in a minute
         * 100 ms PID loop time
         */
        double targetVelocity = RPM * 4096.0 / 600.0;

        // Determine the elevator direction
        if (direction == true)
            targetVelocity = -targetVelocity;

        // Set the elevator velocity PID setpoint
        liftMaster.set(ControlMode.Velocity, targetVelocity);
    }
    
    public void setPosition(double position)
    {
        // Set the elevator velocity PID setpoint
        liftMaster.set(ControlMode.MotionMagic, position);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPID_Error()
    {
        return liftMaster.getClosedLoopError(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getMotorVoltage()
    {
        return liftMaster.getMotorOutputVoltage();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getMotorPercent()
    {
        return liftMaster.getMotorOutputPercent();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public ControlMode getMotorControlMode()
    {
        return liftMaster.getControlMode();
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPID_Setpoint()
    {
        return liftMaster.getClosedLoopTarget(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getVelocity()
    {
        return liftMaster.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
     * 
     *********************************************************************/
    public double getPosition()
    {
        return liftMaster.getSelectedSensorPosition(0);
    }

    /*********************************************************************
     *  
     *********************************************************************/
    public void resetPosition()
    {
        liftMaster.setSelectedSensorPosition(0, 0, 10);
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
        liftMaster.set(0);
    }
}
