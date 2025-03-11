package SingleCycle
import chisel3._
import chisel3.util._

class InstructionDecoder extends Module {
    val io = IO(new Bundle{
        val instruction = Input(UInt(32.W))
        val opcode = Output(UInt(7.W))
        val rd = Output(UInt(5.W))
        val func7 = Output(UInt(7.W))
        val func3 = Output(UInt(3.W))
        val rs1 = Output(UInt(5.W))
        val rs2 = Output(UInt(5.W))

    })
        val opcode = io.instruction(6,0)
        val rd = io.instruction(11,7)
        val func7 = io.instruction(31,25)
        val func3 = io.instruction(14,12)
        val rs1 = io.instruction(19,15)
        val rs2 = io.instruction(24,20)

        io.opcode := opcode
        io.rd := rd
        io.func7 := func7
        io.func3 := func3
        io.rs1 := rs1
        io.rs2 := rs2

}

