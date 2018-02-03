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
import org.usfirst.frc3824.Competition2018.RobotMap;
import org.usfirst.frc3824.Competition2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Intake extends Subsystem
{

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX right = RobotMap.intakeRight;
    private final WPI_TalonSRX left = RobotMap.intakeLeft;
    private final AnalogInput angle = RobotMap.intakeAngle;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public void Intake()
    {	
    	left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
    	left.setSensorPhase(false);

    	left.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
    	left.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
    	left.configPeakOutputForward(0.5, Constants.TalonInitialCommunicationTimeout);
    	left.configPeakOutputReverse(-0.5, Constants.TalonInitialCommunicationTimeout);
    	
    	left.config_kF(0, Constants.IntakePIDParamF, Constants.TalonInitialCommunicationTimeout);
    	left.config_kP(0, Constants.IntakePIDParamP, Constants.TalonInitialCommunicationTimeout);
    	left.config_kI(0, Constants.IntakePIDParamI, Constants.TalonInitialCommunicationTimeout);
    	left.config_kD(0, Constants.IntakePIDParamD, Constants.TalonInitialCommunicationTimeout);
    	
    	right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
    	right.setInverted(true);

    	right.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
    	right.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
    	right.configPeakOutputForward(0.5, Constants.TalonInitialCommunicationTimeout);
    	right.configPeakOutputReverse(-0.5, Constants.TalonInitialCommunicationTimeout);
    	
    	right.config_kF(0, Constants.IntakePIDParamF, Constants.TalonInitialCommunicationTimeout);
    	right.config_kP(0, Constants.IntakePIDParamP, Constants.TalonInitialCommunicationTimeout);
    	right.config_kI(0, Constants.IntakePIDParamI, Constants.TalonInitialCommunicationTimeout);
    	right.config_kD(0, Constants.IntakePIDParamD, Constants.TalonInitialCommunicationTimeout);
    }

	@Override
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.1
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public void periodic()
	{
		// Put code here to be run every loop
		if (shouldStop()) 
		    setSpeed(0);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void setIntakeIn()
	{
		// speed we want intake to occur
		setSpeed(0);
	}

	public void setIntakeOut()
	{
		// speed for spitting out cube
		setSpeed(0);
	}
	
	public boolean shouldStop()
	{
		// TODO: add code to turn off wheels when cube is fully inside
		return false;
	}
	
	private void setSpeed(double speed)
	{
		/* Speed mode */
		/*
		* 4096 Units/Rev * 500 RPM / 600 100ms/min in either direction:
		* velocity setpoint is in units/100ms
		* 500 RPM is maximum wheel speed
		*/
		double targetVelocity_UnitsPer100ms = speed * 4096 * 500.0 / 600;
		/* 1500 RPM in either direction */
		left.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
		right.set(ControlMode.Velocity, targetVelocity_UnitsPer100ms);
	}
	
	//Start of getRightIntakeWheelRPM
	/*public int getRightIntakeWheelRPM()
	{
	    right.get();
	}*/
}
