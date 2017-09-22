package org.usfirst.frc.team2175.loop;

import edu.wpi.first.wpilibj.command.Scheduler;

public class Scheduler_L extends Control_L {

    @Override
    protected long getPeriodMs() {
        return 10;
    }

    @Override
    protected void runTask() {
        Scheduler.getInstance().run();
    }

}
