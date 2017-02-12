package org.discobots.steamworks.commands.auton.subcommands;

import org.discobots.steamworks.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class AutonomousTankDrive extends Command {

	private int time; //ms
	private long endTime;
	private double speedLeft, speedRight;
	
	
    public AutonomousTankDrive(double left, double right, int t) //Speed Left; Speed Right; time in ms
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainSub);
    	speedLeft = left;
    	speedRight = right;
    	time = t; //in ms
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainSub.tankDrive(speedLeft, speedRight);
    	endTime = System.currentTimeMillis()+time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return endTime <= System.currentTimeMillis();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrainSub.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
