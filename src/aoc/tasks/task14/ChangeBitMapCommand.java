package aoc.tasks.task14;

public class ChangeBitMapCommand extends MemoryCommand {
    private BitMask bitMask;

    public ChangeBitMapCommand(BitMask bitMask) {
        this.bitMask = bitMask;
    }

    @Override
    public void executeOnMemory(Memory memory) {
        memory.setBitMask(this.bitMask);
    }

    @Override
    public String toString() {
        return "ChangeBitMapCommand{" +
                "bitMask=" + bitMask +
                '}';
    }
}
