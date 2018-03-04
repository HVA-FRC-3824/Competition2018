package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    // ***************************************************************************************
    // TalonSRX set timeout (ms)
    // ***************************************************************************************

    public static int     TalonInitialCommunicationTimeout            = 10;

    // ***************************************************************************************
    // Intake angle constants
    // ***************************************************************************************

    public static double  IntakeAngleMinimumAngle                     = -90;
    public static double  IntakeAngleHomeAngle                        = -80;
    public static double  IntakeAnglePickupAngle                      = -10;
    public static double  IntakeAnglePlaceAngle                       =   0;
    public static double  IntakeAngleShootAngle                       =  20;
    public static double  IntakeAngleMaximumAngle                     =  30;

    public static double  IntakeAngleEncoderYIntercept                = -9000;
    
    public static int     IntakeAngleCruiseVelocity                   = 1000;
    public static int     IntakeAngleAcceleration                     = 2000;
    
    public static double  IntakeAnglePIDMaximum                       =  1.0;
    public static double  IntakeAnglePIDMinimum                       = -1.0;

    public static double  IntakeAnglePIDParamF                        =  2.0;
    public static double  IntakeAnglePIDParamP                        =  3.0;
    public static double  IntakeAnglePIDParamI                        =  0.0;
    public static double  IntakeAnglePIDParamD                        =  0.0;

    // ***************************************************************************************
    // Intake wheel constants
    // ***************************************************************************************

    public static double  IntakeMaximumRPM                            = 500;

    public static double  IntakeSwitchRPM                             = 200;

    public static double  IntakeWheelInRPM                            = 300;
    public static double  IntakeWheelInTime                           = 3;

    public static double  IntakeWheelHoldVoltage                      = 0.1;

    public static double  IntakeWheelShootTime                        = 1.0;

    public static double  IntakeWheelPIDMaximum                       =  0.75;
    public static double  IntakeWheelPIDMinimum                       = -0.75;

    public static double  IntakeWheelPIDParamF                        = 0.1;
    public static double  IntakeWheelPIDParamP                        = 0.2;
    public static double  IntakeWheelPIDParamI                        = 0.001;
    public static double  IntakeWheelPIDParamD                        = 0.0;

    // ***************************************************************************************
    // Elevator Constants
    // ***************************************************************************************

    public static boolean ElevatorUsePosition                         = true;

    public static double  ElevatorRPM                                 = 200;

    public static double  ElevatorScalePositionTheirs                 = 64000;
    public static double  ElevatorScalePositionNeutral                = 66000;
    public static double  ElevatorScalePositionOurs                   = 54500;
    public static double  ElevatorSwitchPosition                      = 11000;
    public static double  ElevatorDownPosition                        =     0;
    public static double  ElevatorChutePosition                       = -20000;
    public static double  ElevatorCubeInPosition                      = -20000;

    public static double  ElevatorStep                                = 2000;

    public static int     ElevatorCruiseVelocity                      = 2000;
    public static int     ElevatorAcceleration                        = 2000;
    
    public static double  ElevatorPIDMaximum                          =  1.0;
    public static double  ElevatorPIDMinimum                          = -1.0;

    public static double  ElevatorPIDParamF                           = 0.4;
    public static double  ElevatorPIDParamP                           = 0.4;
    public static double  ElevatorPIDParamI                           = 0.0;
    public static double  ElevatorPIDParamD                           = 0.0;

    // ***************************************************************************************
    // Chassis turn constants
    // ***************************************************************************************

    public static double  ChassisTurnThreshold                        = 5.0;
    public static double  ChassisTurnTimeOutTimeDefault               = 3.0;
    public static double  ChassisTurnTimeOutTime                      = 1.0;

    public static double  TurnAngle_MinimumOutput                     = -0.4;
    public static double  TurnAngle_MaximumOutput                     =  0.4;

    public static double  TurnAngle_F                                 = 0.0;
    public static double  TurnAngle_P                                 = 0.06;
    public static double  TurnAngle_I                                 = 0.0;
    public static double  TurnAngle_D                                 = 0.15;

    // ***************************************************************************************
    // Chassis drive straight constants
    // ***************************************************************************************

    public static double  DrivetrainDriveMinimumOutput                = -1.0;
    public static double  DrivetrainDriveMaximumOutput                =  1.0;

    public static double  DrivetrainDriveStraight_F                   = 0.0;
    public static double  DrivetrainDriveStraight_P                   = 0.05;
    public static double  DrivetrainDriveStraight_I                   = 0.00005;
    public static double  DrivetrainDriveStraight_D                   = 0.0;

    // ***************************************************************************************
    // Ultrasonic constants
    // ***************************************************************************************

    public static double  Ultrasonic_A                                = 108.23;
    public static double  Ultrasonic_B                                = -1.364;

    public static double  UltrasonicDriveDistanceRange                = 18.0;
    public static double  UltrasonicDriveDistancePower                = 0.2;

    // ***************************************************************************************
    // Autonomous constants: cross autoline
    // ***************************************************************************************

    public static double  AutoLineDriveDistance                       = 10.0;
    public static double  AutoLineDrivePower                          = 0.5;

    // ***************************************************************************************
    // Autonomous constants: place center switch
    // ***************************************************************************************

    public static double  AutoCenterSwitchFromWallDistance            = 1.0;     // Feet
    public static double  AutoCenterSwitchFromWallPower               = 0.8;

    public static double  AutoCenterSwitchFromWallAngle               = 45.0;    // Degrees (assumed right switch)

    public static double  AutoCenterSwitchDiagonalDistance            = 5.0;     // Feet
    public static double  AutoCenterSwitchAdditionalDistance          = 2.5;     // Feet
    public static double  AutoCenterSwitchDiagonalPower               = 0.8;

    public static double  AutoCenterSwitchToSwitchDistance            = 7.0;     // Inches
    public static double  AutoCenterSwitchToSwitchRangePower          = 0.3;
    public static double  AutoCenterSwitchToSwitchPower               = 0.6;

    public static double  AutoCenterSwitchBackUpDistance              = 2.0;     // Feet
    public static double  AutoCenterSwitchBackUpPower                 = -0.6;    // Backing up
    
    // ***************************************************************************************
    // Autonomous constants: switch or scale
    // ***************************************************************************************

    public static double  AutoSwitchOrScaleDriveSwitchDistance        = 12.0;    // Feet
    public static double  AutoSwitchOrScaleDriveSwitchPower           = 0.8;

    public static double  AutoSwitchOrScaleDriveScaleDistance         = 24.0;    // Feet
    public static double  AutoSwitchOrScaleDriveScalePower            = 0.8;

    public static double  AutoSwitchOrScaleDriveOppositeScaleDistance = 17.5;   //18.0    // Feet
    public static double  AutoSwitchOrScaleDriveOppositeScalePower    = 0.8;

    public static double  AutoSwitchOrScaleDriveAcrossFieldDistance   = 17.0;    // Feet
    public static double  AutoSwitchOrScaleDriveAcrossFieldPower      = 0.8;

    public static double  AutoSwitchOrScaleDriveScaleShortDistance    = 5.0;     // Feet
    public static double  AutoSwitchOrScaleDriveScaleShortPower       = 0.4;

    public static double  AutoSwitchOrScaleToSwitchDistance           = 6.0;     // Inches
    public static double  AutoSwitchOrScaleToSwitchPower              = 0.6;

    public static double  AutoSwitchOrScaleBackUpDistance             = 2.0;     // Feet
    public static double  AutoSwitchOrScaleBackUpPower                = -0.6;    // Backing up

    public static double  AutoSwitchOrScaleToNextCube1Distance        = 8.0;     // Feet
    public static double  AutoSwitchOrScaleToNextCube1Power           = -0.6;

    public static double  AutoSwitchOrScaleToNextCube2Distance        = 2.0;     // Feet
    public static double  AutoSwitchOrScaleToNextCube2Power           = 0.4;

    public static double  AutoSwitchOrScaleToCubeDistance             = 5.0;     // Inches
    public static double  AutoSwitchOrScaleToCubePower                = 0.6;

    public static double  AutoSwitchOrScaleRamSwitchDistance          = 5.0;     // Feet
    public static double  AutoSwitchOrScaleRamSwitchPower             = 0.3;
    public static double  AutoSwitchOrScaleRamSwitchTimeout           = 1.0;     // Seconds

    public static double  AutoSwitchOrScaleBackupWithCubeDistance     = 4.0;
    public static double  AutoSwitchOrScaleBackupWithCubePower        = -0.4;

    public static double  AutoSwitchOrScaleToScaleWithCubeDistance    = 8.0;
    public static double  AutoSwitchOrScaleToScaleWithCubePower       = 0.6;

    // ***************************************************************************************
    // Intake: rotate and center the cube
    // ***************************************************************************************

    public static double  IntakeWheelRotateTime1                      = 0.5;     // Rotate the left wheel out

    public static double  IntakeWheelRotateRightRPM1                  = 200;
    public static double  IntakeWheelRotateLeftRPM1                   = 200;

    public static double  IntakeWheelRotateTime2                      = 1.5;     // Rotate the right wheel in

    public static double  IntakeWheelRotateRightRPM2                  = 400;
    public static double  IntakeWheelRotateLeftRPM2                   = 200;

    public static double  IntakeWheelRotateTime3                      = 2.0;     // Rotate both wheels in

    public static double  IntakeWheelRotateRightRPM3                  = 0;
    public static double  IntakeWheelRotateLeftRPM3                   = 0;

    public static double  IntakeWheelRotateTimeStop                   = 2.5;     // Rotate both wheels in
}
