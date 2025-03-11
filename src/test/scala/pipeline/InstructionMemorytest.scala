package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class InstructionMemorytest extends FreeSpec with ChiselScalatestTester{
    "InstructionMemorytest Test" in {
        test(new InstructionMemory("src/test/scala/SingleCycle/instructionmemory.txt")) { c =>
            c.io.readadress.poke(1.U)
            c.clock.step(1)
            c.io.readdata.expect(20971795.U)
    }}
}