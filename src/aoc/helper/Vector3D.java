package aoc.helper;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Vector3D {
    public int x;
    public int y;
    public int z;

    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static List<Vector3D> getAllVectors(){
        List<Vector3D> vector3DList = new LinkedList<>();
        for(int x = -1; x<= 1; x++){
            for(int y = -1; y <= 1; y++){
                for(int z=-1; z <= 1; z++){
                    if(x == 0 && y == 0 && z==0){
                        continue;
                    }
                    vector3DList.add(new Vector3D(x, y, z));
                }
            }
        }
        return vector3DList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return x == vector3D.x && y == vector3D.y && z == vector3D.z;
    }

    public Vector3D addVector(Vector3D vector3D){
        return new Vector3D(vector3D.x + this.x, vector3D.y + y, vector3D.z + z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
