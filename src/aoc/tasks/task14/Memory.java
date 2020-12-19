package aoc.tasks.task14;

import aoc.tasks.task8.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {
    private Map<Integer, Long> memory;
    private BitMask bitMask;
    public Memory() {
        this.memory = new HashMap<>();
    }

    public void setBitMask(BitMask bitMask) {
        this.bitMask = bitMask;
    }

    private void saveInMemory(int memoryAddress, long maskedValue){
        this.memory.put(memoryAddress, maskedValue);
    }

    public void saveInMemory(int memoryAddress, char[] binary36) throws Exception{
        assert this.bitMask != null;
        this.saveInMemory(memoryAddress,  this.bitMask.apply(binary36));
    }

    public void executeCommands(List<MemoryCommand> commands){
        for (MemoryCommand command : commands) {
            command.executeOnMemory(this);
        }
    }

    public Map<Integer, Long> getMemory() {
        return memory;
    }
}
