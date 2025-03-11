package SingleCycle
import chisel3._
import chisel3.util._

class ImmediateGeneration extends Module {
    val io = IO(new Bundle{
        val instruction = Input(UInt(32.W))
        val immd_se = Output(UInt(32.W))
    })
        val opcode = io.instruction(6,0)
        val imm_default = 0.U(32.W)
        val immd_se = Wire(UInt(32.W))

    immd_se := imm_default  

  switch(opcode) {
    is("b0000011".U ) { 
      val imm_i = io.instruction(31,20)
      immd_se := imm_i
    }
    is("b0001111".U ) { 
      val imm_i = io.instruction(31,20)
      immd_se := imm_i
    }
    is("b0010011".U ) { 
      val imm_i = io.instruction(31,20)
      immd_se := imm_i
    }
    is("b1100111".U ) { 
      val imm_i = io.instruction(31,20)
      immd_se := imm_i
    }
    is("b1110011".U ) { 
      val imm_i = io.instruction(31,20)
      immd_se := imm_i
    }
    is("b0100011".U) {  
      val imm_s = Cat(io.instruction(31,25),io.instruction(11,7))
      immd_se := imm_s
    }
    is("b1100011".U) {
      val imm_b = Cat(io.instruction(31),io.instruction(7),io.instruction(30,25),io.instruction(11,8))  
      immd_se := imm_b
    }
    is("b0010111".U ) { 
      val imm_u = io.instruction(31, 12) 
      immd_se := imm_u
    }
    is("b0110111".U ) { 
      val imm_u = io.instruction(31, 12) 
      immd_se := imm_u
    }
    is("b1101111".U) {  
      val imm_j = Cat(io.instruction(31),io.instruction(19,12),io.instruction(20),io.instruction(30,21))
      immd_se := imm_j
    }
  }
  io.immd_se := immd_se.asUInt()
}

