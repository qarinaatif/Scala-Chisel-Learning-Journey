package pipeline
import chisel3._
import chisel3.util._

class MEMWB extends Module {
  val io = IO(new Bundle {
    val ReadData = Input(UInt(32.W))
    val ALUres = Input(UInt(32.W))
    val RD = Input(UInt(32.W))
    val MemtoReg = Input(Bool())
    val RegWrite = Input(Bool())
    val ReadDataWB = Output(UInt(32.W))
    val ALUresWB = Output(UInt(32.W))
    val RDD = Output(UInt(32.W))
    val MemtoRegS = Output(Bool())
    val RegWriteS = Output(Bool())
  })

  val ReadData_reg = RegNext(io.ReadData,0.U(32.W))
  val ALUres_reg = RegNext(io.ALUres,0.U(32.W))
  val RD_reg = RegNext(io.RD,0.U(32.W))
  val MemtoReg_reg = RegNext(io.MemtoReg,0.U(32.W))
  val RegWrite_reg = RegNext(io.RegWrite,0.U(32.W))

  io.ReadDataWB := ReadData_reg
  io.ALUresWB := ALUres_reg
  io.RDD := RD_reg
  io.MemtoRegS := MemtoReg_reg  
  io.RegWriteS := RegWrite_reg  

}


