// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.Competition2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogGyro chassisGyro;
    public static Encoder chassisLeftDriveEncoder;
    public static Encoder chassisRightDriveEncoder;
    public static SpeedController chassisSpeedR1;
    public static SpeedController chassisSpeedR2;
    public static SpeedControllerGroup chassisRightDrive;
    public static SpeedController chassisSpeedL1;
    public static SpeedController chassisSpeedL2;
    public static SpeedControllerGroup chassisLeftDrive;
    public static DifferentialDrive chassisDriveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
        chassisLeftDriveEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "LeftDriveEncoder", chassisLeftDriveEncoder);
        chassisLeftDriveEncoder.setDistancePerPulse(1.0);
        chassisLeftDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        chassisRightDriveEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "RightDriveEncoder", chassisRightDriveEncoder);
        chassisRightDriveEncoder.setDistancePerPulse(1.0);
        chassisRightDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        chassisSpeedR1 = new PWMVictorSPX(0);
        LiveWindow.addActuator("Chassis", "SpeedR1", (PWMVictorSPX) chassisSpeedR1);
        chassisSpeedR1.setInverted(false);
        chassisSpeedR2 = new PWMVictorSPX(1);
        LiveWindow.addActuator("Chassis", "SpeedR2", (PWMVictorSPX) chassisSpeedR2);
        chassisSpeedR2.setInverted(false);
        chassisRightDrive = new SpeedControllerGroup(chassisSpeedR1, chassisSpeedR2  );
        LiveWindow.addActuator("Chassis", "RightDrive", chassisRightDrive);
        
        chassisSpeedL1 = new PWMVictorSPX(2);
        LiveWindow.addActuator("Chassis", "SpeedL1", (PWMVictorSPX) chassisSpeedL1);
        chassisSpeedL1.setInverted(false);
        chassisSpeedL2 = new PWMVictorSPX(3);
        LiveWindow.addActuator("Chassis", "SpeedL2", (PWMVictorSPX) chassisSpeedL2);
        chassisSpeedL2.setInverted(false);
        chassisLeftDrive = new SpeedControllerGroup(chassisSpeedL1, chassisSpeedL2  );
        LiveWindow.addActuator("Chassis", "LeftDrive", chassisLeftDrive);
        
        chassisDriveTrain = new DifferentialDrive(chassisLeftDrive, chassisRightDrive);
        LiveWindow.addActuator("Chassis", "DriveTrain", chassisDriveTrain);
        chassisDriveTrain.setSafetyEnabled(true);
        chassisDriveTrain.setExpiration(0.1);
        chassisDriveTrain.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
//        drivetrainDrive.setName("drivetrain");
//        LiveWindow.add(drivetrainDrive);
//        
//        drivetrainRightDrive.setName("drivetrain", "RightDrive");
//        LiveWindow.addChild(drivetrainDrive,drivetrainRightDrive);
//        
//        ( (PWMVictorSPX) drivetrainSpeedR1).setName("RightDrive", "SpeedR1");
//        LiveWindow.addChild(drivetrainRightDrive, drivetrainSpeedR1);
//        
//        ( (PWMVictorSPX) drivetrainSpeedR2).setName("RightDrive", "SpeedR2");
//        LiveWindow.addChild(drivetrainRightDrive, drivetrainSpeedR2);
//        
//        drivetrainLeftDrive.setName("drivetrain", "LeftDrive");
//        LiveWindow.addChild(drivetrainDrive,drivetrainLeftDrive);
//        
//        ( (PWMVictorSPX) drivetrainSpeedL1).setName("LeftDrive", "SpeedL1");
//        LiveWindow.addChild(drivetrainLeftDrive, drivetrainSpeedL1);
//        
//        ( (PWMVictorSPX) drivetrainSpeedL2).setName("LeftDrive", "SpeedL2");
//        LiveWindow.addChild(drivetrainLeftDrive, drivetrainSpeedL2);
        
        
	}
}
