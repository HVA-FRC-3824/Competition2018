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
 * Elevator class
 *********************************************************************/
public class Elevator extends Subsystem
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX liftMaster = RobotMap.elevatorLiftMaster;
    private final WPI_TalonSRX liftSlave = RobotMap.elevatorLiftSlave;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private double elevatorPIDParamF      = Constants.ElevatorPIDParamF;
    private double elevatorPIDParamP      = Constants.ElevatorPIDParamP;
    private double elevatorPIDParamI      = Constants.ElevatorPIDParamI;
    private double elevatorPIDParamD      = Constants.ElevatorPIDParamD;
    private int    elevatorCruiseVelocity = Constants.ElevatorCruiseVelocity;
    private int    elevatorAcceleration   = Constants.ElevatorAcceleration;
    
    private double elevatorSetpoint       = 0;
    
    /*********************************************************************
     * Elevator constructor
     *********************************************************************/
    public Elevator()
    {
        // Reset the elevator position
        resetPosition();
        
        // Configure the elevator master velocity PID   
        liftMaster.set(ControlMode.MotionMagic, 0);
        
        liftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.setSensorPhase(true);
        
        liftMaster.configClosedloopRamp(0, Constants.TalonInitialCommunicationTimeout);

        liftMaster.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configPeakOutputForward(Constants.ElevatorPIDMaximum, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configPeakOutputReverse(Constants.ElevatorPIDMinimum, Constants.TalonInitialCommunicationTimeout);

        liftMaster.config_kF(0, elevatorPIDParamF, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kP(0, elevatorPIDParamP, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kI(0, elevatorPIDParamI, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kD(0, elevatorPIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        liftMaster.configMotionCruiseVelocity(Constants.ElevatorCruiseVelocity, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configMotionAcceleration(Constants.ElevatorAcceleration, Constants.TalonInitialCommunicationTimeout);

        // Make the slave follow the master
        liftSlave.follow(liftMaster);
    }

    /*********************************************************************
     * Set the Elevator default command
     *********************************************************************/
    @Override
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }

    /*********************************************************************
     * Method is called periodically for the Elevator
     *********************************************************************/
    @Override
    public void periodic()
    {
        
    }

    /*********************************************************************
     * Set the Elevator control RPM to set the velocity
     *********************************************************************/
    public void setRPM(boolean direction, double RPM)
    {
        // Speed mode 
        //    4096 Units/Rev 
        //    60 seconds in a minute
        //    100 ms PID loop time
        double targetVelocity = RPM * 4096.0 / 600.0;

        // Determine the elevator direction
        if (direction == true)
            targetVelocity = -targetVelocity;

        // Set the elevator velocity PID setpoint
        liftMaster.set(ControlMode.Velocity, targetVelocity);
    }
  
    /*********************************************************************
     * Set the desired Elevator position in encoder ticks
     *********************************************************************/
    public void setPosition(double position)
    {
        double intake_angle;
        
        // Determine the angle of the intake
        intake_angle = Robot.intake.getAnglePosition();
        
        // Ensure the elevator move does not cause a collision of the intake with the robot
        if ((position < Constants.ElevatorDownPosition) && (intake_angle < Constants.IntakeAngleMinimumElevatorDown))
            position = Constants.ElevatorDownPosition;
  
        // Ensure the elevator move does not cause a collision of the intake motor with the elevator components
        if ((position > Constants.ElevatorDownPosition) && (intake_angle > Constants.IntakeAngleMaximumAngle))
            position = Constants.ElevatorDownPosition;
        
        // Set the elevator velocity PID setpoint
        liftMaster.set(ControlMode.MotionMagic, position);
        
        // Remember the elevator PID setpoint
        elevatorSetpoint = position;
    }

    /*********************************************************************
     * Return the Elevator PID error
     *********************************************************************/
    public double getError()
    {
        return liftMaster.getClosedLoopError(0);
    }

    /*********************************************************************
     * Return the Elevator motor output percentage
     *********************************************************************/
    public double getMotorPercent()
    {
        return liftMaster.getMotorOutputPercent();
    }

    /*********************************************************************
     * Return the Elevator control mode
     *********************************************************************/
    public ControlMode getMotorControlMode()
    {
        return liftMaster.getControlMode();
    }

    /*********************************************************************
     * Report the Elevator PID setpoint
     *********************************************************************/
    public double getSetpoint()
    {
        return elevatorSetpoint;
    }

    /*********************************************************************
     * Report the Elevator velocity
     *********************************************************************/
    public double getVelocity()
    {
        return liftMaster.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
     * Report the Elevator encoder  position
     *********************************************************************/
    public double getPosition()
    {
        return liftMaster.getSelectedSensorPosition(0);
    }

    /*********************************************************************
     * Reset the Elevator encoder position
     *********************************************************************/
    public void resetPosition()
    {
        liftMaster.setSelectedSensorPosition(0, 0, 10);
    }

    /*********************************************************************
     * Stop the Elevator
     *********************************************************************/
    public void stop()
    {
        liftMaster.set(0);
    }
    
    /*********************************************************************
     * Return the Elevator current
     *********************************************************************/
    public double getCurrent()
    {
        return liftMaster.getOutputCurrent();
    }
    
    /*********************************************************************
     * Method to read the SmartDashboard FPID parameters and update the
     * Elevator PID parameters
     *********************************************************************/
    public void setElevatorPID()
    {
        // Read the FPID parameters from the SmartDashboard
        elevatorPIDParamF      = SmartDashboard.getNumber("F", Constants.ElevatorPIDParamF);
        elevatorPIDParamP      = SmartDashboard.getNumber("P", Constants.ElevatorPIDParamP);
        elevatorPIDParamI      = SmartDashboard.getNumber("I", Constants.ElevatorPIDParamI);
        elevatorPIDParamD      = SmartDashboard.getNumber("D", Constants.ElevatorPIDParamD);
        
        elevatorCruiseVelocity = (int)(SmartDashboard.getNumber("Velocity",     Constants.ElevatorCruiseVelocity));
        elevatorAcceleration   = (int)(SmartDashboard.getNumber("Acceleration", Constants.ElevatorAcceleration));
        
        // Set the Elevator FPID parameters
        liftMaster.config_kF(0, elevatorPIDParamF, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kP(0, elevatorPIDParamP, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kI(0, elevatorPIDParamI, Constants.TalonInitialCommunicationTimeout);
        liftMaster.config_kD(0, elevatorPIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        liftMaster.configMotionCruiseVelocity(elevatorCruiseVelocity, Constants.TalonInitialCommunicationTimeout);
        liftMaster.configMotionAcceleration(elevatorAcceleration, Constants.TalonInitialCommunicationTimeout);
    }
}
