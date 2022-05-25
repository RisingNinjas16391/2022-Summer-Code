package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySegment;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

import org.firstinspires.ftc.teamcode.drive.Hardware;
import org.firstinspires.ftc.teamcode.drive.opmode.Auto;
import org.firstinspires.ftc.teamcode.trajectorysequence.sequencesegment.SequenceSegment;

import java.util.ArrayList;
import java.util.List;


public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(getMeepSequence());

        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }

    public static TrajectorySequence getMeepSequence() {
        org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence sequence = Auto.getSequence(new Hardware());
        List<TrajectorySegment> segmentList = new ArrayList<>();

        for (Trajectory trajectory : sequence.getTrajectoryList()) {
            TrajectorySegment segment = new TrajectorySegment(trajectory);
            segmentList.add(segment);
        }
        return new TrajectorySequence(segmentList);
    }
}