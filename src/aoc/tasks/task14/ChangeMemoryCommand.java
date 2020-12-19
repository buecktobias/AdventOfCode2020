package aoc.tasks.task14;

public class ChangeMemoryCommand extends MemoryCommand{
    private int newMemoryValue;
    private int memoryAdress;

    public ChangeMemoryCommand(int newMemoryValue, int memoryAddress) {
        this.newMemoryValue = newMemoryValue;
        this.memoryAdress = memoryAddress;
    }

    @Override
    public void executeOnMemory(Memory memory) {
        try {
            memory.saveInMemory(this.memoryAdress, Binary.to36Bit(this.newMemoryValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ChangeMemoryCommand{" +
                "newMemoryValue=" + newMemoryValue +
                ", memoryAdress=" + memoryAdress +
                '}';
    }
}
