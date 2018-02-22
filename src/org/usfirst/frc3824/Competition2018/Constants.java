package org.usfirst.frc3824.Competition2018;

public final class Constants
{
    static final boolean competitionRobot                     = true;

    // ***************************************************************************************
    // TalonSRX set timeout (ms)
    // ***************************************************************************************

    public static int     TalonInitialCommunicationTimeout    = 10;

    // ***************************************************************************************
    // Intake angle constants
    // John stop taking out my comments
    // You're just mad you're bald
    // I can't control that
    // Bryson, Jovi, and Seth rock
    // ***************************************************************************************

    public static double  IntakeMinimumAngle;
    public static double  IntakeMaximumAngle;
    public static double  IntakePlaceAngle;
    public static double  IntakeShootAngle;

    public static double  IntakeAngleHomePosition;

    public static double  IntakeAnglePIDMaximum;
    public static double  IntakeAnglePIDMinimum;
    
    public static double IntakeAngleEncoderYIntercept;
    public static double IntakeAnglePIDParamF;
    public static double IntakeAnglePIDParamP;
    public static double IntakeAnglePIDParamI;
    public static double IntakeAnglePIDParamD;

    public static int    IntakeAngleCruiseVelocity;
    public static int    IntakeAngleAcceleration;

    // ***************************************************************************************
    // Elevator Constants
    // ***************************************************************************************

    public static boolean ElevatorUsePosition;

    public static double  ElevatorRPM;

    public static int     ElevatorCruiseVelocity;
    public static int     ElevatorAcceleration;

    public static double  ElevatorScalePosition;
    public static double  ElevatorSwitchPosition;
    public static double  ElevatorStartPosition;
    public static double  ElevatorChutePosition;
    public static double  ElevatorCubeInPosition;

    public static double  ElevatorPIDParamF;
    public static double  ElevatorPIDParamP;
    public static double  ElevatorPIDParamI;
    public static double  ElevatorPIDParamD;

    public static double  ElevatorPIDMaximum;
    public static double  ElevatorPIDMinimum;

    public static double  ElevatorStep;
    
    public static void InitConstants()
    {
        if (competitionRobot)
        {
            // ***************************************************************************************
            // Intake angle constants
            // ***************************************************************************************

            IntakeMinimumAngle           = -90;
            IntakeMaximumAngle           = 30;
            IntakePlaceAngle             = 0;
            IntakeShootAngle             = 20;

            IntakeAngleHomePosition      = -80;

            IntakeAnglePIDMaximum        = 0.75;
            IntakeAnglePIDMinimum        = -0.75;
            
            IntakeAngleEncoderYIntercept = -2100;
            IntakeAnglePIDParamF         = 0.0;
            IntakeAnglePIDParamP         = 1.167;     // 0.01    * 1.167;
            IntakeAnglePIDParamI         = 0.001167;  // 0.00001 * 116.7;
            IntakeAnglePIDParamD         = 0.0;

            IntakeAngleCruiseVelocity    = 161;       // (int) (18800.0       / 116.7);
            IntakeAngleAcceleration      = 322;       // (int) (18800.0 * 2.0 / 116.7);
            
            // ***************************************************************************************
            // Elevator Constants
            // ***************************************************************************************

            ElevatorUsePosition          = true;

            ElevatorRPM                  = 200;

            ElevatorCruiseVelocity       = 2000;
            ElevatorAcceleration         = 2000;

            ElevatorScalePosition        = -51000;
            ElevatorSwitchPosition       = -10000;
            ElevatorStartPosition        = 0;
            ElevatorChutePosition        = 24300;
            ElevatorCubeInPosition       = 24300;

            ElevatorPIDParamF            = 0.4;
            ElevatorPIDParamP            = 0.04;
            ElevatorPIDParamI            = 0.00007; // 0.0002;
            ElevatorPIDParamD            = 0.0;

            ElevatorPIDMaximum           = 1.0;
            ElevatorPIDMinimum           = -1.0;

            ElevatorStep                 = 2000;
        }
        else
        {
            // ***************************************************************************************
            // Intake angle constants
            // ***************************************************************************************

            IntakeMinimumAngle           = -90;
            IntakeMaximumAngle           = 30;
            IntakePlaceAngle             = 0;
            IntakeShootAngle             = 20;

            IntakeAngleHomePosition      = -80;

            IntakeAnglePIDMaximum        = 0.75;
            IntakeAnglePIDMinimum        = -0.75;
            
            IntakeAngleEncoderYIntercept = 245000;
            IntakeAnglePIDParamF         = 0.0;
            IntakeAnglePIDParamP         = 0.01;
            IntakeAnglePIDParamI         = 0.00001;
            IntakeAnglePIDParamD         = 0.0;

            IntakeAngleCruiseVelocity    = 18800;
            IntakeAngleAcceleration      = 37600;
            
            // ***************************************************************************************
            // Elevator Constants
            // ***************************************************************************************

            ElevatorUsePosition          = true;

            ElevatorRPM                  = 200;

            ElevatorCruiseVelocity       = 2000;
            ElevatorAcceleration         = 2000;

            ElevatorScalePosition        = -63000;
            ElevatorSwitchPosition       = -10000;
            ElevatorStartPosition        = 0;
            ElevatorChutePosition        = 0;
            ElevatorCubeInPosition       = 0;
            
            ElevatorPIDParamF            = 0.4;
            ElevatorPIDParamP            = 0.04;
            ElevatorPIDParamI            = 0.0002;
            ElevatorPIDParamD            = 0.0;

            ElevatorPIDMaximum           = 1.0;
            ElevatorPIDMinimum           = -1.0;

            ElevatorStep                 = 1000;
        }
    }

    // ***************************************************************************************
    // Chassis turn constants
    // ***************************************************************************************

    public static double  ChassisTurnThreshold                        = 2.0;
    public static double  ChassisTurnTimeOutTime                      = 1.0;

    public static double  TurnAngle_P                                 = 0.06;   // 0.4  // 0.01
    public static double  TurnAngle_I                                 = 0.000;  // 0.0  // 0.002
    public static double  TurnAngle_D                                 = 0.15;   // 0.1  // 0.002

    public static double  TurnAngle_MinimumOutput                     = -0.4;
    public static double  TurnAngle_MaximumOutput                     = 0.4;

    // ***************************************************************************************
    // Chassis drive straight constants
    // ***************************************************************************************

    public static double  DrivetrainDriveStraight_P                   = 0.05;
    public static double  DrivetrainDriveStraight_I                   = 0.00005;
    public static double  DrivetrainDriveStraight_D                   = 0.0;

    public static double  DrivetrainDriveMinimumOutput                = -1.0;
    public static double  DrivetrainDriveMaximumOutput                = 1.0;

    // ***************************************************************************************
    // Ultrasonic constants
    // ***************************************************************************************

    public static double  Ultrasonic_A                                = 108.23;
    public static double  Ultrasonic_B                                = -1.364;

    public static double  UltrasonicDriveDistanceRange                = 18.0;
    public static double  UltrasonicDriveDistancePower                = 0.2;

    // ***************************************************************************************
    // Intake wheel constants
    // ***************************************************************************************

    public static double  IntakeMaximumRPM                            = 500;

    public static double  IntakeSwitchRPM                             = 200;

    public static double  IntakeWheelInRPM                            = 300;

    public static double  IntakeWheelHoldVoltage                      = 0.1;

    public static double  IntakeWheelShootTime                        = 1.0;

    public static double  IntakeWheelPIDParamF                        = 0.0;
    public static double  IntakeWheelPIDParamP                        = 0.5;
    public static double  IntakeWheelPIDParamI                        = 0.001;
    public static double  IntakeWheelPIDParamD                        = 0.0;

    public static double  IntakeWheelPIDMaximum                       = 1.0;
    public static double  IntakeWheelPIDMinimum                       = -1.0;

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

    public static double  AutoCenterSwitchDiagonalDistance            = 6.0;     // Feet
    public static double  AutoCenterSwitchAdditionalDistance          = 2.0;     // Feet
    public static double  AutoCenterSwitchDiagonalPower               = 0.8;

    public static double  AutoCenterSwitchToSwitchDistance            = 7.0;     // Inches
    public static double  AutoCenterSwitchToSwitchRangePower          = 0.3;
    public static double  AutoCenterSwitchToSwitchPower               = 0.6;

    public static double  AutoCenterSwitchBackUpDistance              = 2.0;     // Feet
    public static double  AutoCenterSwitchBackUpPower                 = -0.6;    // Backing
                                                                                 // up
    // ***************************************************************************************
    // Autonomous constants: switch or scale
    // ***************************************************************************************

    public static double  AutoSwitchOrScaleDriveSwitchDistance        = 12.0;    // Feet
    public static double  AutoSwitchOrScaleDriveSwitchPower           = 0.8;

    public static double  AutoSwitchOrScaleDriveScaleDistance         = 24.0;    // Feet
    public static double  AutoSwitchOrScaleDriveScalePower            = 0.8;

    public static double  AutoSwitchOrScaleDriveOppositeScaleDistance = 18.0;    // Feet
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
    
    public static double  IntakeWheelRotateTime1                     = 0.5;  // Rotate the left wheel out
    public static double  IntakeWheelRotateRightRPM1                 = 200;
    public static double  IntakeWheelRotateLeftRPM1                  = 200;
    
    public static double  IntakeWheelRotateTime2                     = 1.5;  // Rotate the right wheel in
    public static double  IntakeWheelRotateRightRPM2                 = 400;
    public static double  IntakeWheelRotateLeftRPM2                  = 200;
    
    public static double  IntakeWheelRotateTime3                     = 2.0;  // Rotate both wheels in
    public static double  IntakeWheelRotateRightRPM3                 = 0;
    public static double  IntakeWheelRotateLeftRPM3                  = 0;
    
    
    public static double  IntakeWheelRotateTimeStop                  = 2.5;  // Rotate both wheels in
}
