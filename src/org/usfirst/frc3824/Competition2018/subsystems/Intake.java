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

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/*********************************************************************
 * Intake class
 *********************************************************************/
public class Intake extends Subsystem
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX right = RobotMap.intakeRight;
    private final WPI_TalonSRX left = RobotMap.intakeLeft;
    private final WPI_TalonSRX angle = RobotMap.intakeAngle;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private double intakeAnglePIDParamF      = Constants.IntakeAnglePIDParamF;
    private double intakeAnglePIDParamP      = Constants.IntakeAnglePIDParamP;
    private double intakeAnglePIDParamI      = Constants.IntakeAnglePIDParamI;
    private double intakeAnglePIDParamD      = Constants.IntakeAnglePIDParamD;
    private int    intakeAngleCruiseVelocity = Constants.IntakeAngleCruiseVelocity;
    private int    intakeAngleAcceleration   = Constants.IntakeAngleAcceleration;
    
    private double intakeAngleSetpoint       = 0;
    
    private double intakeWheelPIDParamF      = Constants.IntakeWheelPIDParamF;
    private double intakeWheelPIDParamP      = Constants.IntakeWheelPIDParamP;
    private double intakeWheelPIDParamI      = Constants.IntakeWheelPIDParamI;
    private double intakeWheelPIDParamD      = Constants.IntakeWheelPIDParamD;
    
    private double intakeWheelLeftSetpoint   = 0;
    private double intakeWheelRightSetpoint  = 0;

    /*********************************************************************
     * Intake constructor
     *********************************************************************/
    public Intake()
    {
        /**********************************************************************************/
        left.set(ControlMode.Velocity, 0);
        left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        left.setSensorPhase(true);
        left.setInverted(false);

        left.configClosedloopRamp(0, Constants.TalonInitialCommunicationTimeout);

        left.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        left.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        left.configPeakOutputForward(Constants.IntakeWheelPIDMaximum, Constants.TalonInitialCommunicationTimeout);
        left.configPeakOutputReverse(Constants.IntakeWheelPIDMinimum, Constants.TalonInitialCommunicationTimeout);

        left.config_kF(0, intakeWheelPIDParamF, Constants.TalonInitialCommunicationTimeout);
        left.config_kP(0, intakeWheelPIDParamP, Constants.TalonInitialCommunicationTimeout);
        left.config_kI(0, intakeWheelPIDParamI, Constants.TalonInitialCommunicationTimeout);
        left.config_kD(0, intakeWheelPIDParamD, Constants.TalonInitialCommunicationTimeout);

        resetWheelPositionLeft();

        /**********************************************************************************/
        right.set(ControlMode.Velocity, 0);
        right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        right.setSensorPhase(false);
        right.setInverted(false);

        right.configClosedloopRamp(0, Constants.TalonInitialCommunicationTimeout);

        right.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        right.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        right.configPeakOutputForward(Constants.IntakeWheelPIDMaximum, Constants.TalonInitialCommunicationTimeout);
        right.configPeakOutputReverse(Constants.IntakeWheelPIDMinimum, Constants.TalonInitialCommunicationTimeout);

        right.config_kF(0, intakeWheelPIDParamF, Constants.TalonInitialCommunicationTimeout);
        right.config_kP(0, intakeWheelPIDParamP, Constants.TalonInitialCommunicationTimeout);
        right.config_kI(0, intakeWheelPIDParamI, Constants.TalonInitialCommunicationTimeout);
        right.config_kD(0, intakeWheelPIDParamD, Constants.TalonInitialCommunicationTimeout);

        resetWheelPositionRight();

        /**********************************************************************************/
        resetAnglePosition();
        
        angle.set(ControlMode.MotionMagic, 0);
        angle.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TalonInitialCommunicationTimeout);
        angle.setSensorPhase(true);
              
        angle.configNominalOutputForward(0, Constants.TalonInitialCommunicationTimeout);
        angle.configNominalOutputReverse(0, Constants.TalonInitialCommunicationTimeout);
        angle.configPeakOutputForward(Constants.IntakeAnglePIDMaximum, Constants.TalonInitialCommunicationTimeout);
        angle.configPeakOutputReverse(Constants.IntakeAnglePIDMinimum, Constants.TalonInitialCommunicationTimeout);
        
        angle.config_kF(0, intakeAnglePIDParamF, Constants.TalonInitialCommunicationTimeout);
        angle.config_kP(0, intakeAnglePIDParamP, Constants.TalonInitialCommunicationTimeout);
        angle.config_kI(0, intakeAnglePIDParamI, Constants.TalonInitialCommunicationTimeout);
        angle.config_kD(0, intakeAnglePIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        angle.configMotionCruiseVelocity(Constants.IntakeAngleCruiseVelocity, Constants.TalonInitialCommunicationTimeout);
        angle.configMotionAcceleration(Constants.IntakeAngleAcceleration, Constants.TalonInitialCommunicationTimeout);
        
        // Ensure the intake wheels are not moving
        stopWheels();
    }

    /*********************************************************************
     * Set the Intake default command
     *********************************************************************/
    @Override
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new IntakeTeleop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }

    /*********************************************************************
     * Method that runs in a periodic loop 
     *********************************************************************/
    @Override
    public void periodic()
    {
        
    }
    
    /*********************************************************************
     * Returns error of PID algorithm for the right intake controller
     *********************************************************************/
    public double getWheelErrorRight()
    {
        return right.getClosedLoopError(0);
    }

    /*********************************************************************
     * Returns percent of maximum output of right intake motor
     *********************************************************************/
    public double getWheelMotorPercentRight()
    {
        return right.getMotorOutputPercent();
    }

    /*********************************************************************
     * Returns current control mode for Talon SRXs for intake right motors
     *********************************************************************/
    public ControlMode getWheelMotorControlModeRight()
    {
        return right.getControlMode();
    }

    /*********************************************************************
     * Returns current setpoint being targeted for the right intake motors
     *********************************************************************/
    public double getWheelSetpointRight()
    {
        return intakeWheelRightSetpoint;
    }

    /*********************************************************************
     * Returns current velocity of right intake motor calculated by controller
     *********************************************************************/
    public double getWheelVelocityRight()
    {
        return right.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
     *  Returns current encoder position of right intake controller
     *********************************************************************/
    public double getWheelPositionRight()
    {
        return right.getSelectedSensorPosition(0);
    }
    
    /*********************************************************************
     *  Returns current current of right intake controller
     *********************************************************************/
    public double getWheelCurrentRight()
    {
        return right.getOutputCurrent();
    }

    /*********************************************************************
    * Resets right intake sensor encoder value to 0
    *********************************************************************/
    public void resetWheelPositionRight()
    {
        right.setSelectedSensorPosition(0, 0, Constants.TalonInitialCommunicationTimeout);
    }

    /*********************************************************************
     * Returns error of PID algorithm for the left intake controller
     *********************************************************************/
    public double getWheelErrorLeft()
    {
        return left.getClosedLoopError(0);
    }

    /*********************************************************************
     * Returns percent of maximum output of left intake motor
     *********************************************************************/
    public double getWheelMotorPercentLeft()
    {
        return left.getMotorOutputPercent();
    }

    /*********************************************************************
     * Returns current control mode for Talon SRXs for intake left motors
     *********************************************************************/
    public ControlMode getWheelMotorControlModeLeft()
    {
        return left.getControlMode();
    }

    /*********************************************************************
     * Returns current setpoint being targeted for the left intake motors
     *********************************************************************/
    public double getWheelSetpointLeft()
    {
        return intakeWheelLeftSetpoint;
    }

    /*********************************************************************
     * Returns current velocity of right intake motor calculated by controller
     *********************************************************************/
    public double getWheelVelocityLeft()
    {
        return left.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
     * Returns current encoder position of left intake controller
     *********************************************************************/
    public double getWheelPositionLeft()
    {
        return left.getSelectedSensorPosition(0);
    }
    
    /*********************************************************************
     *  Returns current current of left intake controller
     *********************************************************************/
    public double getWheelCurrentLeft()
    {
        return left.getOutputCurrent();
    }
    
    /*********************************************************************
    * Resets left intake sensor encoder value to 0
    *********************************************************************/
    public void resetWheelPositionLeft()
    {
        left.setSelectedSensorPosition(0, 0, Constants.TalonInitialCommunicationTimeout);
    }

    /*********************************************************************
    * Sets the RPM of the intake wheels to 0 (stops the motors)
    *********************************************************************/
    public void stopWheels()
    {
        // speed for spitting out cube
        left.set(0);
        right.set(0);
    }

    /*********************************************************************
     * Uses PIDs with Talon SRX encoder feedback to set the RPM of the intake wheels to a specified velocity
     *********************************************************************/
    public void setWheelsRPM(boolean direction, double RPM)
    {
        // Speed mode
        //    4096 Units/Rev / 600    (100ms/min)
        //    velocity setpoint is in units/100ms
        double targetVelocity = RPM * 4096 / 600;

        // Determine the wheel direction
        if (direction == true)
            targetVelocity = -targetVelocity;

        // Set the wheel PID velocity setpoint
        left.set(ControlMode.Velocity, targetVelocity);
        right.set(ControlMode.Velocity, targetVelocity);
        
        // Remember the intake wheel PID set points
        intakeWheelLeftSetpoint  = targetVelocity;
        intakeWheelRightSetpoint = targetVelocity;

//        SmartDashboard.putNumber("Intake Target Velocity", targetVelocity);
//        SmartDashboard.putNumber("Intake RPM",RPM);
    }
    
    /*********************************************************************
     * Uses PIDs with Talon SRX encoder feedback to set the RPM of the 
     * right intake wheels to a specified velocity
     *********************************************************************/
    public void setWheelRPM_Right(boolean direction, double RPM)
    {
        // Speed mode
        //    4096 Units/Rev / 600    (100ms/min)
        //    velocity setpoint is in units/100ms
        double targetVelocity = RPM * 4096 / 600;

        // Determine the wheel direction
        if (direction == true)
            targetVelocity = -targetVelocity;

        // Set the wheel PID velocity setpoint
        right.set(ControlMode.Velocity, targetVelocity);
        
        // Remember the intake wheel PID set point
        intakeWheelRightSetpoint = targetVelocity;
    }
    
    /*********************************************************************
     * Uses PIDs with Talon SRX encoder feedback to set the RPM of the 
     * left intake wheels to a specified velocity
     *********************************************************************/
    public void setWheelRPM_Left(boolean direction, double RPM)
    {
        // Speed mode
        //    4096 Units/Rev / 600    (100ms/min)
        //    velocity setpoint is in units/100ms
        double targetVelocity = RPM * 4096 / 600;

        // Determine the wheel direction
        if (direction == true)
            targetVelocity = -targetVelocity;

        // Set the wheel PID velocity setpoint
        left.set(ControlMode.Velocity, targetVelocity);
        
        // Remember the intake wheel PID set point
        intakeWheelLeftSetpoint = targetVelocity;
    }
    
    public void setWheelVoltageRight(boolean direction, double power)
    {
        // Determine the wheel direction
        if (direction == true)
            power = -power;

        // Set the wheel PID velocity setpoint
        right.set(ControlMode.PercentOutput, power);
    }
    
    public void setWheelVoltageLeft(boolean direction, double power)
    {
        // Determine the wheel direction
        if (direction == true)
            power = -power;

        // Set the wheel PID velocity setpoint
        left.set(ControlMode.PercentOutput, power);
    }
    
    /*********************************************************************
     * Sets voltage percent to intake wheels
     *********************************************************************/
    public void setBothWheelsVoltage(boolean direction, double power)
    {  
        // Determine the wheel direction
        if (direction == true)
            power = -power;

        // Set the wheel PID velocity setpoint
        left.set(ControlMode.PercentOutput, power);
        right.set(ControlMode.PercentOutput, power);
    }

    /*********************************************************************
     * Returns error of PID algorithm for the intake angle controller
     *********************************************************************/
    public double getAngleError()
    {
        return angle.getClosedLoopError(0);
    }

    /*********************************************************************
     * Returns percent of maximum output of intake angle motor
     *********************************************************************/
    public double getAngleMotorPercent()
    {
        return angle.getMotorOutputPercent();
    }

    /*********************************************************************
     * Returns current control mode for Talon SRXs for intake angle
     *********************************************************************/
    public ControlMode getAngleMotorControlMode()
    {
        return angle.getControlMode();
    }

    /*********************************************************************
     * Returns current setpoint being targeted for the intake angle
     *********************************************************************/
    public double getAngleSetpoint()
    {
        // Return the PID setpoint
        // Note: Saved as a local variable since we don't know how to read the setpoint
        //       from the talon SRX motor controllers
        return intakeAngleSetpoint;
    }
    
    /*********************************************************************
     * Returns current velocity of angle of intake as an encoder value
     *********************************************************************/
    public double getAngleVelocity()
    {
        return angle.getSelectedSensorVelocity(0);
    }

    /*********************************************************************
    * Resets angle sensor encoder value to 0
    *********************************************************************/
    public void resetAnglePosition()
    {
        angle.setSelectedSensorPosition(0, 0, Constants.TalonInitialCommunicationTimeout);
    }
    
    /*********************************************************************
     * Returns current angle of intake as an encoder value
     *********************************************************************/
    public double getAnglePositionEncoder()
    {
        return angle.getSelectedSensorPosition(0);
    }
    
    /*********************************************************************
     * Returns current angle of intake as an angle in degrees
     *********************************************************************/
    public double getAnglePosition()
    {
        double positionAngle;
        
        // Convert the encoder value to degrees
        positionAngle = (angle.getSelectedSensorPosition(0) - Constants.IntakeAngleEncoderYIntercept) *
                        (90.0 / Constants.IntakeAngleEncoderYIntercept);
                
        // Return the intake angle
        return positionAngle;       
    }

    /*********************************************************************
     * Uses PIDs with Talon SRX encoder feedback to set the position of the intake to a specified angle
     *********************************************************************/
    public void setAngle(double positionAngle)
    {
        if (positionAngle < Constants.IntakeAngleMinimumAngle)
        {
            positionAngle = Constants.IntakeAngleMinimumAngle;
        } 
        else if (positionAngle > Constants.IntakeAngleMaximumAngle)
        {
            positionAngle = Constants.IntakeAngleMaximumAngle;
        }

        // Calculate the encoder value from the angle in degrees
        double calculatedAngle = (positionAngle * (Constants.IntakeAngleEncoderYIntercept / 90)) + Constants.IntakeAngleEncoderYIntercept;
        
        // Remember the PID setpoint
        intakeAngleSetpoint = calculatedAngle;
        
        // Set the PID intake angle as an encoder value
        angle.set(ControlMode.MotionMagic, intakeAngleSetpoint);
        
//        SmartDashboard.putNumber("Calculated Angle", calculatedAngle);
    }
    
    /*********************************************************************
     *
     *********************************************************************/
    public void setAnglePosition(double position)
    {
        // Remember the PID setpoint
        intakeAngleSetpoint = position;
        
        // Set the intake angle PID setpoint
        angle.set(ControlMode.MotionMagic, intakeAngleSetpoint);
    }
    
    /*********************************************************************
     *
     *********************************************************************/
    public void setAnglePID()
    {
        intakeAnglePIDParamF      = SmartDashboard.getNumber("F", Constants.IntakeAnglePIDParamF);
        intakeAnglePIDParamP      = SmartDashboard.getNumber("P", Constants.IntakeAnglePIDParamP);
        intakeAnglePIDParamI      = SmartDashboard.getNumber("I", Constants.IntakeAnglePIDParamI);
        intakeAnglePIDParamD      = SmartDashboard.getNumber("D", Constants.IntakeAnglePIDParamD);
        intakeAngleCruiseVelocity = (int)SmartDashboard.getNumber("Velocity", Constants.IntakeAngleCruiseVelocity);
        intakeAngleAcceleration   = (int)SmartDashboard.getNumber("Acceleration", Constants.IntakeAngleAcceleration);
        
        angle.config_kF(0, intakeAnglePIDParamF, Constants.TalonInitialCommunicationTimeout);
        angle.config_kP(0, intakeAnglePIDParamP, Constants.TalonInitialCommunicationTimeout);
        angle.config_kI(0, intakeAnglePIDParamI, Constants.TalonInitialCommunicationTimeout);
        angle.config_kD(0, intakeAnglePIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        angle.configMotionCruiseVelocity(intakeAngleCruiseVelocity, Constants.TalonInitialCommunicationTimeout);
        angle.configMotionAcceleration(intakeAngleAcceleration,     Constants.TalonInitialCommunicationTimeout);
    }
    
    /*********************************************************************
     *
     *********************************************************************/
    public void setWheelPID()
    {
        intakeWheelPIDParamF = SmartDashboard.getNumber("F", Constants.IntakeWheelPIDParamF);
        intakeWheelPIDParamP = SmartDashboard.getNumber("P", Constants.IntakeWheelPIDParamP);
        intakeWheelPIDParamI = SmartDashboard.getNumber("I", Constants.IntakeWheelPIDParamI);
        intakeWheelPIDParamD = SmartDashboard.getNumber("D", Constants.IntakeWheelPIDParamD);
        
        left.config_kF(0, intakeWheelPIDParamF, Constants.TalonInitialCommunicationTimeout);
        left.config_kP(0, intakeWheelPIDParamP, Constants.TalonInitialCommunicationTimeout);
        left.config_kI(0, intakeWheelPIDParamI, Constants.TalonInitialCommunicationTimeout);
        left.config_kD(0, intakeWheelPIDParamD, Constants.TalonInitialCommunicationTimeout);
        
        right.config_kF(0, intakeWheelPIDParamF, Constants.TalonInitialCommunicationTimeout);
        right.config_kP(0, intakeWheelPIDParamP, Constants.TalonInitialCommunicationTimeout);
        right.config_kI(0, intakeWheelPIDParamI, Constants.TalonInitialCommunicationTimeout);
        right.config_kD(0, intakeWheelPIDParamD, Constants.TalonInitialCommunicationTimeout);
    }
}
