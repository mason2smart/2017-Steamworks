package org.discobots.steamworks.subsystems;

import org.discobots.steamworks.HW;
import org.discobots.steamworks.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearIntakeSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private DoubleSolenoid gearSolenoid;
	private int gearState=-1;
	private boolean gearOut=false;

	public GearIntakeSubsystem(){
		this.gearSolenoid = new DoubleSolenoid(HW.gearSolenoid1, HW.gearSolenoid2);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setGearState(int gearState)
	{
		this.gearState=gearState;
		if(gearState==-1){
			gearOut=false;
			SmartDashboard.putNumber("The Gear Intake is in: ", -1);
		gearSolenoid.set(DoubleSolenoid.Value.kReverse);}
		if(gearState==0)
		gearSolenoid.set(DoubleSolenoid.Value.kOff);
		if(gearState==1){
			gearOut=true;
			SmartDashboard.putNumber("The Gear Intake is in: ", 1);
		gearSolenoid.set(DoubleSolenoid.Value.kForward);}
	}
	public int getGearState(){
		return gearState;
	}

	public boolean isGearOut() {
		return gearOut;
	}}

