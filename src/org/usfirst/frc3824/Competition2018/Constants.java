package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    // ***************************************************************************************
    // TalonSRX set timeout (ms)

    public static int    TalonInitialCommunicationTimeout = 10;

    // ***************************************************************************************
    // Chassis constants

    // ***************************************************************************************
    // Drive straight constants

    public static double DrivetrainDriveStraight_P        = 0.05;
    public static double DrivetrainDriveStraight_I        = 0.00005;
    public static double DrivetrainDriveStraight_D        = 0.0;

    public static double DrivetrainDriveMinimumOutput     = -1.0;
    public static double DrivetrainDriveMaximumOutput     = 1.0;

    public static double DRIVETRAIN_DRIVE_TOLERANCE       = 0.0;

    // ***************************************************************************************
    // Ultrasonic constants

    public static double ULTRASONIC_X1                    = 0.086669;
    public static double ULTRASONIC_Y1                    = 10.0;

    public static double ULTRASONIC_X2                    = 0.467592;
    public static double ULTRASONIC_Y2                    = 50.0;
    
    public static double ULTRASONIC_A                     = 108.23;
    public static double ULTRASONIC_B                     = -1.364;
    
    public static double ULTRASONIC_DRIVE_DISTANCE_RANGE  = 10.0;

    // ***************************************************************************************
    // Chassis turn constants

    public static double ChassisTurnThreshold             = 2.0;

    public static double TurnAngle_P                      = 0.015;
    public static double TurnAngle_I                      = 0.002;
    public static double TurnAngle_D                      = 0.002;

    public static double TurnAngle_MinimumOutput          = -0.4;
    public static double TurnAngle_MaximumOutput          = 0.4;

    // ***************************************************************************************
    // Intake angle constants

    public static double IntakeAngleEncoderMinusDegrees   = 250000;
    public static double IntakeAngleEncoderPlusDegrees    = 0;

    public static double IntakeAnglePIDParamF             = 0.0;
    public static double IntakeAnglePIDParamP             = 0.3;     // 0.2
    public static double IntakeAnglePIDParamI             = 0.000;   // 0.0
    public static double IntakeAnglePIDParamD             = 0.0;

    public static double IntakeAnglePIDMaximum            = 0.75;    // 0.2
    public static double IntakeAnglePIDMinimum            = -0.75;   // -0.2

    // ***************************************************************************************
    // Intake wheel constants

    public static double IntakeMaximumRPM                 = 500;

    public static double IntakeWheelPIDParamF             = 0.2;
    public static double IntakeWheelPIDParamP             = 0.02;
    public static double IntakeWheelPIDParamI             = 0.0002;
    public static double IntakeWheelPIDParamD             = 0.0;

    public static double IntakeWheelPIDMaximum            = 1.0;
    public static double IntakeWheelPIDMinimum            = -1.0;

    // ***************************************************************************************
    // Elevator Constants
    
    public static boolean ElevatorUsePosition             = false;
    
    public static double ElevatorRPM                      = 200;
    
    public static double ElevatorStartPosition            = 0;
    public static double ElevatorChutePosition            = 500;
    public static double ElevatorSwitchPosition           = 1000;
    public static double ElevatorScalePosition            = 2000;

    public static double ElevatorPIDParamF                = 0.4;
    public static double ElevatorPIDParamP                = 0.05;
    public static double ElevatorPIDParamI                = 0.002;
    public static double ElevatorPIDParamD                = 0.0;

    public static double ElevatorPIDMaximum               = 1.0;
    public static double ElevatorPIDMinimum               = -1.0;

    // ***************************************************************************************
    // Autonomous constants

    public static double AutoLineDriveDistance            = 10.0;
    public static double AutoLineDrivePower               = 0.5;

    public static double AutoCenterSwitchFromWall         = 1.0;
    public static double AutoCenterSwitchDiagonal         = 6.0;
    public static double AutoCenterSwitchToSwitch         = 1.0;
}
