package ary.assemblagepiston.demo.domain.abstracts;

import ary.assemblagepiston.demo.domain.RandomUtils;

public abstract class MachineAbstract {
    protected Double durationProcess;

    protected MachineAbstract(Double durationProcess) {
        this.durationProcess = durationProcess + getDurationExtraTimeIfMachineIsDown();
    }

    private static Double getDurationExtraTimeIfMachineIsDown() {
        return RandomUtils.getExtraTimeDurationTrouble(RandomUtils.isMachineDown());
    }
}
