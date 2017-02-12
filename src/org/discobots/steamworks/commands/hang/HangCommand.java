package org.discobots.steamworks.commands.hang;

import org.discobots.steamworks.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HangCommand extends Command {
	private int time;
	private long endTime;
	private double speed;
	private boolean fin=false;
	public boolean end=false;
	boolean toggled=false;

    public HangCommand(double speed,int t) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.hangSub);
    	this.time=t;
    	this.speed=speed;
    }
    public HangCommand(double speed) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.hangSub);
    	this.speed=speed;
    	toggled=true;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	endTime = System.currentTimeMillis() + time;
    	Robot.hangSub.setSpeed(1.0);
    } 

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hangSub.setSpeed(speed);
    	if (endTime<=System.currentTimeMillis())
    	{
    		fin=true;
    	}
    	else
    		fin=toggled;
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hangSub.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}