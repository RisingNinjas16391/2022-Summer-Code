package org.firstinspires.ftc.teamcode.trajectorysequence;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.trajectorysequence.sequencesegment.SequenceSegment;

import java.util.Collections;
import java.util.List;

public class TrajectorySequence {
    private final List<SequenceSegment> sequenceList;
    private final List<Trajectory> trajectoryList;

    public TrajectorySequence(List<SequenceSegment> sequenceList, List<Trajectory> trajectoryList) {
        if (sequenceList.size() == 0) throw new EmptySequenceException();

        this.sequenceList = Collections.unmodifiableList(sequenceList);
        this.trajectoryList = Collections.unmodifiableList(trajectoryList);
    }

    public Pose2d start() {
        return sequenceList.get(0).getStartPose();
    }

    public Pose2d end() {
        return sequenceList.get(sequenceList.size() - 1).getEndPose();
    }

    public double duration() {
        double total = 0.0;

        for (SequenceSegment segment : sequenceList) {
            total += segment.getDuration();
        }

        return total;
    }

    public SequenceSegment get(int i) {
        return sequenceList.get(i);
    }

    public int size() {
        return sequenceList.size();
    }

    public List<Trajectory> getTrajectoryList() {
        return trajectoryList;
    }
}
