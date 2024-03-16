package ca.mcmaster.se2aa4.island.team222;

import ca.mcmaster.se2aa4.island.team222.Actions.*;
import ca.mcmaster.se2aa4.island.team222.Directions.*;

public class Drone {

    private int battery;
    private CardinalDirection direction;

    public Drone(int battery, CardinalDirection direction) {
        this.battery = battery;
        this.direction = direction;
    }

    public int getBattery() {
        return this.battery;
    } 

    public void useBattery(int cost) {
        this.battery -= cost;
    }

    public CardinalDirection getDirection() {
        return this.direction;
    }

    public Action fly() {
        return new Action(ActionType.FLY);
    }

    public Action echo(RelativeDirection direction) {
        CardinalDirection echoDirection;
        switch(direction) {
            case LEFT:
                echoDirection = this.direction.nextLeft();
                break;
            case RIGHT:
                echoDirection = this.direction.nextRight();
                break;
            case FORWARD:
                echoDirection = this.direction;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

        //TODO: Update the drone's positon here

        return new Action(ActionType.ECHO, echoDirection);
    }

    public Action heading(RelativeDirection direction) {
        CardinalDirection headingDirection;
        switch(direction) {
            case LEFT:
                headingDirection = this.direction.nextLeft();
                break;
            case RIGHT:
                headingDirection = this.direction.nextRight();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

        this.direction = headingDirection;

        //TODO: Update the drone's position here

        return new Action(ActionType.HEADING, headingDirection);
    }

    public Action scan() {
        return new Action(ActionType.SCAN);
    }

    public Action stop() {
        return new Action(ActionType.STOP);
    }
}
