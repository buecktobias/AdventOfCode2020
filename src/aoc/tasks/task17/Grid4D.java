package aoc.tasks.task17;

import aoc.helper.Vector3D;
import aoc.helper.Vector4D;

import java.util.*;

public class Grid4D {
    private Map<Vector4D, Cube4D> positions;

    public Grid4D(){
        int range = 20;
        this.positions = new HashMap<>();
        for(int x=-range; x < range; x++){
            for(int y= -range; y < range; y++){
                for(int z= -range; z < range; z++){
                    for(int w = -range; w < range; w++) {
                        this.addCube(new Cube4D(new Vector4D(x, y, z, w), State.INACTIVE));
                    }
                }
            }
        }
    }

    public Grid4D(Map<Vector4D, Cube4D> positions) {
        this.positions = positions;
    }

    public Grid4D nextCycle(){
        Grid4D oldGrid = this;
        Grid4D newGrid = new Grid4D();
        Collection<Cube4D> cubes = positions.values();
        for (Cube4D cube : cubes) {
            cube.nextCycle(oldGrid, newGrid);
        }
        return newGrid;
    }


    public void setCubeAtActive(Vector4D position){
        this.positions.get(position).state = State.ACTIVE;
    }

    public void addCube(Cube4D newCube){
        positions.put(newCube.position, newCube);
    }

    public Cube4D getCubeAtPosition(Vector4D position){
        if(this.positions.containsKey(position)) {
            return this.positions.get(position);
        }else{
            return new Cube4D(position, State.INACTIVE);
        }
    }

    public List<State> getNeighbourStates(Vector4D position){
        List<State> neighbourStates = new LinkedList<>();
        List<Vector4D> vector3DList = Vector4D.getAllVectors();
        for (Vector4D vector3D : vector3DList) {
            Vector4D neighbour = vector3D.addVector(position);
            neighbourStates.add(this.getStateAt(neighbour));
        }
        return neighbourStates;
    }

    public State getStateAt(Vector4D position){
        return this.getCubeAtPosition(position).state;
    }

    public int getAmountActive(){
        return (int) this.positions.values().stream().filter(cube -> cube.state==State.ACTIVE).count();
    }
}
