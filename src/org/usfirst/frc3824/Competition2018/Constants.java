package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    // ***************************************************************************************
    // TalonSRX set timeout (ms)
    // ***************************************************************************************

    public static int     TalonInitialCommunicationTimeout    = 10;

    // ***************************************************************************************
    // Chassis turn constants
    // ***************************************************************************************

    public static double  ChassisTurnThreshold                = 2.0;
    public static double  ChassisTurnTimeOutTime              = 1.0;
    
    public static double  TurnAngle_P                         = 0.04; //0.01
    public static double  TurnAngle_I                         = 0.000; //0.002
    public static double  TurnAngle_D                         = 0.1; //0.002

    public static double  TurnAngle_MinimumOutput             = -0.4;
    public static double  TurnAngle_MaximumOutput             = 0.4;

    // ***************************************************************************************
    // Chassis drive straight constants
    // ***************************************************************************************

    public static double  DrivetrainDriveStraight_P           = 0.05;
    public static double  DrivetrainDriveStraight_I           = 0.00005;
    public static double  DrivetrainDriveStraight_D           = 0.0;

    public static double  DrivetrainDriveMinimumOutput        = -1.0;
    public static double  DrivetrainDriveMaximumOutput        = 1.0;

    // ***************************************************************************************
    // Ultrasonic constants
    // ***************************************************************************************

    public static double  Ultrasonic_A                        = 108.23;
    public static double  Ultrasonic_B                        = -1.364;

    public static double  UltrasonicDriveDistanceRange        = 18.0;
    public static double  UltrasonicDriveDistancePower        = 0.2;

    // ***************************************************************************************
    // Intake angle constants
    // ***************************************************************************************

    public static double  IntakeAngleEncoderYIntercept        = 245000;

    public static double  IntakeMinimumAngle                  = -90;
    public static double  IntakeMaximumAngle                  = 30;
    public static double  IntakePlaceAngle                    = 0;
    public static double  IntakeShootAngle                    = 20;

    public static double  IntakeAngleHomePosition             = -80;

    public static int     IntakeAngleCruiseVelocity           = 18800;
    public static int     IntakeAngleAcceleration             = 18800 * 2;

    public static double  IntakeAnglePIDParamF                = 0.0;
    public static double  IntakeAnglePIDParamP                = 0.01;
    public static double  IntakeAnglePIDParamI                = 0.00001;
    public static double  IntakeAnglePIDParamD                = 0.0;

    public static double  IntakeAnglePIDMaximum               = 0.75;
    public static double  IntakeAnglePIDMinimum               = -0.75;

    // ***************************************************************************************
    // Intake wheel constants
    // ***************************************************************************************

    public static double  IntakeMaximumRPM                    = 500;
    
    public static double  IntakeSwitchRPM                     = 200;
    
    public static double  IntakeWheelInRPM                    = 300;

    public static double  IntakeWheelHoldVoltage              = 0.1;
    
    public static double  IntakeWheelShootTime                = 1.0;

    public static double  IntakeWheelPIDParamF                = 0.075;
    public static double  IntakeWheelPIDParamP                = 0.075;
    public static double  IntakeWheelPIDParamI                = 0.0005;
    public static double  IntakeWheelPIDParamD                = 0.0;

    public static double  IntakeWheelPIDMaximum               = 1.0;
    public static double  IntakeWheelPIDMinimum               = -1.0;

    // ***************************************************************************************
    // Elevator Constants
    // ***************************************************************************************

    public static boolean ElevatorUsePosition                 = true;

    public static double  ElevatorRPM                         = 200;

    public static int     ElevatorCruiseVelocity              = 1000 * 2;
    public static int     ElevatorAcceleration                = 1000 * 2;

    public static double  ElevatorBottomPosition              = 21000;
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
    // ***************************************************************************************

    public static double  AutoLineDriveDistance               = 10.0;
    public static double  AutoLineDrivePower                  = 0.5;

    // ***************************************************************************************
    // Autonomous constants: place center switch
    // ***************************************************************************************

    public static double  AutoCenterSwitchFromWallDistance    = 1.0;   // Feet
    public static double  AutoCenterSwitchFromWallPower       = 0.6;
        
    public static double  AutoCenterSwitchFromWallAngle       = 45.0;  // Degrees (assumed right switch)
    
    public static double  AutoCenterSwitchDiagonalDistance    = 6.0;   // Feet
    public static double  AutoCenterSwitchAdditionalDistance  = 3.0;   // Feet
    public static double  AutoCenterSwitchDiagonalPower       = 0.6;
    
    public static double  AutoCenterSwitchToSwitchDistance    = 10.0;  // Inches
    public static double  AutoCenterSwitchToSwitchPower       = 0.4;
    
    public static double  AutoCenterSwitchBackUpDistance      = 2.0;   // Feet
    public static double  AutoCenterSwitchBackUpPower         = -0.6;  // Backing up

    // ***************************************************************************************
    // Autonomous constants: switch or scale
    // ***************************************************************************************

    public static double  AutoSwitchOrScaleDriveSwitchDistance        = 12.0;  // Feet
    public static double  AutoSwitchOrScaleDriveSwitchPower           = 0.8;
            
    public static double  AutoSwitchOrScaleDriveScaleDistance         = 24.0;  // Feet
    public static double  AutoSwitchOrScaleDriveScalePower            = 0.8;
    
    public static double  AutoSwitchOrScaleDriveOppositeScaleDistance = 18.0;  // Feet
    public static double  AutoSwitchOrScaleDriveOppositeScalePower    = 0.8;
    
    public static double  AutoSwitchOrScaleDriveAcrossFieldDistance   = 17.0;  // Feet
    public static double  AutoSwitchOrScaleDriveAcrossFieldPower      = 0.8;
    
    public static double  AutoSwitchOrScaleDriveScaleShortDistance    = 5.0;   // Feet
    public static double  AutoSwitchOrScaleDriveScaleShortPower       = 0.4;
    
    public static double  AutoSwitchOrScaleToSwitchDistance           = 6.0;  // Inches
    public static double  AutoSwitchOrScaleToSwitchPower              = 0.6;
    
    public static double  AutoSwitchOrScaleBackUpDistance             = 2.0;   // Feet
    public static double  AutoSwitchOrScaleBackUpPower                = -0.6;  // Backing up
    
    public static double  AutoSwitchOrScaleToNextCube1Distance        = 8.0;   // Feet
    public static double  AutoSwitchOrScaleToNextCube1Power           = -0.6;
    
    public static double  AutoSwitchOrScaleToNextCube2Distance        = 2.0;   // Feet
    public static double  AutoSwitchOrScaleToNextCube2Power           = 0.4;
    
    public static double  AutoSwitchOrScaleToCubeDistance             = 5.0;   // Inches
    public static double  AutoSwitchOrScaleToCubePower                = 0.4;
    
    public static double  AutoSwitchOrScaleRamSwitchDistance          = 5.0;   // Feet
    public static double  AutoSwitchOrScaleRamSwitchPower             = 0.3;
    public static double  AutoSwitchOrScaleRamSwitchTimeout           = 1.0;   // Seconds
    
    public static double  AutoSwitchOrScaleBackupWithCubeDistance     = 4.0;
    public static double  AutoSwitchOrScaleBackupWithCubePower        = -0.4;
    
    public static double  AutoSwitchOrScaleToScaleWithCubeDistance    = 8.0;
    public static double  AutoSwitchOrScaleToScaleWithCubePower       = 0.6;
}
