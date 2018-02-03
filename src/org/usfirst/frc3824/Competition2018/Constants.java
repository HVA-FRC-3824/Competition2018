package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    // Chassis constants
    public static double ChassisTurnThreshold             = 0.0;

    // ***************************************************************************************
    // Drive straight constants

    public static double DrivetrainDriveStraight_P        = 0.05;
    public static double DrivetrainDriveStraight_I        = 0.00005;
    public static double DrivetrainDriveStraight_D        = 0.0;

    // ***************************************************************************************
    // Chassis turn constants

    public static double TurnAngle_P                      = 0.06;
    public static double TurnAngle_I                      = 0.0;
    public static double TurnAngle_D                      = 0.0;
    public static double TurnAngle_MinimumOutput          = -0.4;
    public static double TurnAngle_MaximumOutput          = 0.4;

    // ***************************************************************************************
    // Intake constants
    public static int    TalonInitialCommunicationTimeout = 10;     // timeout
                                                                    // during
                                                                    // setup (in
                                                                    // ms)

    public static double IntakePIDParamF                  = 0.0;
    public static double IntakePIDParamP                  = 0.0;
    public static double IntakePIDParamI                  = 0.0;
    public static double IntakePIDParamD                  = 0.0;

    // ***************************************************************************************
    // Elevator Constants
    public static double ElevatorVoltageUp                  = 0.5;
    public static double ElevatorVoltageDown                = -0.5;
    
    public static double ElevatorPIDParamF                  = 0.0;
    public static double ElevatorPIDParamP                  = 0.0;
    public static double ElevatorPIDParamI                  = 0.0;
    public static double ElevatorPIDParamD                  = 0.0;
    
    // ***************************************************************************************
    // Autonomous constants
    public static double AutoLineDriveDistance            = 10.0;
    public static double AutoLineDrivePower               = 0.5;
}
