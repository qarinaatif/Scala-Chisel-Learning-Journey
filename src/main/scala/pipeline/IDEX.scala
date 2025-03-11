package pipeline
import chisel3._
import chisel3.util._

class IDEX extends Module {
  val io = IO(new Bundle {
    val PC = Input(UInt(32.W))
    val Read1 = Input(UInt(32.W))
    val Read2 = Input(UInt(32.W))
    val Immd = Input(UInt(32.W))
    val RD = Input(UInt(5.W))
    val INSTR = Input(UInt(32.W))
    val Branch = Input(Bool())
    val MemRead = Input(Bool())
    val MemtoReg = Input(Bool())
    val ALUOp = Input(Bool())
    val MemWrite = Input(Bool())
    val AluSrc = Input(Bool())
    val RegWrite = Input(Bool())
    val RS1 = Input(UInt(32.W))
    val RS2 = Input(UInt(32.W))
    val PCEX = Output(UInt(32.W))
    val Read1EX = Output(UInt(32.W))
    val Read2EX = Output(UInt(32.W))
    val ImmdDEX = Output(UInt(32.W))
    val RDD = Output(UInt(5.W))
    val INSTREX = Output(UInt(32.W))
    val BranchS = Output(Bool())
    val MemReadS = Output(Bool())
    val MemtoRegS = Output(Bool())
    val ALUOpS = Output(Bool())
    val MemWriteS = Output(Bool())
    val AluSrcS = Output(Bool())
    val RegWriteS = Output(Bool())
    val RS1EX = Output(UInt(32.W))
    val RS2EX = Output(UInt(32.W))


  })

  val PC_reg = RegNext(io.PC,0.U(32.W))
  val Read1_reg = RegNext(io.Read1,0.U(32.W))
  val Read2_reg = RegNext(io.Read2,0.U(32.W))
  val Immd_reg = RegNext(io.Immd,0.U(32.W))
  val RD_reg = RegNext(io.RD,0.U(32.W))
  val INSTREX_reg = RegNext(io.INSTR,0.U(32.W))
  val Branch_reg = RegNext(io.Branch,0.U(32.W))
  val MemRead_reg = RegNext(io.MemRead,0.U(32.W))
  val MemtoReg_reg = RegNext(io.MemtoReg,0.U(32.W))
  val ALUOp_reg = RegNext(io.ALUOp,0.U(32.W))
  val MemWrite_reg = RegNext(io.MemWrite,0.U(32.W))
  val AluSrc_reg = RegNext(io.AluSrc,0.U(32.W))
  val RegWrite_reg = RegNext(io.RegWrite,0.U(32.W))
  val RS1_reg = RegNext(io.RegWrite,0.U(32.W))
  val RS2_reg = RegNext(io.RegWrite,0.U(32.W))

  io.PCEX := PC_reg
  io.Read1EX := Read1_reg
  io.Read2EX := Read2_reg
  io.ImmdDEX := Immd_reg
  io.RDD := RD_reg
  io.INSTREX := INSTREX_reg
  io.BranchS := Branch_reg 
  io.MemReadS := MemRead_reg 
  io.MemtoRegS := MemtoReg_reg  
  io.ALUOpS := ALUOp_reg  
  io.MemWriteS := MemWrite_reg  
  io.AluSrcS := AluSrc_reg  
  io.RegWriteS := RegWrite_reg  
  io.RS1EX := RS1_reg
  io.RS2EX := RS2_reg
}



