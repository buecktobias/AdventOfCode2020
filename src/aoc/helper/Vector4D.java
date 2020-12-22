package aoc.helper;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Vector4D {
    public int x;
    public int y;
    public int z;
    public int w;

    public Vector4D(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static List<Vector4D> getAllVectors(){
        List<Vector4D> vector3DList = new LinkedList<>();
        for(int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    for (int w = -1; w <= 1; w++) {
                        if (x == 0 && y == 0 && z == 0 && w == 0) {
                            continue;
                        }
                        vector3DList.add(new Vector4D(x, y, z, w));
                    }
                }
            }
        }
        return vector3DList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector4D vector4D = (Vector4D) o;
        return x == vector4D.x && y == vector4D.y && z == vector4D.z && w == vector4D.w;
    }

    public Vector4D addVector(Vector4D vector4D){
        return new Vector4D(vector4D.x + this.x, vector4D.y + y, vector4D.z + z, vector4D.w + w);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "Vector4D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", w =" + w +
                '}';
    }
}
