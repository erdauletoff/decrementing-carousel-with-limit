package com.epam.rd.autotasks;

public class LimitedCarouselRun extends CarouselRun {
    private final int actionLimit;
    private int actionCounter = 0;
    private final int[] decrementingArray;

    public LimitedCarouselRun(final int actionLimit) {
        this.actionLimit = actionLimit;
        decrementingArray = DecrementingCarouselWithLimitedRun.carouselArray;
    }

    @Override
    public int next() {
        if (actionCounter < actionLimit) {
            int count = 0;
            while (count < decrementingArray.length && decrementingArray[position %= decrementingArray.length] <= 0) {
                position++;
                count++;
            }
            if (count == decrementingArray.length) return -1;
            actionCounter++;
            return decrementingArray[position++]--;
        }
        return -1;
    }

    @Override
    public boolean isFinished() {
        return super.isFinished() || actionCounter == actionLimit;
    }
}
