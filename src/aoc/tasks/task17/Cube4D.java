package aoc.tasks.task17;

import aoc.helper.Vector3D;
import aoc.helper.Vector4D;

import java.util.List;
import java.util.Objects;

public class Cube4D {
    public Vector4D position;
    public State state;

    public Cube4D(Vector4D position, State state) {
        this.position = position;
        this.state = state;
    }

    public Grid4D nextCycle(Grid4D oldGrid3D, Grid4D newGrid){
        List<State> stateList = oldGrid3D.getNeighbourStates(this.position);
        int activeStates = (int) stateList.stream().filter(state1 -> state1 == State.ACTIVE).count();
        int inActiveStates = (int) stateList.stream().filter(state1 -> state1 == State.INACTIVE).count();

        if(this.state == State.INACTIVE){
            if (activeStates == 3){
                newGrid.addCube(new Cube4D(position, State.ACTIVE));
            }else{
                newGrid.addCube(new Cube4D(this.position, State.INACTIVE));
            }
        }else{
            if(activeStates == 3 || activeStates == 2){
                newGrid.addCube(new Cube4D(this.position, State.ACTIVE));
            }else{
                newGrid.addCube(new Cube4D(this.position, State.INACTIVE));
            }
        }
        return newGrid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube4D cube = (Cube4D) o;
        return Objects.equals(position, cube.position) && state == cube.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, state);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "position=" + position +
                ", state=" + state +
                '}';
    }
}
