package SingleCycle
import chisel3._
import chiseltest._
import org.scalatest._

class AluopGenerationtest extends FreeSpec with ChiselScalatestTester {
  "AluopGenerationtest" in {
    test(new AluopGeneration()) { c =>
      c.io.opcode.poke("b0110011".U)    
      c.io.aluop.expect("b10".U)

    }
  }
}
