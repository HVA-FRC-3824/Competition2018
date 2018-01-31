package org.usfirst.frc3824.Competition2018;

public final class Constants
{
	// Chassis constants
	public static double ChassisEncoderDistancePerPulse 	= 0.01; // distance per pulse in FEET
	public static double ChassisTurnThreshold 			= 0.0;
					
	// ***************************************************************************************
	// Drive straight constants
	
	public static double DrivetrainDriveStraight_P 	= 0.05;
	public static double DrivetrainDriveStraight_I 	= 0.00005;
	public static double DrivetrainDriveStraight_D 	= 0.0;
		
	// ***************************************************************************************
	// Chassis turn constants
	
	public static double TurnAngle_P 				= 0.06;
	public static double TurnAngle_I 				= 0.0;
	public static double TurnAngle_D 				= 0.0;
	public static double TurnAngle_MinimumOutput 	= -0.4;
	public static double TurnAngle_MaximumOutput 	=  0.4;
	
	// ***************************************************************************************
	// Intake constants
	public static int TalonInitialCommunicationTimeout = 10; // timeout during setup (in ms)

	public static double IntakePIDParamF = 0;
	public static double IntakePIDParamP = 0;
	public static double IntakePIDParamI = 0;
	public static double IntakePIDParamD = 0;
	

}
