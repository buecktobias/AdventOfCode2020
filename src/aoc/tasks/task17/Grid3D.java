package aoc.tasks.task17;

import aoc.helper.Vector3D;

import java.util.*;

public class Grid3D {
    private Map<Vector3D, Cube> positions;

    public Grid3D(){
        int range = 30;
        this.positions = new HashMap<>();
        for(int x=-range; x < range; x++){
            for(int y= -range; y < range; y++){
                for(int z= -range; z < range; z++){
                    this.addCube(new Cube(new Vector3D(x,y,z), State.INACTIVE));
                }
            }
        }
    }

    public Grid3D(Map<Vector3D, Cube> positions) {
        this.positions = positions;
    }

    public Grid3D nextCycle(){
        Grid3D oldGrid = this;
        Grid3D newGrid = new Grid3D();
        Collection<Cube> cubes = positions.values();
        for (Cube cube : cubes) {
            cube.nextCycle(oldGrid, newGrid);
        }
        return newGrid;
    }


    public void setCubeAtActive(Vector3D position){
        this.positions.get(position).state = State.ACTIVE;
    }

    public void addCube(Cube newCube){
        positions.put(newCube.position, newCube);
    }

    public Cube getCubeAtPosition(Vector3D position){
        if(this.positions.containsKey(position)) {
            return this.positions.get(position);
        }else{
            return new Cube(position, State.INACTIVE);
        }
    }

    public List<State> getNeighbourStates(Vector3D position){
        List<State> neighbourStates = new LinkedList<>();
        List<Vector3D> vector3DList = Vector3D.getAllVectors();
        for (Vector3D vector3D : vector3DList) {
            Vector3D neighbour = vector3D.addVector(position);
            neighbourStates.add(this.getStateAt(neighbour));
        }
        return neighbourStates;
    }

    public State getStateAt(Vector3D position){
        return this.getCubeAtPosition(position).state;
    }

    public int getAmountActive(){
        return (int) this.positions.values().stream().filter(cube -> cube.state==State.ACTIVE).count();
    }

}
