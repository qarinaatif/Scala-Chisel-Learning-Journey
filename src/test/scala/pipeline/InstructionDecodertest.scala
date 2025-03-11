package SingleCycle
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class InstructionDecodertest extends FreeSpec with ChiselScalatestTester{
    "InstructionDecoder Test" in {
        test(new InstructionDecoder) { c =>
            c.io.instruction.poke("b00000000011000101000010100110011".U)
            c.clock.step(1)
            c.io.opcode.expect("b0110011".U)
            c.io.rd.expect("b01010".U)
            c.io.rs1.expect("b00101".U)
            c.io.rs2.expect("b00110".U)
            c.io.func3.expect("b000".U)
            c.io.func7.expect("b0000000".U)
    }}
}