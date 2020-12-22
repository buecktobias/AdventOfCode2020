package aoc.tasks.task17;

import aoc.helper.Vector3D;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cube {
    public Vector3D position;
    public State state;

    public Cube(Vector3D position, State state) {
        this.position = position;
        this.state = state;
    }

    public Grid3D nextCycle(Grid3D oldGrid3D, Grid3D newGrid){
        List<State> stateList = oldGrid3D.getNeighbourStates(this.position);
        int activeStates = (int) stateList.stream().filter(state1 -> state1 == State.ACTIVE).count();
        int inActiveStates = (int) stateList.stream().filter(state1 -> state1 == State.INACTIVE).count();

        if(this.state == State.INACTIVE){
            if (activeStates == 3){
                newGrid.addCube(new Cube(position, State.ACTIVE));
            }else{
                newGrid.addCube(new Cube(this.position, State.INACTIVE));
            }
        }else{
            if(activeStates == 3 || activeStates == 2){
                newGrid.addCube(new Cube(this.position, State.ACTIVE));
            }else{
                newGrid.addCube(new Cube(this.position, State.INACTIVE));
            }
        }
        return newGrid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
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
