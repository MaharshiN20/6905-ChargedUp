package frc.robot.Subsytems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivesubsystem extends SubsystemBase{
    private final CANSparkMax leftMain = new CANSparkMax(DriveConstants., MotorType.kBrushless);
    private final CANSparkMax leftFollower = new CANSparkMax(DriveConstants.leftMotor2, MotorType.kBrushless);
    private final CANSparkMax rightMain = new CANSparkMax(DriveConstants.rightMotor1, MotorType.kBrushless);
    private final CANSparkMax rightFollower = new CANSparkMax(DriveConstants.rightMotor2, MotorType.kBrushless);
    private DifferentialDrive drive;
    public Drivesubsystem(){
        leftMain.restoreFactoryDefaults();
        leftFollower.restoreFactoryDefaults();
        rightMain.restoreFactoryDefaults();
        rightFollower.restoreFactoryDefaults();

        leftMain.setIdleMode(IdleMode.kBrake);
        leftFollower.setIdleMode(IdleMode.kBrake);
        rightMain.setIdleMode(IdleMode.kBrake);
        rightFollower.setIdleMode(IdleMode.kBrake);

        rightMain.setInverted(true);
        
        rightFollower.follow(rightMain);
        leftFollower.follow(leftMain);
        
        
    }
    public void arcadeDriver(double forwardSpeed, double rotationSpeed) {
        drive.arcadeDrive(forwardSpeed, rotationSpeed);
        
    }
}
