package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    private final int actionLimit;
    static int[] carouselArray;
    private int carouselRunCounter;
    private boolean isCarouselRunning;


    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
        carouselArray = new int[capacity];
    }

    @Override
    public boolean addElement(int element){
        if (counter < capacity && element > 0 && !isCarouselRunning) {
            carouselArray[counter] = element;
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public CarouselRun run(){
        if (carouselRunCounter == 0) {
            isCarouselRunning = true;
            carouselRunCounter++;
            return new LimitedCarouselRun(actionLimit);
        }
        return null;
    }
}
