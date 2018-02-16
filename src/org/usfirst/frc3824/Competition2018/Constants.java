package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    // ***************************************************************************************
    // TalonSRX set timeout (ms)

    public static int     TalonInitialCommunicationTimeout    = 10;

    // ***************************************************************************************
    // Chassis constants

    // ***************************************************************************************
    // Drive straight constants

    public static double  DrivetrainDriveStraight_P           = 0.05;
    public static double  DrivetrainDriveStraight_I           = 0.00005;
    public static double  DrivetrainDriveStraight_D           = 0.0;

    public static double  DrivetrainDriveMinimumOutput        = -1.0;
    public static double  DrivetrainDriveMaximumOutput        = 1.0;

    public static double  DRIVETRAIN_DRIVE_TOLERANCE          = 0.0;

    // ***************************************************************************************
    // Ultrasonic constants

    public static double  ULTRASONIC_X1                       = 0.086669;
    public static double  ULTRASONIC_Y1                       = 10.0;

    public static double  ULTRASONIC_X2                       = 0.467592;
    public static double  ULTRASONIC_Y2                       = 50.0;

    public static double  ULTRASONIC_A                        = 108.23;
    public static double  ULTRASONIC_B                        = -1.364;

    public static double  ULTRASONIC_DRIVE_DISTANCE_RANGE     = 10.0;

    // ***************************************************************************************
    // Chassis turn constants

    public static double  ChassisTurnThreshold                = 2.0;

    public static double  TurnAngle_P                         = 0.015;
    public static double  TurnAngle_I                         = 0.002;
    public static double  TurnAngle_D                         = 0.002;

    public static double  TurnAngle_MinimumOutput             = -0.4;
    public static double  TurnAngle_MaximumOutput             = 0.4;

    // ***************************************************************************************
    // Intake angle constants

    public static double  IntakeAngleEncoderYIntercept        = 245000;

    public static double  IntakeMinimumAngle                  = -90;
    public static double  IntakeMaximumAngle                  = 30;
    public static double  IntakeShootAngle                    = 20;

    public static double  IntakeAngleHomePosition             = -80;

    // public static double IntakeAnglePIDParamF = 0.0;
    // public static double IntakeAnglePIDParamP = 0.01; // 0.2
    // public static double IntakeAnglePIDParamI = 0.00001; // 0.0
    // public static double IntakeAnglePIDParamD = 0.0;

    public static int     IntakeAngleCruiseVelocity           = 18800;
    public static int     IntakeAngleAcceleration             = 18800 * 2;

    public static double  IntakeAnglePIDParamF                = 0.0;
    public static double  IntakeAnglePIDParamP                = 0.01;     // 0.2
    public static double  IntakeAnglePIDParamI                = 0.00001;  // 0.0
    public static double  IntakeAnglePIDParamD                = 0.0;

    public static double  IntakeAnglePIDMaximum               = 0.75;     // 0.2
    public static double  IntakeAnglePIDMinimum               = -0.75;    // -0.2

    // ***************************************************************************************
    // Intake wheel constants

    public static double  IntakeMaximumRPM                    = 500;

    public static double  IntakeWheelHoldVoltage              = 0.1;

    public static double  IntakeWheelPIDParamF                = 0.075;
    public static double  IntakeWheelPIDParamP                = 0.075;    // 0.02;
    public static double  IntakeWheelPIDParamI                = 0.0005;   // 0.0002;
    public static double  IntakeWheelPIDParamD                = 0.0;

    public static double  IntakeWheelPIDMaximum               = 1.0;
    public static double  IntakeWheelPIDMinimum               = -1.0;

    // ***************************************************************************************
    // Elevator Constants

    public static boolean ElevatorUsePosition                 = true;

    public static double  ElevatorRPM                         = 200;

    public static int     ElevatorCruiseVelocity              = 1000 * 2;
    public static int     ElevatorAcceleration                = 1000 * 2;

    public static double  ElevatorStartPosition               = 0;
    public static double  ElevatorChutePosition               = 0;
    public static double  ElevatorSwitchPosition              = -10000;
    public static double  ElevatorScalePosition               = -63000;

    public static double  ElevatorPIDParamF                   = 0.4;
    public static double  ElevatorPIDParamP                   = 0.04;
    public static double  ElevatorPIDParamI                   = 0.0002;
    public static double  ElevatorPIDParamD                   = 0.0;

    public static double  ElevatorPIDMaximum                  = 1.0;
    public static double  ElevatorPIDMinimum                  = -1.0;

    // ***************************************************************************************
    // Autonomous constants: cross autoline

    public static double  AutoLineDriveDistance               = 10.0;
    public static double  AutoLineDrivePower                  = 0.5;

    // Autonomous constants: place center switch

    public static double  AutoCenterSwitchFromWall            = 1.0;
    public static double  AutoCenterSwitchDiagonal            = 6.0;
    public static double  AutoCenterSwitchToSwitch            = 1.0;

    // Autonomous constants: switch or scale

    public static double  AutoSwitchOrScaleDriveSwitch        = 11.0;
    public static double  AutoSwitchOrScaleDriveScale         = 24.0;
    public static double  AutoSwitchOrScaleDriveOppositeScale = 18.0;
    public static double  AutoSwitchOrScaleDriveAcrossField   = 18.0;
    public static double  AutoSwitchOrScaleDriveScaleShort    = 2.0;

}
