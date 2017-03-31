package org.discobots.steamworks.commands.auton;

import org.discobots.steamworks.commands.auton.subcommands.AutonomousArcadeDrive;
import org.discobots.steamworks.commands.auton.subcommands.WaitCommand;
import org.discobots.steamworks.commands.shoot.ExtendHoodCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *From the center position, delivers the gear to the center post on the ship
 */
public class AutonCenterPostCommand extends CommandGroup {
    
    public  AutonCenterPostCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addParallel(new ExtendHoodCommand(700));
    	addSequential(new AutonomousArcadeDrive(0,0.7,1500));//straight
    	addSequential(new AutonomousArcadeDrive(0,0.5,1000));
    	addSequential(new WaitCommand(1500));
    	addSequential(new AutonomousArcadeDrive(-0.2,-0.5, 1000));//backup at angle
    	addSequential(new AutonomousArcadeDrive(-0.1, 0.55,1200));//forwards again
    	addSequential(new WaitCommand(1500));
    	addSequential(new AutonomousArcadeDrive(0.2,-0.5, 1000));//backup at angle
    	addSequential(new AutonomousArcadeDrive(0.1, 0.55,1200));//forwards again
    	 	
    	
    	
    }
}
