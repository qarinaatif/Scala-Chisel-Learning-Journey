package SingleCycle
import chisel3._
import chiseltest._
import org.scalatest._

class Alucontroltest extends FreeSpec with ChiselScalatestTester {
  "Alucontrol" in {
    test(new Alucontrol()) { c =>
        c.io.opcode.poke("b0110011".U)  
        c.io.func3.poke("b000".U)  
        c.io.func7.poke("b0100000".U)  
        c.io.aluop.poke("b10".U)  
        c.io.aluctrl.expect("b000001".U)

        c.io.opcode.poke("b0110011".U)  
        c.io.func3.poke("b000".U)  
        c.io.func7.poke("b0000000".U)  
        c.io.aluop.poke("b10".U)  
        c.io.aluctrl.expect("b000000".U)


    }
  }
}
